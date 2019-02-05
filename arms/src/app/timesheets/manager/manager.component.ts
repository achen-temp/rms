import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
declare interface TableData {
  employeeName: string;
  projectName: string;
  timeInterval: string;
  dataRows: any[][];
  comments: string;
  total: number;
  show: boolean;
  status: string;
}
@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.scss']
})
export class ManagerComponent implements OnInit {
  public tableData: TableData[];
  public subTitles: string[];
  public display: string = 'none';
  public submitted: boolean = false;
  private declinedIndex: number = -1;
  constructor() { 

  }

  ngOnInit() {
    this.subTitles = ['Regular Hours', 'PTO', 'National Holidays'];
    this.tableData = [
      { employeeName: "Ada",
        projectName: "Interval",
        timeInterval: "01-12-2019 to 01-18-2019",
        dataRows: [
        ["0", "SUN", "01-12-2019", 0, 0, 0],
        ["1", "MON", "01-13-2019", 4, 4, 0],
        ["2", "TUE", "01-14-2019", 8, 0, 0],
        ["3", "WEN", "01-15-2019", 8, 0, 0],
        ["4", "THU", "01-16-2019", 8, 0, 0],
        ["5", "FRI", "01-17-2019", 8, 0, 0],
        ["6", "SAT", "01-18-2019", 0, 0, 0],
        ["7", "TOTAL", "", 36, 4, 0]],
        comments: "PTO 4 hours on 01-13-2019",
        total: 40,
        show: false,
        status: "PENDING"
      },
      { employeeName: "Ben",
        projectName: "Interval",
        timeInterval: "01-12-2019 to 01-18-2019",
        dataRows: [
        ["0", "SUN", "01-12-2019", 0, 0, 0],
        ["1", "MON", "01-13-2019", 4, 4, 0],
        ["2", "TUE", "01-14-2019", 8, 0, 0],
        ["3", "WEN", "01-15-2019", 8, 0, 0],
        ["4", "THU", "01-16-2019", 8, 0, 0],
        ["5", "FRI", "01-17-2019", 8, 0, 0],
        ["6", "SAT", "01-18-2019", 0, 0, 0],
        ["7", "TOTAL", "", 36, 4, 0]],
        comments: "PTO 4 hours on 01-13-2019",
        total: 40,
        show: false,
        status: "PENDING"
    },
    ];

  }

  onApprove(index) {
    console.log('approve ', index);
    // TODO: send to backend
    this.updateStatus(index, "APPROVED");
  }

  onDecline(index) {
    console.log('decline', index);
    this.openModalDialog(index);
    console.log('decline', this.display);
  }

  updateStatus(index: number, status: string) {
    this.tableData[index].status = status;
  }

  openModalDialog(index) {
    this.display = 'block';
    this.declinedIndex = index;
  }

  closeModalDialog() {
    this.display = 'none';
  }

  submit(form: NgForm) {
    this.submitted = true;
    if (form.invalid) return;
    
    console.log(form.value);
    this.closeModalDialog();
    this.updateStatus(this.declinedIndex, "DECLINED");
  }

  toggle(index) {
    this.tableData[index].show = !this.tableData[index].show;
  }

}
