package com.login.loginsys.model;

import com.login.loginsys.dto.ResultDTO;

public class JWTModel extends ResultDTO {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
