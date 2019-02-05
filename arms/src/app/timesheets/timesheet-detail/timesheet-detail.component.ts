import { Component, OnInit, Input } from "@angular/core";
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
  @Input() zIndex: number;
  public tableHeader: TableHeader;
  public timesheetdetail: TimesheetDetail;
  dateFrom: Date;
  dateTo: Date;
  show: boolean = false;
  inputArr: string[] = [
    "Are you sure you want to submit this timesheet?",
    "Once submitted, it is not modifiable!"
  ];

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
    this.timesheetdetail = new TimesheetDetail(
      1234,
      "Internal",
      "Leaf",
      new Date("12/23/2018"),
      new Date("12/29/2018"),
      null,
      { regular: null, pto: null, nholiday: null },
      { regular: null, pto: null, nholiday: null },
      { regular: null, pto: null, nholiday: null },
      { regular: null, pto: null, nholiday: null },
      { regular: null, pto: null, nholiday: null },
      { regular: null, pto: null, nholiday: null },
      { regular: null, pto: null, nholiday: null },
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  // Close Modal -- used for cancel and close
  onCloseModal() {
    console.log("close modal");
  }

  // Confirm Modal
  onConfirm(message: string) {
    console.log(message);
  }

  onClear() {
    this.timesheetdetail.total = null;
    this.timesheetdetail.comment = null;
    this.timesheetdetail.sun = { regular: null, pto: null, nholiday: null };
    this.timesheetdetail.mon = { regular: null, pto: null, nholiday: null };
    this.timesheetdetail.tue = { regular: null, pto: null, nholiday: null };
    this.timesheetdetail.wed = { regular: null, pto: null, nholiday: null };
    this.timesheetdetail.thu = { regular: null, pto: null, nholiday: null };
    this.timesheetdetail.fri = { regular: null, pto: null, nholiday: null };
    this.timesheetdetail.sat = { regular: null, pto: null, nholiday: null };
    this.timesheetdetail.total_regular = null;
    this.timesheetdetail.total_pto = null;
    this.timesheetdetail.total_nholiday = null;
    this.timesheetdetail.total = null;
  }
}
