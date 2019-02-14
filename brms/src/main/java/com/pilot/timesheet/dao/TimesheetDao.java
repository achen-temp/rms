package com.pilot.timesheet.dao;

import com.pilot.timesheet.model.Employee;
import com.pilot.timesheet.model.Timesheet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TimesheetDao {
    public static List<Timesheet> timesheets = new ArrayList<>();
    public static List<Employee> employees = new ArrayList<>();

    public List<Timesheet> findAll(int account_id) {
        //get timesheets by employee account_id
        //sort by time now to past
        List<Timesheet> empTimesheets = new ArrayList<>();
        for(Timesheet ts : timesheets){
            if(ts.getEmployeeId() == account_id){
                empTimesheets.add(ts);
            }
        }
        return  empTimesheets;
    }

    public Timesheet findById(int ts_id) {
        //get timesheet by timesheet_id
        Timesheet timesheet = new Timesheet();
        for(Timesheet ts : timesheets){
            if(ts.getEmployeeId() == ts_id){
                timesheet = ts;
            }
        }
        return timesheet;
    }

    //don't create database instance, just return a blank object
    public List<Timesheet> createTimesheet(int account_id){
        //get employee start date by employee account id;
        //generate employee timesheets
        // return boolean
        List<Timesheet> tempTimesheet = new ArrayList<>();
        Date startDate = new Date();
        for(Employee emp : employees){
            if(emp.getEmployeeId()==account_id){
                startDate = emp.getTsStartDate();
            }
        }
        Date curDate = new Date();
        tempTimesheet = generateTimesheet(startDate,curDate);
        return tempTimesheet;
    }

    public List<Timesheet> generateTimesheet(Date startDate, Date curDate){
        List<Timesheet> generatedTs = new ArrayList<>();

        return  generatedTs;
    }



}
