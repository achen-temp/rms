package com.pilot.timesheet.repository;

import com.pilot.timesheet.model.Timesheet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends PagingAndSortingRepository<Timesheet, Long> {
}
