package com.pilot.login.service;

import com.pilot.login.dao.RegisterDAO;
import com.pilot.login.dto.ResultDTO;
import com.pilot.login.model.login.RegisterModel;
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
