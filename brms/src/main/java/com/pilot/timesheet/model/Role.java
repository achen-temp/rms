package com.pilot.timesheet.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "USER_ROLE")
public class Role {
    @Id
    @Column(name = "ROLE_ID")
    private int roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private Date createdOn;

    @Column(name = "Update_By")
    private String updateBy;

    @Column(name = "Update_Timestamp")
    private Date updateTimestamp;

    public Role() { }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role(int roleId, String roleName, String createdBy, Date createdOn, String updateBy, Date updateTimestamp) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updateBy = updateBy;
        this.updateTimestamp = updateTimestamp;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
