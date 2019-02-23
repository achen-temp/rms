import { AuthService } from "./login/auth.service";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpModule } from "@angular/http";
import { RouterModule } from "@angular/router";

import { AppRoutingModule } from "./app.routing";
import { NavbarModule } from "./shared/navbar/navbar.module";
import { FooterModule } from "./shared/footer/footer.module";
import { SidebarModule } from "./sidebar/sidebar.module";

import { AppComponent } from "./app.component";

import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { LoginComponent } from "./login/login/login.component";
import { CookieService } from "ngx-cookie-service";
import { ForgetPwdComponent } from "./login/forget-pwd/forget-pwd.component";
import { ResetPwdComponent } from "./login/reset-pwd/reset-pwd.component";
import { RegisterComponent } from "./login/register/register.component";

import { FakeBackendInterceptor } from "./shared/fake-backend";

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    HttpModule,
    NavbarModule,
    FooterModule,
    SidebarModule,
    HttpClientModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    RegisterComponent,
    AdminLayoutComponent,
    LoginComponent,
    ForgetPwdComponent,
    ResetPwdComponent
  ],
  providers: [
    AuthService, 
    CookieService,
    { provide: HTTP_INTERCEPTORS, useClass: FakeBackendInterceptor, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
