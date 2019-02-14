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
  employee_id int not null,
  Created_By VARCHAR(100) DEFAULT 'dbo',
  Created_On DATETIME DEFAULT CURRENT_TIMESTAMP,
  Update_By VARCHAR(100) DEFAULT 'dbo',
  Update_Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT PK_UserLogin PRIMARY KEY (UserId)
);

/*  timesheet */
drop table dbo.timesheet;

CREATE TABLE dbo.timesheet (
  timesheet_id INT AUTO_INCREMENT,
  time_from DATE NOT NULL,
  time_to DATE NOT NULL,
  employee_id INT NOT NULL,
  project_id INT NOT NULL,
  comments varchar(500),
  date_submitted DATETIME DEFAULT CURRENT_TIMESTAMP,
  status VARCHAR(10),
  total DECIMAL(10,2),
  manager_comments VARCHAR(500),
  Created_By VARCHAR(100) DEFAULT 'dbo',
  Created_On DATETIME DEFAULT CURRENT_TIMESTAMP,
  Update_By VARCHAR(100) DEFAULT 'dbo',
  Update_Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT PK_timesheet PRIMARY KEY (timesheet_id,time_from,time_to)
);

drop table dbo.timesheet_details;

CREATE TABLE dbo.timesheet_details (
  timesheet_id INT NOT NULL,
  day VARCHAR(10),
  date DATE,
  regular_hour DECIMAL(10, 2),
  pto DECIMAL(10, 2),
  federal_holiday INT,
  Created_By VARCHAR(100) DEFAULT 'dbo',
  Created_On DATETIME DEFAULT CURRENT_TIMESTAMP,
  Update_By VARCHAR(100) DEFAULT 'dbo',
  Update_Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT PK_timesheet_details PRIMARY KEY (timesheet_id,timesheet_day,timesheet_date)
);

CREATE TABLE dbo.employee_profile_temp (
  employee_id INT NOT NULL,
  role_id INT,
  project_id INT,
  employee_name VARCHAR(100),
  manager_id INT,
  timesheet_start_date DATE NOT NULL,
  Created_By VARCHAR(100) DEFAULT 'dbo',
  Created_On DATETIME DEFAULT CURRENT_TIMESTAMP,
  Update_By VARCHAR(100) DEFAULT 'dbo',
  Update_Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT PK_employee_profile PRIMARY KEY (employee_id)
);

CREATE TABLE dbo.project (
  project_id INT NOT NULL,
  project_name VARCHAR(100),
  internal VARCHAR(1),
  Created_By VARCHAR(100) DEFAULT 'dbo',
  Created_On DATETIME DEFAULT CURRENT_TIMESTAMP,
  Update_By VARCHAR(100) DEFAULT 'dbo',
  Update_Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT PK_project PRIMARY KEY (project_id)
);

CREATE TABLE dbo.user_role (
  role_id INT NOT NULL,
  role_name VARCHAR(30),
  Created_By VARCHAR(100) DEFAULT 'dbo',
  Created_On DATETIME DEFAULT CURRENT_TIMESTAMP,
  Update_By VARCHAR(100) DEFAULT 'dbo',
  Update_Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT PK_user_role PRIMARY KEY (role_id)
)
