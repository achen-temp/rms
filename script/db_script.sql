/************************************************************/
/******************Database Script***************************/
/************************************************************/

/* UserLogin table */
CREATE TABLE dbo.userlogin (
  userid INT AUTO_INCREMENT,
  FirstName VARCHAR(30) NOT NULL,
  LastName VARCHAR(30) NOT NULL ,
  Password VARCHAR(50) NOT NULL ,
  ChineseName NVARCHAR(10),
  Email VARCHAR(100) UNIQUE NOT NULL,
  verification_code VARCHAR(6),
  token VARCHAR(500),
  Created_By VARCHAR(100) DEFAULT 'dbo',
  Created_On DATETIME DEFAULT CURRENT_TIMESTAMP,
  Update_By VARCHAR(100) DEFAULT 'dbo',
  Update_Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT PK_UserLogin PRIMARY KEY (UserId)
);

/*  timesheet */
