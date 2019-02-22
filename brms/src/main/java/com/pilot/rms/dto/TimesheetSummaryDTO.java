package com.pilot.rms.dto;

import com.pilot.rms.model.timesheet.Employee;

import java.util.Date;

public class TimesheetSummaryDTO extends ResultDTO {

    private String projectName;

    private Date weekStartDate;

    private Date weekEndDate;

    private Double hours;

    private String status;

    private Employee manager;

    private Date updateTimestamp;

    public TimesheetSummaryDTO() {
    }

    public TimesheetSummaryDTO(String projectName, Date weekStartDate, Date weekEndDate, Double hours, String status, Employee manager, Date updateTimestamp) {
        this.projectName = projectName;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
        this.hours = hours;
        this.status = status;
        this.manager = manager;
        this.updateTimestamp = updateTimestamp;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(Date weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public Date getWeekEndDate() {
        return weekEndDate;
    }

    public void setWeekEndDate(Date weekEndDate) {
        this.weekEndDate = weekEndDate;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
