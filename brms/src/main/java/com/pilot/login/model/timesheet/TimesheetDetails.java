package com.pilot.login.model.timesheet;



import com.pilot.login.dto.ResultDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TIMESHEET_DETAILS")
public class TimesheetDetails extends ResultDTO {

    @Column(name = "REGULAR_HOUR")
    private Double regularHour;

    @Column(name = "PTO")
    private Double pto;

    @Column(name = "FEDERAL_HOLIDAY")
    private Double federalHoliday;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private Date createdOn;

    @Column(name = "Update_By")
    private String updateBy;

    @Column(name = "Update_Timestamp")
    private Date updateTimestamp;

    @EmbeddedId
    private TimeId timteid;

    @Embeddable
    public class TimeId implements Serializable {
        public TimeId() { }

        public TimeId(int timesheetId, String day, Date date) {
            this.timesheetId = timesheetId;
            this.day = day;
            this.date = date;
        }

        @Column(name = "TIMESHEET_ID")
        private int timesheetId;

        @Column(name = "DAY")
        private String day;

        @Column(name = "DATE")
        private Date date;

        public int getTimesheetId() {
            return timesheetId;
        }

        public void setTimesheetId(int timesheetId) {
            this.timesheetId = timesheetId;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }

    public TimesheetDetails() { }

    public TimesheetDetails(String flow, String status, String errorMessage, Double regularHour, Double pto, Double federalHoliday, TimeId timteid) {
        super(flow, status, errorMessage);
        this.regularHour = regularHour;
        this.pto = pto;
        this.federalHoliday = federalHoliday;
        this.timteid = timteid;
    }

    public TimesheetDetails(String flow, String status, String errorMessage, Double regularHour, Double pto, Double federalHoliday, String createdBy, Date createdOn, String updateBy, Date updateTimestamp, TimeId timteid) {
        super(flow, status, errorMessage);
        this.regularHour = regularHour;
        this.pto = pto;
        this.federalHoliday = federalHoliday;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updateBy = updateBy;
        this.updateTimestamp = updateTimestamp;
        this.timteid = timteid;
    }

    public Double getRegularHour() {
        return regularHour;
    }

    public void setRegularHour(Double regularHour) {
        this.regularHour = regularHour;
    }

    public Double getPto() {
        return pto;
    }

    public void setPto(Double pto) {
        this.pto = pto;
    }

    public Double getFederalHoliday() {
        return federalHoliday;
    }

    public void setFederalHoliday(Double federalHoliday) {
        this.federalHoliday = federalHoliday;
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

    public TimeId getTimteid() {
        return timteid;
    }

    public void setTimteid(TimeId timteid) {
        this.timteid = timteid;
    }
}


