import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {Subscription} from "rxjs";
import {Student} from "../model/Student";
import {StudentService} from "../service/student.service";

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

  constructor(private studentService:StudentService) {
  }

  ngOnInit(): void {
        this.getAllStudents();
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
            console.log("Error in loading students data");
          }
        )
      )
  }

  openAddStudentForm() {

    this.openStudentForm =true;
    
  }

  closeStudentForm() {
    this.openStudentForm =false;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

}
