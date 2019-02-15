package com.pilot.timesheet.model;

import com.pilot.timesheet.dto.ResultDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TIMESHEET_DETAILS")
public class TimesheetDetails extends ResultDTO {
    public TimesheetDetails(String flow, String status, String errorMessage, TimeId td, int timesheetId, String day, Date date, float regularHour, float pto, float federalHoliday, String createdBy, Date createdOn, String updateBy, Date updateTimestamp) {
        super(flow, status, errorMessage);
        this.timteid = timteid;
//        this.timesheetId = timesheetId;
//        this.day = day;
//        this.date = date;
        this.regularHour = regularHour;
        this.pto = pto;
        this.federalHoliday = federalHoliday;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updateBy = updateBy;
        this.updateTimestamp = updateTimestamp;
    }

    public TimesheetDetails() {
    }

    @EmbeddedId
    private TimeId timteid;

//    @Column(name = "TIMESHEET_ID")
//    private int timesheetId;
//
//    @Column(name = "DAY")
//    private String day;
//
//    @Column(name = "DATE")
//    private Date date;

    @Column(name = "REGULAR_HOUR")
    private float regularHour;

    @Column(name = "PTO")
    private float pto;

    @Column(name = "FEDERAL_HOLIDAY")
    private float federalHoliday;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_On")
    private Date createdOn;

    @Column(name = "Update_By")
    private String updateBy;

    @Column(name = "Update_Timestamp")
    private Date updateTimestamp;

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


