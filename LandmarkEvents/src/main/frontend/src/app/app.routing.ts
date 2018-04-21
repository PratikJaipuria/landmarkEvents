import { Routes, RouterModule } from '@angular/router';
import { HostRegisterComponent } from './users/host/host-register.component';
import {UsersComponent} from "./users/users.component";
import {HostAddListComponent} from "./users/event/event.component";


const appRoutes: Routes = [
  { path: 'user', component: UsersComponent },
  { path: 'event', component: HostAddListComponent }

];
export const routing = RouterModule.forRoot(appRoutes);
