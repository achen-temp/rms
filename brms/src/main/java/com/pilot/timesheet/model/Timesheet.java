package com.pilot.timesheet.model;

import com.pilot.timesheet.dto.ResultDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "TIMESHEET")
public class Timesheet extends ResultDTO {

    @Id
    @Column(name = "TIMESHEET_ID")
    private int timesheetId;

    @NotBlank
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    @NotBlank
    @Column(name = "PROJECT_ID")
    private int projectId;

    @Column(name = "TIME_FROM")
    private Date time_from;

    @Column(name = "TIME_TO")
    private Date time_to;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "DATE_SUBMITTED")
    private Date date_submitted;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "MANAGER_COMMENTS")
    private String manager_comments;

    @Column(name = "TOTAL")
    private int total;

    public Timesheet(){}

    public Timesheet(int timesheetId, @NotBlank int employeeId, @NotBlank int projectId, Date time_from, Date time_to, String comments, Date date_submitted, String status, String manager_comments,int total) {
        this.timesheetId = timesheetId;
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.time_from = time_from;
        this.time_to = time_to;
        this.comments = comments;
        this.date_submitted = date_submitted;
        this.status = status;
        this.manager_comments = manager_comments;
        this.total = total;
    }

    public int getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManager_comments() {
        return manager_comments;
    }

    public void setManager_comments(String manager_comments) {
        this.manager_comments = manager_comments;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
