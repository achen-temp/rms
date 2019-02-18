package com.pilot.timesheet.dto;

import java.util.Date;

public class SummaryDTO extends ResultDTO {
    private String projectName;
    private Date weekFrom;
    private Date weekTo;
    private double totalHrs;
    private String status;
    private String manager;
    private Date updatedTime;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getWeekFrom() {
        return weekFrom;
    }

    public void setWeekFrom(Date weekFrom) {
        this.weekFrom = weekFrom;
    }

    public Date getWeekTo() {
        return weekTo;
    }

    public void setWeekTo(Date weekTo) {
        this.weekTo = weekTo;
    }

    public double getTotalHrs() {
        return totalHrs;
    }

    public void setTotalHrs(double totalHrs) {
        this.totalHrs = totalHrs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
