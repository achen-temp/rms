package com.pilot.rms.service;

import com.pilot.login.utils.TimeSheetGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pilot.rms.dto.TimesheetSummaryDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class TimeSheetService {

    private Logger logger = LoggerFactory.getLogger(TimeSheetService.class);

    public List<TimesheetSummaryDTO> getTimeSheetSummary(int accountId) {
        //1. get all historical timesheet
        //2. generate new timesheet from latest end date of existing timesheets

        //TODO delete below lines after retrieve real data.
        Date lastStartDate = new Date(0);
        Date lastEndDate = new Date(0);
        List<Date> updatedStartDate = new ArrayList<>();
        List<Date> updatedEndDate = new ArrayList<>();

        try {
            TimeSheetGenerator.generateTimeSheet(lastStartDate, lastEndDate).forEach(p -> {
                updatedStartDate.add(p.getKey());
                updatedEndDate.add(p.getValue());
            });
        } catch (DataFormatException e) {
            logger.error("TimeSheetService::getTimeSheetSummary -> input date format is incorrect");
        }

        return null;
    }
}
