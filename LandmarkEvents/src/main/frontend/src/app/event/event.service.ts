import {Http} from "@angular/http";
import {Injectable} from "@angular/core";
import "rxjs/add/operator/map";
import {Event} from "./event.model";
import {Venue} from "../venue/venue.model";

@Injectable()
export class EventService {

  constructor(private http: Http) {
  }

  saveEvent(event : Event, venuId: number , hostId : number) {
    return this.http.post('/api/host/'+ hostId +'/venue/'+ venuId + '/event',event).map(response => response.json());

  }

  setVenueforEvent(eventId:number, venue : Venue){

    return this.http.put('/api/event/'+ eventId + '/venue',venue).map(response => response.json());
  }

  updateEvent(event : Event, eventId : number) {
    return this.http.put('/api/host/event/'+ eventId, event).map(response => response.json());
  }

  getEvent(hostId : number){
    return this.http.get('api/host/event?hostId='+ hostId).map(response => response.json());
  }

  getEventbyID(eventId : number){
    return this.http.get('api/event/' + eventId).map(response => response.json());
  }
}
