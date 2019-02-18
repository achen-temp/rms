package com.pilot.login.dao;

import com.pilot.login.dto.ResultDTO;
import com.pilot.login.model.login.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.pilot.login.utils.DTOConstants.*;
import static com.pilot.login.utils.SQLConstants.CREATE_PROFILE;

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
