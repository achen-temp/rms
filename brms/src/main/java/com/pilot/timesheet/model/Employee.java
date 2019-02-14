package com.pilot.timesheet.model;

import com.pilot.timesheet.dto.ResultDTO;

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
    @Column(name = "PROJECT_ID")
    private int projectId;

    @NotBlank
    @Column(name = "ROLE_ID")
    private int roleId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "MANAGER_ID")
    private int managerId;

    @Column(name = "TIMESHEET_START_DATE")
    private Date tsStartDate;


    public Employee(){}

    public Employee(int employeeId, @NotBlank int projectId, @NotBlank int roleId, String employeeName, int managerId, Date tsStartDate) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.roleId = roleId;
        this.employeeName = employeeName;
        this.managerId = managerId;
        this.tsStartDate = tsStartDate;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

}
