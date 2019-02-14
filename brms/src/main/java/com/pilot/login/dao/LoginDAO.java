package com.pilot.login.dao;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pilot.login.dto.ResultDTO;
import com.pilot.login.model.AccountModel;
import com.pilot.login.model.JWTModel;
import com.pilot.login.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import static com.pilot.login.constants.DTOConstants.*;
import static com.pilot.login.constants.SQLConstants.*;

import javax.mail.*;
import javax.mail.internet.*;


@Repository
public class LoginDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //use find method
    //return accountModule
    public AccountModel loginValidateByPW(LoginModel loginModel) {

        AccountModel accountModel = new AccountModel();
        accountModel.setFlow(LOGIN);
        accountModel.setStatus(SUCCESS);

        try {
            accountModel = jdbcTemplate.queryForObject(
                    USER_LOGIN,
                    new Object[] {loginModel.getEmail(), loginModel.getPassword()},
                    new AccountMapper()
            );
        } catch (EmptyResultDataAccessException e) {
            //get error message from resultDto
            //wrong email or password
            accountModel.setStatus(FAILURE);
            accountModel.setErrorMessage(USER_INFO_INCORRECT_ERROR_MESSAGE);
        } catch (Exception e) {
            //error message
            accountModel.setStatus(FAILURE);
            accountModel.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return accountModel;

    }

    public class AccountMapper implements RowMapper<AccountModel> {
        public AccountModel mapRow(ResultSet rs, int i) throws SQLException {

            AccountModel accountModel = new AccountModel();
            accountModel.setId(rs.getInt("userid"));
            accountModel.setFirstName(rs.getString("firstname"));
            accountModel.setLastName(rs.getString("lastname"));
            accountModel.setEmail(rs.getString("email"));
            accountModel.setPassword(rs.getString("password"));
            accountModel.setChnName(rs.getString("chinesename"));
            accountModel.setCreatedBy(rs.getString("created_by"));
            accountModel.setCreatedOn(rs.getString("created_on"));
            accountModel.setUpdatedBy(rs.getString("update_by"));
            accountModel.setUpdatedOn(rs.getString("update_timestamp"));
            accountModel.setVerifyCode(rs.getString("verification_code"));
            accountModel.setToken(rs.getString("token"));
            accountModel.setFlow(LOGIN);
            accountModel.setStatus(SUCCESS);

            return accountModel;
        }
    }

    //if forget password check email validation
    public LoginModel forgetPW(String email) {

        LoginModel loginModel = new LoginModel();
        loginModel.setFlow(FORGET_PW);
        loginModel.setStatus(SUCCESS);

        try {
            jdbcTemplate.queryForObject(
                    FORGET_PW_SQL,
                    new Object[] {email},
                    new LoginMapper()
            );

            loginModel.setEmail(email);

        } catch (EmptyResultDataAccessException e) {
            //get error message from resultDto
            //wrong email
            loginModel.setStatus(FAILURE);
            loginModel.setErrorMessage(EMAIL_ERROR_MESSAGE);
        } catch (Exception e) {
            //error message
            loginModel.setStatus(FAILURE);
            loginModel.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return loginModel;
    }

    public class LoginMapper implements RowMapper<LoginModel> {
        public LoginModel mapRow(ResultSet rs, int i) throws SQLException {

            LoginModel loginModel = new LoginModel();
            loginModel.setEmail(rs.getString("email"));
            loginModel.setPassword(rs.getString("password"));
            loginModel.setFlow(FORGET_PW);
            loginModel.setStatus(SUCCESS);

            return loginModel;
        }
    }

    //reset password
    public ResultDTO resetPW(LoginModel loginModel) {

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setFlow(RESET_PW);
        resultDTO.setStatus(SUCCESS);

        try {
            jdbcTemplate.update(RESET_PW_SQL, new Object[]{
                    loginModel.getPassword(),
                    loginModel.getEmail()
            });
//        } catch (DuplicateKeyException e) {
//            //reset same password error
//            resultDTO.setStatus(FAILURE);
//            resultDTO.setErrorMessage(SAME_PASSWORD_ERROR_MESSAGE);
        } catch (Exception e) {
            //error message
            resultDTO.setStatus(FAILURE);
            resultDTO.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return resultDTO;
    }

    //email verification code
    public ResultDTO emailVerifyCode(String email) {

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setFlow(EMAIL_CODE);
        resultDTO.setStatus(SUCCESS);

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //modify USERNAME + PASSWORD in DTOConstants
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Reset Your BHT Password");

            //generate a random verification code
            String code = createVerifyCode();
            message.setText("Your verification code is " + code);

            //find user by email and add code into account
            addCode(email, code);

            Transport.send(message);

        } catch (MessagingException e) {
            resultDTO.setStatus(FAILURE);
            resultDTO.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
            throw new RuntimeException(e);
        }

        return resultDTO;

    }

    //add expiration time??
    //generate a random verification code with 6 capital characters and numbers
    protected String createVerifyCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder code = new StringBuilder();
        Random rnd = new Random();

        while (code.length() < 6) {
            int index = (int)(rnd.nextFloat() * chars.length());
            code.append(chars.charAt(index));
        }

        return code.toString();
    }

    //add verification code to account
    public ResultDTO addCode(String email, String code) {

        ResultDTO resultDTO = new ResultDTO();

        try {
            jdbcTemplate.update(
                    ADD_VERIFICATION_CODE,
                    new Object[] {code, email}
            );

//        } catch (EmptyResultDataAccessException e) {
//            //wrong email
//            resultDTO.setStatus(FAILURE);
//            resultDTO.setErrorMessage(USER_INFO_INCORRECT_ERROR_MESSAGE);
        } catch (Exception e) {
            //error message
            resultDTO.setStatus(FAILURE);
            resultDTO.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return resultDTO;
    }

    //verification code validation
    public ResultDTO verifyCodeValidation(AccountModel accountModel) {

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setFlow(CODE_VALIDATION);
        resultDTO.setStatus(SUCCESS);

        try {
            jdbcTemplate.queryForObject(
                    CODE_VALIDATION_SQL,
                    new Object[] {accountModel.getEmail(), accountModel.getVerifyCode()},
                    new AccountMapper()
            );

        } catch (EmptyResultDataAccessException e) {
            //wrong verification code
            resultDTO.setStatus(FAILURE);
            resultDTO.setErrorMessage(VERIFICATION_CODE_ERROR_MESSAGE);
        } catch (Exception e) {
            //error message
            resultDTO.setStatus(FAILURE);
            resultDTO.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return resultDTO;
    }

    /*****************************************************
    *  create + sign jwt token
    ******************************************************/
    public AccountModel rememberMe(LoginModel loginModel) {

        AccountModel accountModel = new AccountModel();
        accountModel.setFlow(REMEMBER_ME);
        accountModel.setStatus(SUCCESS);

        JWTModel jwtModel = new JWTModel();

        //check if email + password are valid
        if (accountVerification(loginModel).getStatus() == "success") {

            //create jwt
            jwtModel = createJWT(loginModel);

            //add token
            addToken(loginModel.getEmail(), jwtModel.getJwt());

            //call login
            accountModel = loginValidateByPW(loginModel);

        } else {
            //return error message
            accountModel.setStatus(accountVerification(loginModel).getStatus());
            accountModel.setErrorMessage(accountVerification(loginModel).getErrorMessage());
        }

        return accountModel;

    }

    //email + password verification
    public LoginModel accountVerification(LoginModel loginModel) {

        LoginModel tempLoginModel = new LoginModel();
        tempLoginModel.setFlow(REMEMBER_ME);
        tempLoginModel.setStatus(SUCCESS);

        try {
            //email + password verification
            tempLoginModel = jdbcTemplate.queryForObject(
                    USER_LOGIN,
                    new Object[] {loginModel.getEmail(), loginModel.getPassword()},
                    new LoginMapper()
            );

        } catch (EmptyResultDataAccessException e) {
            //get error message from resultDto
            //wrong email or password
            tempLoginModel.setStatus(FAILURE);
            tempLoginModel.setErrorMessage(USER_INFO_INCORRECT_ERROR_MESSAGE);
        } catch (Exception e) {
            //error message
            tempLoginModel.setStatus(FAILURE);
            tempLoginModel.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return tempLoginModel;
    }

    //create jwt
    public JWTModel createJWT(LoginModel loginModel) {

        JWTModel jwtModel = new JWTModel();
        jwtModel.setFlow(REMEMBER_ME);
        jwtModel.setStatus(SUCCESS);

        //15 days
        final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 15;

        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withSubject(loginModel.getEmail())
                    .withClaim("password", loginModel.getPassword())
                    .withIssuedAt(new Date(System.currentTimeMillis()))
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(algorithm);

            jwtModel.setJwt(token);

        } catch (JWTCreationException e) {
            //Invalid Signing configuration / Couldn't convert Claims.
            jwtModel.setStatus(FAILURE);
            jwtModel.setErrorMessage(JWT_CREATION_ERROR_MESSAGE);
        }

        return jwtModel;
    }

    //add jwt into account
    public ResultDTO addToken(String email, String token) {

        ResultDTO resultDTO = new ResultDTO();

        try {
            jdbcTemplate.update(
                    ADD_JWT_TOKEN,
                    new Object[] {token, email}
            );

//        } catch (EmptyResultDataAccessException e) {
//            //wrong email
//            resultDTO.setStatus(FAILURE);
//            resultDTO.setErrorMessage(USER_INFO_INCORRECT_ERROR_MESSAGE);
        } catch (Exception e) {
            //error message
            resultDTO.setStatus(FAILURE);
            resultDTO.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return resultDTO;
    }

    /****************************************************
    * verify jwt token
    * compared with the jwt saved in db
    *****************************************************/
    public AccountModel verifyJWT(AccountModel accountModel) {

        AccountModel tempAccountModel = new AccountModel();
        tempAccountModel.setFlow(VERIFY_JWT);
        tempAccountModel.setStatus(SUCCESS);

        //call getJWTEmail to get email from jwt
        String email = getJWTEmail(accountModel);

        //jwt validation, compared with the token saved in db
        if (validJWT(email, accountModel).getStatus() == "success") {

            //login in and get account info
            tempAccountModel = getAccountInfo(validJWT(email, accountModel));
            tempAccountModel.setFlow(VERIFY_JWT);

        } else {
            //return error message
            tempAccountModel.setStatus(validJWT(email, accountModel).getStatus());
            tempAccountModel.setErrorMessage(validJWT(email, accountModel).getErrorMessage());
        }

        return tempAccountModel;

    }

    //verify and get email from jwt
    public String getJWTEmail(AccountModel accountModel) {

        String email = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(accountModel.getToken());
            email = jwt.getSubject();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }

        return email;
    }

    //jwt validation -- compared with the token saved in db
    public AccountModel validJWT(String email, AccountModel accountModel) {

        AccountModel tempAccountModel = new AccountModel();
        tempAccountModel.setFlow(VERIFY_JWT);
        tempAccountModel.setStatus(SUCCESS);

        try {
            tempAccountModel = jdbcTemplate.queryForObject(
                    JWT_VALICATION,
                    new Object[] {email, accountModel.getToken()},
                    new AccountMapper()
            );

        } catch (EmptyResultDataAccessException e) {
            //wrong verification code
            tempAccountModel.setStatus(FAILURE);
            tempAccountModel.setErrorMessage(JWT_VERIFICATION_ERROR_MASSAGE);
        } catch (Exception e) {
            //error message
            tempAccountModel.setStatus(FAILURE);
            tempAccountModel.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return tempAccountModel;
    }

    //login in and get account info from db
    public AccountModel getAccountInfo(AccountModel accountModel) {

        LoginModel loginModel = new LoginModel();
        loginModel.setEmail(accountModel.getEmail());
        loginModel.setPassword(accountModel.getPassword());

        return loginValidateByPW(loginModel);
    }

}
