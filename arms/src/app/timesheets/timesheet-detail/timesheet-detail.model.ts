export class TimesheetDetail {
  public id: number;
  public status: string;
  public projectName: string;
  public approvalManager: string;
  public dateFrom: Date;
  public dateTo: Date;
  public comment: string;
  public sun_pto: number;
  public sun_reg: number;
  public sun_nh: number;
  public mon_pto: number;
  public mon_reg: number;
  public mon_nh: number;
  public tue_pto: number;
  public tue_reg: number;
  public tue_nh: number;
  public wed_pto: number;
  public wed_reg: number;
  public wed_nh: number;
  public thu_pto: number;
  public thu_reg: number;
  public thu_nh: number;
  public fri_pto: number;
  public fri_reg: number;
  public fri_nh: number;
  public sat_pto: number;
  public sat_reg: number;
  public sat_nh: number;
  public total_reg: number;
  public total_pto: number;
  public total_nh: number;
  public total: number;

  constructor(
    id: number,
    status: string,
    projectName: string,
    approvalManager: string,
    dateFrom: Date,
    dateTo: Date,
    comment: string,
    sun_pto: number,
    sun_reg: number,
    sun_nh: number,
    mon_pto: number,
    mon_reg: number,
    mon_nh: number,
    tue_pto: number,
    tue_reg: number,
    tue_nh: number,
    wed_pto: number,
    wed_reg: number,
    wed_nh: number,
    thu_pto: number,
    thu_reg: number,
    thu_nh: number,
    fri_pto: number,
    fri_reg: number,
    fri_nh: number,
    sat_pto: number,
    sat_reg: number,
    sat_nh: number,
    total_reg: number,
    total_pto: number,
    total_nh: number,
    total: number
  ) {
    this.id = id;
    this.status = status;
    this.projectName = projectName;
    this.approvalManager = approvalManager;
    this.dateFrom = dateFrom;
    this.dateTo = dateTo;
    this.comment = comment;
    this.sun_pto = sun_pto;
    this.sun_reg = sun_reg;
    this.sun_nh = sun_nh;
    this.mon_pto = mon_pto;
    this.mon_reg = mon_reg;
    this.mon_nh = mon_nh;
    this.tue_pto = tue_pto;
    this.tue_reg = tue_reg;
    this.tue_nh = tue_nh;
    this.wed_pto = wed_pto;
    this.wed_reg = wed_reg;
    this.wed_nh = wed_nh;
    this.thu_pto = thu_pto;
    this.thu_reg = thu_reg;
    this.thu_nh = thu_nh;
    this.fri_pto = fri_pto;
    this.fri_reg = fri_reg;
    this.fri_nh = fri_nh;
    this.sat_pto = sat_pto;
    this.sat_reg = sat_reg;
    this.sat_nh = sat_nh;
    this.total_reg = total_reg;
    this.total_pto = total_pto;
    this.total_nh = total_nh;
    this.total = total;
  }
}
