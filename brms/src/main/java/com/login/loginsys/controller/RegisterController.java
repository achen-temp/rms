package com.login.loginsys.controller;

import com.login.loginsys.dto.ResultDTO;
import com.login.loginsys.model.RegisterModel;
import com.login.loginsys.service.RegisterService;
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
