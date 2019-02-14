package com.pilot.timesheet.service;

import com.pilot.timesheet.dao.TimesheetDao;
import com.pilot.timesheet.model.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryTimesheetService {

//    @Autowired
//    TimesheetRepository timesheetRepository;
//
    @Autowired
    TimesheetDao timesheetDao;

    public List<Timesheet> getUserTimesheetsSummary(int account_id) {
        List<Timesheet> timesheets = timesheetDao.findAll(account_id);
        if(timesheets == null){
            timesheets = timesheetDao.createTimesheet(account_id);
        }
        return timesheets;
//        return (List<Timesheet>) timesheetRepository.findAll();
    }

    public Timesheet getUserTimesheet(int id) {
        return timesheetDao.findById(id);
//        return timesheetRepository.findAllById();
    }

}
