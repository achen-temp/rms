package com.login.loginsys.dao;

import com.login.loginsys.dto.ResultDTO;
import com.login.loginsys.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.login.loginsys.constants.DTOConstants.*;
import static com.login.loginsys.constants.SQLConstants.CREATE_PROFILE;

@Repository
public class RegisterDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //first check email validation
    //select try throw

    public ResultDTO createProfile(RegisterModel registerModel) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setFlow(REGISTER);
        resultDTO.setStatus(SUCCESS);

        try {
            jdbcTemplate.update(CREATE_PROFILE, new Object[]{
                    registerModel.getFirstName(),
                    registerModel.getLastName(),
                    registerModel.getPassword(),
                    registerModel.getChnName(),
                    registerModel.getEmail(),
                    registerModel.getCreatedBy(),
                    registerModel.getCreatedOn(),
                    registerModel.getUpdatedBy()
            });
        } catch (DuplicateKeyException e) {
            resultDTO.setStatus(FAILURE);
            resultDTO.setErrorMessage(USER_EXISTS_ERROR_MESSAGE);
        } catch (Exception e) {
            resultDTO.setStatus(FAILURE);
            resultDTO.setErrorMessage(RUN_TIME_ERROR_MESSAGE);
        }

        return resultDTO;


        //need try catch set status return error message
        //return resultDto
        //add json in pom.xml
        //email error message
        //catch error message


    }
}
