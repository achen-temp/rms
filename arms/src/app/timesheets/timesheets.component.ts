import { TimesheetSummary } from "./timesheet.summary.model";
import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { environment } from "environments/environment";
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
  private getUrl = environment.getTimeSheetSummaryUrl;
  constructor(private http: HttpClient) {}

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
      dataRows: []
    };

    this.http.get(`${this.getUrl}/123`).subscribe(response => {
      if (response && response["status"] === "failure") {
        console.error("fail");
      } else if (response && response["status"] === "success") {
        response["data"].forEach(element => {
          this.summaryData.dataRows.push(element);
        });
      }
    });

    // console.log(this.summaryData);
  }
}
