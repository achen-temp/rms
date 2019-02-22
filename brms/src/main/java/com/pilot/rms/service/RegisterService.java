package com.pilot.rms.service;

import com.pilot.rms.dao.RegisterDAO;
import com.pilot.rms.dto.ResultDTO;
import com.pilot.rms.model.login.RegisterModel;
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
