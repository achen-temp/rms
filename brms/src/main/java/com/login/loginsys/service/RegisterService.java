package com.login.loginsys.service;

import com.login.loginsys.dao.RegisterDAO;
import com.login.loginsys.dto.ResultDTO;
import com.login.loginsys.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterDAO registerDAO;

    public void setRegisterDAO(RegisterDAO registerDAO) {
        this.registerDAO = registerDAO;
    }

    public ResultDTO createProfile(RegisterModel registerModel) {
        return registerDAO.createProfile(registerModel);
    }
}
