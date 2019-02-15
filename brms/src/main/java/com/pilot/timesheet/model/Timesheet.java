package com.pilot.timesheet.model;

import com.pilot.timesheet.dto.ResultDTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TIMESHEET")
public class Timesheet extends ResultDTO {
    @EmbeddedId
    private  TimeInfo timeInfo;

    @NotBlank
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    @NotBlank
    @Column(name = "PROJECT_ID")
    private int projectId;

//    @Column(name = "TIMESHEET_ID")
//    private int timesheetId;
//
//    @Column(name = "TIME_FROM")
//    private Date time_from;
//
//    @Column(name = "TIME_TO")
//    private Date time_to;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "DATE_SUBMITTED")
    private Date date_submitted;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "TOTAL")
    private int total;

    @Column(name = "MANAGER_COMMENTS")
    private String manager_comments;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private Date createdOn;

    @Column(name = "Update_By")
    private String updateBy;

    @Column(name = "Update_Timestamp")
    private Date updateTimestamp;

    @Embeddable
    public class TimeInfo implements Serializable{
        @Column(name = "TIMESHEET_ID")
        private int timesheetId;

        @Column(name = "TIME_FROM")
        private Date time_from;

        @Column(name = "TIME_TO")
        private Date time_to;

        public int getTimesheetId() {
            return timesheetId;
        }

        public void setTimesheetId(int timesheetId) {
            this.timesheetId = timesheetId;
        }

        public Date getTime_from() {
            return time_from;
        }

        public void setTime_from(Date time_from) {
            this.time_from = time_from;
        }

        public Date getTime_to() {
            return time_to;
        }

        public void setTime_to(Date time_to) {
            this.time_to = time_to;
        }

        public TimeInfo(int timesheetId, Date time_from, Date time_to) {
            this.timesheetId = timesheetId;
            this.time_from = time_from;
            this.time_to = time_to;
        }

        public TimeInfo() {
        }
    }

}
