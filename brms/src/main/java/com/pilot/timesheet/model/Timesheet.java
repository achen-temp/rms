package com.pilot.timesheet.model;

import com.pilot.timesheet.dto.ResultDTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TIMESHEET")
public class Timesheet extends ResultDTO {

    @NotBlank
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    @NotBlank
    @Column(name = "PROJECT_ID")
    private int projectId;

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

    @EmbeddedId
    private  TimeInfo timeInfo;

    @Embeddable
    public class TimeInfo implements Serializable{
        @Column(name = "TIMESHEET_ID")
        private int timesheetId;

        @Column(name = "TIME_FROM")
        private Date time_from;

        @Column(name = "TIME_TO")
        private Date time_to;

        public TimeInfo() { }

        public TimeInfo(int timesheetId, Date time_from, Date time_to) {
            this.timesheetId = timesheetId;
            this.time_from = time_from;
            this.time_to = time_to;
        }

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

    }

    public Timesheet() { }

    public Timesheet(String flow, String status, String errorMessage, @NotBlank int employeeId, @NotBlank int projectId, String comments, Date date_submitted, String status1, int total, String manager_comments) {
        super(flow, status, errorMessage);
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.comments = comments;
        this.date_submitted = date_submitted;
        this.status = status1;
        this.total = total;
        this.manager_comments = manager_comments;
    }

    public Timesheet(String flow, String status, String errorMessage, @NotBlank int employeeId, @NotBlank int projectId, String comments, Date date_submitted, String status1, int total, String manager_comments, String createdBy, Date createdOn, String updateBy, Date updateTimestamp, TimeInfo timeInfo) {
        super(flow, status, errorMessage);
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.comments = comments;
        this.date_submitted = date_submitted;
        this.status = status1;
        this.total = total;
        this.manager_comments = manager_comments;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updateBy = updateBy;
        this.updateTimestamp = updateTimestamp;
        this.timeInfo = timeInfo;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate_submitted() {
        return date_submitted;
    }

    public void setDate_submitted(Date date_submitted) {
        this.date_submitted = date_submitted;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getManager_comments() {
        return manager_comments;
    }

    public void setManager_comments(String manager_comments) {
        this.manager_comments = manager_comments;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public TimeInfo getTimeInfo() {
        return timeInfo;
    }

    public void setTimeInfo(TimeInfo timeInfo) {
        this.timeInfo = timeInfo;
    }
}
