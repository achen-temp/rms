import { Component, OnInit } from "@angular/core";
import { TimesheetDetail } from "./timesheetdetail.model";
declare interface TableHeader {
  headerTop: Date[];
  headerLeft: string[];
}

@Component({
  selector: "app-timesheet-detail",
  templateUrl: "./timesheet-detail.component.html",
  styleUrls: ["./timesheet-detail.component.scss"]
})
export class TimesheetDetailComponent implements OnInit {
  public tableHeader: TableHeader;
  public timesheetdetail: TimesheetDetail;
  dateFrom: Date;
  dateTo: Date;
  show: boolean = false;

  constructor() {}

  ngOnInit() {
    this.tableHeader = {
      headerTop: [
        new Date("12/23/2018"),
        new Date("12/24/2018"),
        new Date("12/25/2018"),
        new Date("12/26/2018"),
        new Date("12/27/2018"),
        new Date("12/28/2018"),
        new Date("12/29/2018")
      ],
      headerLeft: ["Regular", "PTO", "National Holiday"]
    };
    this.dateFrom = new Date("12/23/2018");
    this.dateTo = new Date("12/29/2018");
    this.timesheetdetail = {
      id: 1234,
      projectName: "Internal",
      approvalManager: "Leaf",
      timeFrom: new Date("12/23/2019"),
      timeTo: new Date("12/29/2019"),
      comment: "",
      sun: { regular: 0, pto: 0, nholiday: 0 },
      mon: { regular: 8, pto: 0, nholiday: 0 },
      tue: { regular: 8, pto: 0, nholiday: 0 },
      wed: { regular: 8, pto: 0, nholiday: 0 },
      thu: { regular: 8, pto: 0, nholiday: 0 },
      fri: { regular: 8, pto: 0, nholiday: 0 },
      sat: { regular: 0, pto: 0, nholiday: 0 },
      total: 40,
      createdBy: null,
      createdOn: null,
      updatedBy: null,
      updatedOn: null
    };
  }
  toggle() {
    this.show = !this.show;
  }
}
