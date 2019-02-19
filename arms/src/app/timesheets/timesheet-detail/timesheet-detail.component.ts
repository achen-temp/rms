import { Component, OnInit, Input } from "@angular/core";
import { TimesheetDetail } from "./timesheet-detail.model";
import { TimesheetDetailService } from "./timesheet-detail.service";
import {
  FormGroup,
  FormBuilder,
  AbstractControl,
  Validators
} from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  selector: "app-timesheet-detail",
  templateUrl: "./timesheet-detail.component.html",
  styleUrls: ["./timesheet-detail.component.scss"]
})
export class TimesheetDetailComponent implements OnInit {
  @Input() zIndex: number;
  show: boolean = false;
  inputArr: string[] = [
    "Are you sure you want to submit this timesheet?",
    "Once submitted, it is not modifiable!"
  ];
  timesheetDetail: TimesheetDetail;
  dateFrom: Date;
  headerTop: any[];
  headerLeft: any[];
  title: string = "Enter New Timesheet";
  detailForm: FormGroup;
  timesheetStatus: string;
  submitted: boolean = false;
  timeName = { 0: "_reg", 1: "_pto", 2: "_nh" };
  dayName = {
    0: "sun",
    1: "mon",
    2: "tue",
    3: "wed",
    4: "thu",
    5: "fri",
    6: "sat"
  };
  timesheetstatus: string;

  constructor(
    private timesheetDetailService: TimesheetDetailService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {}

  ngOnInit() {
    this.getTimesheetDetail();
    this.headerTop = this.createTopHeader(this.timesheetDetail.dateFrom);
    this.headerLeft = this.createLeftHeader();
    this.timesheetStatus = this.timesheetDetail.status;
    if (this.timesheetStatus === "new") this.createNewForm();
  }
  createTopHeader(d: Date) {
    let header = [];
    for (let i = 0; i < 7; i++) {
      const temp = new Date(d.getTime() + i * 1000 * 60 * 60 * 24);
      header.push(temp);
    }
    return header;
  }
  createLeftHeader() {
    return ["Regular", "PTO", "National Holiday"];
  }

  getTimesheetDetail() {
    this.timesheetDetailService.getTimeSheetDetail().subscribe(timesheet => {
      this.timesheetDetail = timesheet;
    });
  }
  getTimesheetStatus(status: string) {
    if (status === "new") {
      return "new";
    }
  }

  createNewForm() {
    this.detailForm = this.formBuilder.group({
      comment: ["", Validators.required],
      total: ["", Validators.required],
      total_reg: ["", Validators.required],
      total_pto: ["", Validators.required],
      total_nh: ["", Validators.required],
      sun_reg: ["", Validators.required],
      sun_pto: ["", Validators.required],
      sun_nh: ["", Validators.required],
      mon_reg: ["", Validators.required],
      mon_pto: ["", Validators.required],
      mon_nh: ["", Validators.required],
      tue_reg: ["", Validators.required],
      tue_pto: ["", Validators.required],
      tue_nh: ["", Validators.required],
      wed_reg: ["", Validators.required],
      wed_pto: ["", Validators.required],
      wed_nh: ["", Validators.required],
      thu_reg: ["", Validators.required],
      thu_pto: ["", Validators.required],
      thu_nh: ["", Validators.required],
      fri_reg: ["", Validators.required],
      fri_pto: ["", Validators.required],
      fri_nh: ["", Validators.required],
      sat_reg: ["", Validators.required],
      sat_pto: ["", Validators.required],
      sat_nh: ["", Validators.required]
    });
  }
  resetForm(formGroup: FormGroup) {
    if (formGroup != null) {
      formGroup.reset();
    }
    this.submitted = false;
  }

  onSubmit() {
    this.submitted = true;
    console.log(this.detailForm);
    if (this.detailForm.invalid) {
      return;
    }
  }
  clearForm() {
    this.resetForm(this.detailForm);
  }
  // Close Modal -- used for cancel and close
  onCloseModal() {
    console.log("close modal");
  }

  // Confirm Modal
  onConfirm(message: string) {
    console.log(message);
    this.router.navigate(["/timesheet"]);
  }
}
