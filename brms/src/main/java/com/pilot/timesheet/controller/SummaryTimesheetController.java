package com.pilot.timesheet.controller;

import com.pilot.timesheet.model.Timesheet;
import com.pilot.timesheet.service.SummaryTimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class SummaryTimesheetController {

    @Autowired
    SummaryTimesheetService timesheetService;

    @GetMapping("/timesheetssummary/{account_id}")
    public List<Timesheet> getUserAccountSummary(@PathVariable int account_id) {
        return timesheetService.getUserTimesheetsSummary(account_id);
    }

    @GetMapping("/timesheet/{ts_id}")
    public Timesheet getUserTimesheetSummary(@PathVariable int ts_id) {
        return timesheetService.getUserTimesheet(ts_id);
    }
}
