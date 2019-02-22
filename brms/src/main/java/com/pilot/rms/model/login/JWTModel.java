package com.pilot.rms.model.login;

import com.pilot.rms.dto.ResultDTO;

public class JWTModel extends ResultDTO {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
