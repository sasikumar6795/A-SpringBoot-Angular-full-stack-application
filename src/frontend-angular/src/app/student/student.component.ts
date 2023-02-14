import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {Subscription} from "rxjs";
import {Student} from "../model/Student";
import {StudentService} from "../service/student.service";
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit, OnDestroy{

  private subscriptions : Subscription[] = [];
  public students:Student[] =[];
  public isLoading: boolean = true;
  public openStudentForm : boolean =false;
  registrationForm: FormGroup;
  public registerStudent: Student;
  genderList =  ["MALE", "FEMALE", "OTHER"];

  

  constructor(private studentService:StudentService) {

  }

  ngOnInit(): void {
        this.getAllStudents();
        this.registrationForm = new FormGroup({
          name : new FormControl('', Validators.required),
          email: new FormControl('', Validators.email),
          gender: new FormControl('', Validators.required),
        })
  }

  getAllStudents() {
      this.subscriptions.push(
        this.studentService.getAllStudents().subscribe(
          (response) => {
            this.isLoading=false;
           console.log(response);
           this.students=response;
          },
          (error: HttpErrorResponse) => {
            console.log("Error in loading students data", error);
          }
        )
      )
  }

  openAddStudentForm() {
    this.openStudentForm =true;
  }

  closeStudentForm() {
    this.openStudentForm =false;
    this.onSubmitRegistrationForm();
  }

  onSubmitRegistrationForm() {
      console.log(this.registrationForm.value);
      this.registerStudent = this.registrationForm.value;
      this.studentService.addStudents(this.registerStudent);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  

}
