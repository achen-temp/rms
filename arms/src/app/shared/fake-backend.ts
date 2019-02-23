import { Injectable } from "@angular/core";
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpResponse
} from "@angular/common/http";
import { Observable, of } from "rxjs";
import { mergeMap } from "rxjs/operators";

@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {
  constructor() {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    // array in local storage for registered users
    // let users: any[] = JSON.parse(localStorage.getItem('users')) || [];

    // wrap in delayed observable to simulate server api call
    return of(null).pipe(
      mergeMap(() => {
        // fake timesheet summary backend
        if (
          request.url.match(/\/timesheets\/\d+$/) &&
          request.method === "GET"
        ) {
          let urlParts = request.url.split("/");
          let id = parseInt(urlParts[urlParts.length - 1]);
          // console.log(id);
          let responseBody = {};
          if (id) {
            responseBody = {
              status: "success",
              data: [
                {
                  projectName: "Internal",
                  timesheetId: 111,
                  startDate: "01/13/2019",
                  endDate: "01/19/2019",
                  total: "0",
                  status: "New",
                  manager: "Leaf",
                  updatedTime: ""
                },
                {
                  projectName: "Internal",
                  timesheetId: 110,
                  startDate: "12/30/2018",
                  endDate: "01/05/2019",
                  total: "40",
                  status: "Declined",
                  manager: "Leaf",
                  updatedTime: "01/06/2019 10:00:00"
                },
                {
                  projectName: "Internal",
                  timesheetId: 109,
                  startDate: "12/23/2018",
                  endDate: "12/29/2018",
                  total: "40",
                  status: "Approved",
                  manager: "Leaf",
                  updatedTime: "01/03/2019 09:00:00"
                }
              ]
            };
          } else {
            responseBody = {
              status: "failure",
              errorMessage: "Invalid username and/or password"
            };
          }
          // this.cookieService.set(this.cookieId, token);
          return of(new HttpResponse({ status: 200, body: responseBody }));
        }
      })
    );
  }
}
