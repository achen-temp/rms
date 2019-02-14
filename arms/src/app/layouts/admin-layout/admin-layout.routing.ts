import { ManagerComponent } from "./../../timesheets/manager/manager.component";
import { Routes } from "@angular/router";

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

export const AdminLayoutRoutes: Routes = [
  { path: "dashboard", component: HomeComponent },
  { path: "user", component: UserComponent },
  { path: "table", component: TablesComponent },
  { path: "timesheet", component: TimesheetsComponent },
  { path: "timesheetdetail", component: TimesheetDetailComponent },
  { path: "typography", component: TypographyComponent },
  { path: "icons", component: IconsComponent },
  { path: "maps", component: MapsComponent },
  { path: "notifications", component: NotificationsComponent },
  { path: "upgrade", component: UpgradeComponent },
  { path: "manager", component: ManagerComponent },
  { path: "test", component: TestComponent } // TestComponent is popup modal example.
];
