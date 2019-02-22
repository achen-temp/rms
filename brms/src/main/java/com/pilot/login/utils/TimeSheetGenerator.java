package com.pilot.login.utils;

import javafx.util.Pair;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.zip.DataFormatException;

public class TimeSheetGenerator {

    private static Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

    /**
     * generate new starting date and end date
     * @param lastStartDate Date
     * @param lastEndDate Date
     * @return list of date in between lastEndDate and today in Pair(startDate, startDate)
     * @exception DataFormatException throw exception if date is not in weekend
     */
    public static List<Pair<Date,Date>> generateTimeSheet(Date lastStartDate , Date lastEndDate) throws DataFormatException {
        List<Pair<Date,Date>> result = new ArrayList<>();
        LocalDate localNow = LocalDate.now(ZoneId.systemDefault());
        LocalDate oldStartDate = lastStartDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate oldEndDate = lastEndDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (!isWeekend(oldStartDate) || !isWeekend(oldEndDate)) {
            throw new DataFormatException("TimeSheetGenerator::generateTimeSheet -> input date is in weekend: "
                    + oldStartDate.toString() + oldEndDate.toString());
        }

        long weeksDiff = ChronoUnit.WEEKS.between(localNow, oldEndDate);

        for (int i = 1; i <= weeksDiff; i++) {
            Date newStartDate = java.sql.Date.valueOf(oldStartDate.plusWeeks(i));
            Date newEndDate = java.sql.Date.valueOf(oldEndDate.plusWeeks(i));
            result.add(new Pair<>(newStartDate, newEndDate));
        }

        return result;
     }
     private static boolean isWeekend(LocalDate date){
        return weekend.contains(date.getDayOfWeek());
     }

}
