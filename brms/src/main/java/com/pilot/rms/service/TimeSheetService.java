package com.pilot.rms.service;


import com.pilot.rms.dto.TimesheetSummaryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSheetService {

    public List<TimesheetSummaryDTO> getTimeSheetSummary(int accountId) {
        //1. get all historical timesheet
        //2. generate new timesheet from latest end date of existing timesheets
        return null;
    }
}
