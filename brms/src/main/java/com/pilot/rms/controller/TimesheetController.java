package com.pilot.rms.controller;

import com.pilot.rms.dto.TimesheetSummaryDTO;
import com.pilot.rms.service.TimeSheetService;
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

