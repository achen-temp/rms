import { Component, OnInit } from "@angular/core";
declare interface SummaryData {
  headerRow: string[];
  dataRows: string[][];
}

@Component({
  selector: "app-timesheets",
  templateUrl: "./timesheets.component.html",
  styleUrls: ["./timesheets.component.scss"]
})
export class TimesheetsComponent implements OnInit {
  public summaryData: SummaryData;
  constructor() {}

  ngOnInit() {
    this.summaryData = {
      headerRow: [
        "Project Name",
        "Week",
        "Total Hours",
        "Status",
        "Manager",
        "Update Time"
      ],
      dataRows: [
        ["Internal", "01/13/2019-01/19/2019", "0", "New", "Leaf", ""],
        [
          "Internal",
          "01/06/2019-01/12/2019",
          "40",
          "Submitted",
          "Leaf",
          "01/13/2019 09:30:00"
        ],
        [
          "Internal",
          "12/30/2019-01/05/2019",
          "40",
          "Declined",
          "Leaf",
          "01/06/2019 10:00:00"
        ],
        [
          "Internal",
          "12/23/2019-12/29/2019",
          "40",
          "Approved",
          "Leaf",
          "01/03/2019 09:00:00"
        ]
      ]
    };
  }
}
