package com.login.loginsys.service;

import com.login.loginsys.dao.LoginDAO;
import com.login.loginsys.dto.ResultDTO;
import com.login.loginsys.model.AccountModel;
import com.login.loginsys.model.JWTModel;
import com.login.loginsys.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public AccountModel loginValidateByPW(LoginModel loginModel) {
        return loginDAO.loginValidateByPW(loginModel);
    }

    public LoginModel forgetPW(String email) {
        return loginDAO.forgetPW(email);
    }

    public ResultDTO resetPW(LoginModel loginModel) {
        return loginDAO.resetPW(loginModel);
    }

    public ResultDTO emailVerifyCode(String email) {
        return loginDAO.emailVerifyCode(email);
    }

    public ResultDTO verifyCodeValidation(AccountModel accountModel) {
        return loginDAO.verifyCodeValidation(accountModel);
    }

    public AccountModel rememberMe(LoginModel loginModel) {
        return loginDAO.rememberMe(loginModel);
    }

    public AccountModel verifyJWT(AccountModel accountModel) {
        return loginDAO.verifyJWT(accountModel);
    }

}
