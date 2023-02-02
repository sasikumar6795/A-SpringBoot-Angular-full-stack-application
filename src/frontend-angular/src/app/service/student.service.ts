import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../model/Student";


@Injectable({
  providedIn: 'root'
})
export class StudentService {
  url: string = "http://localhost:8080"
  constructor(private httpClient: HttpClient) { }

  getAllStudents() : Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.url+"/api/v1/students");
  }
}
