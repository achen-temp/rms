import { TestBed } from '@angular/core/testing';

import { TimesheetDetailService } from './timesheet-detail.service';

describe('TimesheetDetailService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TimesheetDetailService = TestBed.get(TimesheetDetailService);
    expect(service).toBeTruthy();
  });
});
