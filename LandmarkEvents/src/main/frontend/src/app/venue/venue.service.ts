import {EventEmitter, Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/map";
import {Venue} from "./venue.model";

@Injectable()
export class VenueService{

  constructor(private http:Http){
  }

  getVenue(){
    return this.http.get('/api/venue').map(response => response.json());
  }
  saveVenue(venue : Venue){
      return this.http.post('/api/venue',venue).map(response => response.json());
  }
  updateVenue(venue : Venue , id : number){
      return this.http.put('/api/venue/' + id , venue).map(response => response.json());
  }
  deleteVenue(venue : Venue){
      return this.http.delete('/api/eventee/' + venue.id);
  }

}
