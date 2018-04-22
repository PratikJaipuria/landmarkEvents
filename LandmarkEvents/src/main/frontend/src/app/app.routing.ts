import { Routes, RouterModule, Params } from '@angular/router';
import {UsersComponent} from "./users/users.component";
import {HostRegisterComponent} from "./users/host/host-register.component";
import {PerformerComponent} from "./users/performer/performer.component";
import {EventeeComponent} from "./users/eventee/eventee.component";
import {EventComponent} from "./event/event.component";
import {SearchComponent} from "./search/search.component";
import {VenueComponent} from "./venue/venue.component";
import {EveteeProfileComponent} from "./users/eventee/evetee-profile/evetee-profile.component";
import {PerformerProfileComponent} from "./users/performer/performer-profile/performer-profile.component";
import {EventProfileComponent} from "./event/event-profile/event-profile.component";
import {SearchProfileComponent} from "./search/search-profile/search-profile.component";


const appRoutes: Routes = [
  { path : '', component: SearchComponent },
  { path: 'event/:event' , component: SearchProfileComponent},
  { path: 'host/:hostId/event/:eventId', component: EventProfileComponent },
  { path: 'host/:hostId/event', component: EventComponent },
  { path: 'host', component: HostRegisterComponent },
  { path: 'performer/:performerId', component: PerformerProfileComponent },
  { path: 'performer', component: PerformerComponent },
  { path: 'eventee', component: EventeeComponent },
  { path: 'eventee/:eventeeId', component: EveteeProfileComponent },
  { path: 'venue', component: VenueComponent }

];
export const routing = RouterModule.forRoot(appRoutes);
