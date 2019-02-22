package com.pilot.rms.controller;

import com.pilot.rms.dto.ResultDTO;
import com.pilot.rms.model.login.RegisterModel;
import com.pilot.rms.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    // jump to homepage or no status
    @PostMapping(
            value = "/register",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResultDTO createProfile(@RequestBody RegisterModel registerModel) {

        registerModel.setCreatedOn(new Date());

        return registerService.createProfile(registerModel);
    }

}
