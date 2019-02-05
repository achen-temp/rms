import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {
  @Input() zIndex: number;
  inputArr1:string[] = ['Employee Name: Ada', 'Project Name: Internal', 'Time Interval: 01/12/19 - 01/19/19', 'Decline Reason:'];
  inputArr2:string[] = ['Employee Name: Amanda', 'Project Name: Internal', 'Time Interval: 01/12/19 - 01/19/19', 'Are you sure to approve?'];

  constructor() { }

  ngOnInit() {
  }

  // Close Modal -- used for cancel and close
  onCloseModal() {
  }

  // Confirm Modal
  onConfirm(message: string) {
    console.log(message);
  }

}
