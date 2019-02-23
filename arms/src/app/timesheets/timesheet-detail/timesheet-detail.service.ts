import { Injectable } from "@angular/core";
import { TimesheetDetail } from "./timesheet-detail.model";
import {
  TimesheetDetailSampleNew,
  TimesheetDetailSampleApproved,
  TimesheetDetailSampleDeclined
} from "./mock-timesheet-detail";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class TimesheetDetailService {
  constructor() {}
  getTimeSheetDetail(tid: number): Observable<TimesheetDetail> {
    switch (tid) {
      case 111:
        return of(TimesheetDetailSampleNew);
        break;
      case 110:
        return of(TimesheetDetailSampleDeclined);
        break;
      case 109:
        return of(TimesheetDetailSampleApproved);
        break;
      default:
    }
  }
}
