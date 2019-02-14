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
};
var staEnum = {
  PENDING: 'PENDING',
  APPROVED: 'APPROVED',
  DECLINED: 'DECLINED'
};
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
  private curIndex: number = -1;
  public strArr: string[] = [];
  public statusEnum = staEnum;
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
        status: this.statusEnum.PENDING
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
        status: this.statusEnum.PENDING
    },
    ];

  }

  onCloseModal() {
    this.clearMessage();
  }

  buildMessage(index: number) {
    this.strArr.push(`Employee Name: ${this.tableData[index].employeeName}`);
    this.strArr.push(`Project Name: ${this.tableData[index].projectName}`);
    this.strArr.push(`Time Interval: ${this.tableData[index].timeInterval}`);
  }

  clearMessage() {
    this.strArr = [];
  }

  onOpenApprove(index: number) {
    this.curIndex = index;
    this.buildMessage(this.curIndex);
    this.strArr.push('Are you sure to approve?');
  }

  onApprove(message: string) {
    // TODO: send to backend
    this.tableData[this.curIndex].status = this.statusEnum.APPROVED;
    this.tableData[this.curIndex].show = false;
    this.clearMessage();
  }

  onOpenDecline(index: number) {
    this.curIndex = index;
    this.buildMessage(this.curIndex);
    this.strArr.push('Please enter the reason to decline:');
  }

  onDecline(message: string) {
    console.log('decline reason', message);
    // TODO: send to backend
    this.tableData[this.curIndex].status = this.statusEnum.DECLINED;
    this.tableData[this.curIndex].show = false;
    this.clearMessage();
  }

  updateStatus(index: number, status: string) {
    this.tableData[index].status = status;
  }

  toggle(index) {
    this.tableData[index].show = !this.tableData[index].show;
  }

}
