package com.pilot.rms.service;

import com.pilot.rms.dao.LoginDAO;
import com.pilot.rms.dto.ResultDTO;
import com.pilot.rms.model.AccountModel;
import com.pilot.rms.model.login.LoginModel;
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
