package com.pilot.login.constants;

public class SQLConstants {
    public static final String CREATE_PROFILE =
            "insert into UserLogin (FirstName, LastName, Password, ChineseName, Email, Created_By, Created_On, Update_By) values (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String USER_LOGIN =
            "select * from dbo.UserLogin where Email = ? and Password = ?";

    public static final String FORGET_PW_SQL =
            "select Email, Password from UserLogin where Email = ?";

    public static final String RESET_PW_SQL =
            "update UserLogin set Password = ? where Email = ?";

    public static final String CODE_VALIDATION_SQL =
            "select * from UserLogin where Email = ? and Verification_Code = ?";

    public static final String ADD_VERIFICATION_CODE =
            "update UserLogin set Verification_Code = ? where Email = ?";

    public static final String ADD_JWT_TOKEN =
            "update UserLogin set Token = ? where Email = ?";

    public static final String JWT_VALICATION =
            "select * from UserLogin where Email = ? and Token = ?";

}
