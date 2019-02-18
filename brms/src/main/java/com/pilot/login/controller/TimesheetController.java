package com.pilot.login.controller;

import com.pilot.login.dto.TimesheetSummaryDTO;
import com.pilot.login.model.timesheet.Timesheet;
import com.pilot.login.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {


    @Autowired
    private TimeSheetService timeSheetService;


    @GetMapping("/summary/{account_id}")
    public List<TimesheetSummaryDTO> getTimeSheetSummary(@PathVariable int accountId){
        return timeSheetService.getTimeSheetSummary(accountId);
    }

}

