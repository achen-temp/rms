import { Injectable } from "@angular/core";
import { TimesheetDetail } from "./timesheet-detail.model";
import { TimesheetDetailSample } from "./mock-timesheet-detail";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class TimesheetDetailService {
  constructor() {}
  getTimeSheetDetail(): Observable<TimesheetDetail> {
    return of(TimesheetDetailSample);
  }
}
