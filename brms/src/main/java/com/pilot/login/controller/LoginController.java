package com.pilot.login.controller;

import com.pilot.login.utils.DTOConstants;
import com.pilot.login.dto.ResultDTO;
import com.pilot.login.model.AccountModel;
import com.pilot.login.model.login.LoginModel;
import com.pilot.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;


@RestController
@RequestMapping("/")
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping(value = "/testConnection")
    public ResultDTO testRestConnection(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ResultDTO dto = new ResultDTO();
        dto.setStatus(DTOConstants.SUCCESS);
        dto.setErrorMessage(timestamp.toString());
        return dto;
    }

    //login
    @PostMapping(
            value = "/login",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public AccountModel loginValidateByPW(@RequestBody LoginModel loginModel) {
        System.out.println(loginModel.toString());
        return loginService.loginValidateByPW(loginModel);
    }

    //check email validation
    @GetMapping(
            value = "/forgetpw/{email}"
    )
    public ResponseEntity<LoginModel> forgetPW(@PathVariable String email) {

        LoginModel loginModel = loginService.forgetPW(email);
        return new ResponseEntity<LoginModel>(loginModel, HttpStatus.OK);
    }

    //reset password
    @PostMapping(
            value = "/resetpw",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResultDTO resetPW(@RequestBody LoginModel loginModel) {

        return loginService.resetPW(loginModel);
    }

    //email verification code
    @GetMapping(
            value = "/emailcode/{email}"
    )
    public ResponseEntity<ResultDTO> emailVerifyCode(@PathVariable String email) {
        ResultDTO resultDTO = loginService.emailVerifyCode(email);
        return new ResponseEntity<ResultDTO>(resultDTO, HttpStatus.OK);
    }

    //verify code
    @PostMapping(
            value = "/checkcode",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResultDTO verifyCodeValidation(@RequestBody AccountModel accountModel) {
        return loginService.verifyCodeValidation(accountModel);
    }

    //create jwt
    @PostMapping(
            value = "/rememberme",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public AccountModel rememberMe(@RequestBody LoginModel loginModel) {
        return loginService.rememberMe(loginModel);
    }

    //verify jwt
    @PostMapping(
            value = "/verifyjwt",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public AccountModel verifyJWT(@RequestBody AccountModel accountModel) {
        return loginService.verifyJWT(accountModel);
    }

}
