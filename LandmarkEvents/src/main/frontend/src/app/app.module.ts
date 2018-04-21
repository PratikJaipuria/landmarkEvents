import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { HostRegisterComponent } from './users/host/host-register.component';
import {UserService} from "./users/user.service";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import { HostAddListComponent } from './users/event/event.component';
import {routing} from "./app.routing";

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
    FormsModule,
    routing
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
