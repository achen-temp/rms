import { Component, OnInit, Input } from "@angular/core";
import { TimesheetDetail } from "./timesheet-detail.model";
import { TimesheetDetailService } from "./timesheet-detail.service";
import {
  FormGroup,
  FormBuilder,
  AbstractControl,
  Validators
} from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-timesheet-detail",
  templateUrl: "./timesheet-detail.component.html",
  styleUrls: ["./timesheet-detail.component.scss"]
})
export class TimesheetDetailComponent implements OnInit {
  @Input() zIndex: number;
  show: boolean = false;
  timesheetDetail: TimesheetDetail;
  newTS: TimesheetDetail;
  dateFrom: Date;
  headerTop: any[];
  headerLeft: any[];
  title: string;
  detailForm: FormGroup;
  timesheetStatus: string;
  timesheetId: number;
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
  tsModified: boolean = false;

  modalText1 = [
    "Are you sure you want to submit this timesheet?",
    "Once submitted, it is not modifiable!"
  ];
  modalText2 = [
    "The entry your entered is the same as previous declined version.",
    "You must reenter  OR ",
    "Leave comment explaining why you submit the same version."
  ];
  inputArr: string[] = this.modalText1;

  constructor(
    private timesheetDetailService: TimesheetDetailService,
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.getTimesheetId();
    if (this.timesheetId) {
      this.getTimesheetDetail(this.timesheetId);
      this.headerTop = this.createTopHeader(this.timesheetDetail.dateFrom);
      this.headerLeft = this.createLeftHeader();
      this.timesheetStatus = this.timesheetDetail.status;
      this.changeTitle();
      if (
        this.timesheetStatus === "new" ||
        this.timesheetStatus === "declined"
      ) {
        this.createNewForm();
      }
    }
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

  getTimesheetId() {
    this.timesheetId = parseInt(this.route.snapshot.paramMap.get("tid"));
  }

  getTimesheetDetail(tid: number) {
    this.timesheetDetailService.getTimeSheetDetail(tid).subscribe(timesheet => {
      this.timesheetDetail = timesheet;
    });
  }

  createNewForm() {
    this.detailForm = this.formBuilder.group({
      comment: [this.timesheetDetail.comment],
      total: [this.timesheetDetail.total, Validators.required],
      total_reg: [this.timesheetDetail.total_reg, Validators.required],
      total_pto: [this.timesheetDetail.total_pto, Validators.required],
      total_nh: [this.timesheetDetail.total_nh, Validators.required],
      sun_reg: [this.timesheetDetail.sun_reg, Validators.required],
      sun_pto: [this.timesheetDetail.sun_pto, Validators.required],
      sun_nh: [this.timesheetDetail.sun_nh, Validators.required],
      mon_reg: [this.timesheetDetail.mon_reg, Validators.required],
      mon_pto: [this.timesheetDetail.mon_pto, Validators.required],
      mon_nh: [this.timesheetDetail.mon_nh, Validators.required],
      tue_reg: [this.timesheetDetail.tue_reg, Validators.required],
      tue_pto: [this.timesheetDetail.tue_pto, Validators.required],
      tue_nh: [this.timesheetDetail.tue_nh, Validators.required],
      wed_reg: [this.timesheetDetail.wed_reg, Validators.required],
      wed_pto: [this.timesheetDetail.wed_pto, Validators.required],
      wed_nh: [this.timesheetDetail.wed_nh, Validators.required],
      thu_reg: [this.timesheetDetail.thu_reg, Validators.required],
      thu_pto: [this.timesheetDetail.thu_pto, Validators.required],
      thu_nh: [this.timesheetDetail.thu_nh, Validators.required],
      fri_reg: [this.timesheetDetail.fri_reg, Validators.required],
      fri_pto: [this.timesheetDetail.fri_pto, Validators.required],
      fri_nh: [this.timesheetDetail.fri_nh, Validators.required],
      sat_reg: [this.timesheetDetail.sat_reg, Validators.required],
      sat_pto: [this.timesheetDetail.sat_pto, Validators.required],
      sat_nh: [this.timesheetDetail.sat_nh, Validators.required]
    });
  }

  resetForm(formGroup: FormGroup) {
    if (formGroup != null) {
      formGroup.reset();
    }
    this.submitted = false;
  }

  backToSummary() {
    this.router.navigate(["/timesheet"]);
  }

  changeTitle() {
    switch (this.timesheetStatus) {
      case "new":
        this.title = "Enter New Timesheet";
        break;
      case "pending":
        this.title = "Timesheet is Pending";
        break;
      case "approved":
        this.title = "Timesheet has been Approved";
        break;
      case "declined":
        this.title = "You Must Modify This Timesheet";
        break;
    }
  }

  onSubmit() {
    this.submitted = true;
    if (this.detailForm.invalid) {
      return;
    }

    this.newTS = new TimesheetDetail(
      this.timesheetId,
      this.timesheetStatus,
      this.timesheetDetail.projectName,
      this.timesheetDetail.approvalManager,
      this.timesheetDetail.dateFrom,
      this.timesheetDetail.dateTo,
      this.detailForm.controls.comment.value,
      this.detailForm.controls.sun_reg.value,
      this.detailForm.controls.sun_pto.value,
      this.detailForm.controls.sun_nh.value,
      this.detailForm.controls.mon_reg.value,
      this.detailForm.controls.mon_pto.value,
      this.detailForm.controls.mon_nh.value,
      this.detailForm.controls.tue_reg.value,
      this.detailForm.controls.tue_pto.value,
      this.detailForm.controls.tue_nh.value,
      this.detailForm.controls.wed_reg.value,
      this.detailForm.controls.wed_pto.value,
      this.detailForm.controls.wed_nh.value,
      this.detailForm.controls.thu_reg.value,
      this.detailForm.controls.thu_pto.value,
      this.detailForm.controls.thu_nh.value,
      this.detailForm.controls.fri_reg.value,
      this.detailForm.controls.fri_pto.value,
      this.detailForm.controls.fri_nh.value,
      this.detailForm.controls.sat_reg.value,
      this.detailForm.controls.sat_pto.value,
      this.detailForm.controls.sat_nh.value,
      this.detailForm.controls.total_reg.value,
      this.detailForm.controls.total_pto.value,
      this.detailForm.controls.total_nh.value,
      this.detailForm.controls.total.value
    );

    if (this.timesheetDetail.status === "declined") {
      if (this.timesheetIsEqual(this.timesheetDetail, this.newTS)) {
        this.inputArr = this.modalText2;
      } else {
        this.inputArr = this.modalText1;
        this.tsModified = true;
      }
      // console.log("timesheet changed", this.tsModified);
    }
  }

  clearForm() {
    this.resetForm(this.detailForm);
  }
  // Close Modal -- used for cancel and close
  onCloseModal() {
    // console.log("close modal");
  }

  // Confirm Modal
  onConfirm(message: string) {
    if (this.timesheetDetail.status === "new") {
      this.router.navigate(["/timesheet"]);
    } else if (this.timesheetDetail.status === "declined") {
      if (this.tsModified) {
        this.router.navigate(["/timesheet"]);
      } else {
        return;
      }
    }
  }

  timesheetIsEqual(ts1: TimesheetDetail, ts2: TimesheetDetail) {
    return JSON.stringify(ts1) === JSON.stringify(ts2);
  }
}
