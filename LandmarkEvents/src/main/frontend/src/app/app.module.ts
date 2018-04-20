import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { HostRegisterComponent } from './users/host-register/host-register.component';
import {UserService} from "./users/user.service";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import { HostAddListComponent } from './users/host-add-list/host-add-list.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    HostRegisterComponent,
    HostAddListComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
