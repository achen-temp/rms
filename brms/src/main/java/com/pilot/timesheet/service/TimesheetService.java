package com.pilot.timesheet.service;

import com.pilot.timesheet.model.Timesheet;
import com.pilot.timesheet.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TimesheetService {

    @Autowired
    TimesheetRepository timesheetRepository;

    public List<Timesheet> getTimesheetSummary(int accountId) {
        return null;
    }
}
