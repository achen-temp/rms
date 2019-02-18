package com.pilot.timesheet.model;

import com.pilot.timesheet.dto.ResultDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TIMESHEET_DETAILS")
public class TimesheetDetails extends ResultDTO {

    public TimesheetDetails() { }

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

        public TimeId(int timesheetId, String day, Date date) {
            this.timesheetId = timesheetId;
            this.day = day;
            this.date = date;
        }

        public TimeId() {
        }

    }
}


