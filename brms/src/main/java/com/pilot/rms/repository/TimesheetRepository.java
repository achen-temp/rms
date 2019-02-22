package com.pilot.rms.repository;

import com.pilot.rms.model.timesheet.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
}
