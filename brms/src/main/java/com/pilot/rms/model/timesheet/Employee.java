package com.pilot.rms.model.timesheet;


import com.pilot.rms.dto.ResultDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_PROFILE_TEMP")
public class Employee extends ResultDTO {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    @NotBlank
    @Column(name = "ROLE_ID")
    private int roleId;

    @NotBlank
    @Column(name = "PROJECT_ID")
    private int projectId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "MANAGER_ID")
    private int managerId;

    @Column(name = "TIMESHEET_START_DATE")
    private Date tsStartDate;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private Date createdOn;

    @Column(name = "Update_By")
    private String updateBy;

    @Column(name = "Update_Timestamp")
    private Date updateTimestamp;

    public Employee() { }

    public Employee(String flow, String status, String errorMessage, int employeeId, @NotBlank int roleId, @NotBlank int projectId, String employeeName, int managerId, Date tsStartDate) {
        super(flow, status, errorMessage);
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.projectId = projectId;
        this.employeeName = employeeName;
        this.managerId = managerId;
        this.tsStartDate = tsStartDate;
    }

    public Employee(String flow, String status, String errorMessage, int employeeId, @NotBlank int roleId, @NotBlank int projectId, String employeeName, int managerId, Date tsStartDate, String createdBy, Date createdOn, String updateBy, Date updateTimestamp) {
        super(flow, status, errorMessage);
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.projectId = projectId;
        this.employeeName = employeeName;
        this.managerId = managerId;
        this.tsStartDate = tsStartDate;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updateBy = updateBy;
        this.updateTimestamp = updateTimestamp;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getTsStartDate() {
        return tsStartDate;
    }

    public void setTsStartDate(Date tsStartDate) {
        this.tsStartDate = tsStartDate;
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
}
