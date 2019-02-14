package com.pilot.timesheet.model;

import com.pilot.timesheet.dto.ResultDTO;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TIMESHEET_DETAILS")
public class TimesheetDetails extends ResultDTO {
    @Id
    @Column(name = "TIMESHEET_ID")
    private int timesheetId;

    @Column(name = "DAY")
    private String day;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "REGULAR_HOUR")
    private float regularHour;

    @Column(name = "PTO")
    private float pto;

    @Column(name = "FEDERAL_HOLIDAY")
    private float federalHoliday;

    public TimesheetDetails(){}

    public TimesheetDetails(int timesheetId, String day, Date date, float regularHour, float pto, float federalHoliday) {
        this.timesheetId = timesheetId;
        this.day = day;
        this.date = date;
        this.regularHour = regularHour;
        this.pto = pto;
        this.federalHoliday = federalHoliday;
    }

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

    public float getRegularHour() {
        return regularHour;
    }

    public void setRegularHour(float regularHour) {
        this.regularHour = regularHour;
    }

    public float getPto() {
        return pto;
    }

    public void setPto(float pto) {
        this.pto = pto;
    }

    public float getFederalHoliday() {
        return federalHoliday;
    }

    public void setFederalHoliday(float federalHoliday) {
        this.federalHoliday = federalHoliday;
    }
}
