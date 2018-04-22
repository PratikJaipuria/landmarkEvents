import { Component, OnInit } from '@angular/core';
import {UserService} from "../users/user.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Venue} from "../venue/venue.model";
import {EventService} from "./event.service";
import {Performer} from "../users/performer/performer.model";
import {Event} from "./event.model";
import {VenueService} from "../venue/venue.service";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})

export class EventComponent implements OnInit {

  events:Event[] = [];
  cityName : string;
  title : string;
  startTime : Date;
  endTime: Date;
  url : string;
  venues: Venue[] = [];
  performers : Performer[] = [];
  eventPerformers : Performer[] = [];
  hostid : number;
  params: Params;
  category : string;
  venue : Venue;

  constructor(private route: ActivatedRoute,private router: Router, private userService: UserService, private eventService: EventService, private venueService : VenueService) {

  }

  ngOnInit() {

    this.route.params.forEach((params: Params) => {
      this.hostid = params['hostId'];

    });
    this.userService.getUsers("PERFORMER")
      .subscribe(
        (performers : any[]) => {
          this.performers = performers
        },
        (error)=> console.log(error)
      );

    this.venueService.getVenue()
      .subscribe(
        (venues : any[]) => {
          this.venues = venues
        },
        (error)=> console.log(error)
      );

    this.eventService.getEvent(this.hostid)
      .subscribe(
        (events : any[]) => {
          this.events = events
        },
        (error)=> console.log(error)
      );


  }

  createEvent(){
    let newEvent = new Event(this.url,this.title,this.cityName,this.category,this.startTime,this.endTime,this.venue);
    this.eventService.saveEvent(newEvent, this.hostid).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }



}
