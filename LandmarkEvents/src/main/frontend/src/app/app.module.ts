import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { HostRegisterComponent } from './users/host/host-register.component';
import {UserService} from "./users/user.service";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {routing} from "./app.routing";
import { SearchComponent } from './search/search.component';
import { EventeeComponent } from './users/eventee/eventee.component';
import { PerformerComponent } from './users/performer/performer.component';
import { EventComponent } from './event/event.component';
import { TicketComponent } from './ticket/ticket.component';
import { ReviewComponent } from './review/review.component';
import { VenueComponent } from './venue/venue.component';
import {SearchService} from "./search/search.service";
import {VenueService} from "./venue/venue.service";
import {EventService} from "./event/event.service";
import { EveteeProfileComponent } from './users/eventee/evetee-profile/evetee-profile.component';
import { PerformerProfileComponent } from './users/performer/performer-profile/performer-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    HostRegisterComponent,
    SearchComponent,
    EventeeComponent,
    PerformerComponent,
    EventComponent,
    TicketComponent,
    ReviewComponent,
    VenueComponent,
    EveteeProfileComponent,
    PerformerProfileComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    routing
  ],
  providers: [UserService,SearchService,VenueService, EventService],
  bootstrap: [AppComponent]
})
export class AppModule { }
