import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ModalComponent } from "./../../shared/modal/modal/modal.component";
import { DraggableDirective } from "./../../shared/draggable/draggable.directive";
import { LbdModule } from "../../lbd/lbd.module";
import { NguiMapModule } from "@ngui/map";
import { AdminLayoutRoutes } from "./admin-layout.routing";

import { HomeComponent } from "../../home/home.component";
import { UserComponent } from "../../user/user.component";
import { TablesComponent } from "../../tables/tables.component";
import { TypographyComponent } from "../../typography/typography.component";
import { IconsComponent } from "../../icons/icons.component";
import { MapsComponent } from "../../maps/maps.component";
import { NotificationsComponent } from "../../notifications/notifications.component";
import { UpgradeComponent } from "../../upgrade/upgrade.component";
import { TimesheetsComponent } from "app/timesheets/timesheets.component";
import { TimesheetDetailComponent } from "app/timesheets/timesheet-detail/timesheet-detail.component";
import { TestComponent } from "app/shared/modal/test/test.component";
import { ResizableDirective } from "app/shared/resizable/resizable.directive";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    LbdModule,
    NguiMapModule.forRoot({
      apiUrl: "https://maps.google.com/maps/api/js?key=YOUR_KEY_HERE"
    })
  ],
  declarations: [
    HomeComponent,
    UserComponent,
    TablesComponent,
    TimesheetsComponent,
    TimesheetDetailComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    UpgradeComponent,
    DraggableDirective,
    ResizableDirective,
    ModalComponent,
    TestComponent
  ]
})
export class AdminLayoutModule {}
