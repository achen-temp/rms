package com.pilot.timesheet.controller;

import com.pilot.timesheet.model.Timesheet;
import com.pilot.timesheet.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    TimesheetService timesheetService;


//    @GetMapping("/timesheetssummary/{account_id}")
//    public List<Timesheet> getUserAccountSummary(@PathVariable int account_id) {
//        System.out.println("test");
//        return null;
//    }
//
//    @GetMapping("/timesheet/{ts_id}")
//    public Timesheet getUserTimesheetSummary(@PathVariable int ts_id) {
//        System.out.println("test");
//        return null;
//    }

    //get info from timesheet summary page
    @GetMapping("/summary/{accountId}")
    public List<Timesheet> getTimesheetSummary(@PathVariable int accountId) {
        return timesheetService.getTimesheetSummary(accountId);
    }
}
