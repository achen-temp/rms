package com.pilot.rms.utils;

public class DTOConstants {
    //status
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    //flow
    public static final String REGISTER = "register";
    public static final String LOGIN = "rms";
    public static final String FORGET_PW = "forgetpw";
    public static final String RESET_PW = "resetpw";
    public static final String EMAIL_CODE = "emailcode";
    public static final String CODE_VALIDATION = "checkcode";
    public static final String REMEMBER_ME = "rememberme";
    public static final String VERIFY_JWT = "verifyjwt";

    //error message
    public static final String RUN_TIME_ERROR_MESSAGE = "Error has occurred";
    public static final String USER_EXISTS_ERROR_MESSAGE = "User already exists";
    public static final String NO_USER_FOUND_ERROR_MESSAGE = "User does not exist";
    public static final String USER_INFO_INCORRECT_ERROR_MESSAGE = "Wrong username or password";
    public static final String EMAIL_ERROR_MESSAGE = "Email does not exist";
    public static final String SAME_PASSWORD_ERROR_MESSAGE = "Password is same as the previous one";
    public static final String VERIFICATION_CODE_ERROR_MESSAGE = "Wrong verification code";
    public static final String JWT_CREATION_ERROR_MESSAGE = "Fail to create jwt";
    public static final String JWT_VERIFICATION_ERROR_MASSAGE = "Wrong jwt";

    //email info
    //add your gmail and password here
    public static final String USERNAME = "";
    public static final String PASSWORD = "";
}
