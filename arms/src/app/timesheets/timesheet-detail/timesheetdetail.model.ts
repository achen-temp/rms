export class TimesheetDetail {
  public id: number = -1;
  public projectName: string;
  public approvalManager: string;
  public timeFrom: Date;
  public timeTo: Date;
  public comment: string;
  public sun: Object;
  public mon: Object;
  public tue: Object;
  public wed: Object;
  public thu: Object;
  public fri: Object;
  public sat: Object;
  public total: number;
  public createdBy: string;
  public createdOn: string;
  public updatedBy: string;
  public updatedOn: string;

  constructor(
    id: number,
    projectName: string,
    approvalManager: string,
    timeFrom: Date,
    timeTo: Date,
    comment: string,
    sun: Object,
    mon: Object,
    tue: Object,
    wed: Object,
    thu: Object,
    fri: Object,
    sat: Object,
    total: number,
    createdBy: string,
    createdOn: string,
    updatedBy: string,
    updatedOn: string
  ) {
    this.id = id;
    this.projectName = projectName;
    this.approvalManager = approvalManager;
    this.timeFrom = timeFrom;
    this.timeTo = timeTo;
    this.comment = comment;
    this.total = total;
    this.sun = sun;
    this.mon = mon;
    this.tue = tue;
    this.wed = wed;
    this.thu = thu;
    this.fri = fri;
    this.sat = sat;
    this.createdBy = createdBy;
    this.createdOn = createdOn;
    this.updatedBy = updatedBy;
    this.updatedOn = updatedOn;
  }
}
