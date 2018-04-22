import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {EventService} from "../event.service";
import {Event} from "../event.model";
import {Venue} from "../../venue/venue.model";

@Component({
  selector: 'app-event-profile',
  templateUrl: './event-profile.component.html',
  styleUrls: ['./event-profile.component.css']
})
export class EventProfileComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router,private eventService: EventService) { }

  eventId : number;
  event : Event;
  title : string;
  category : string;
  url : string;

  cityName : string;

  startTime : Date;
  endTime : Date;
  // public performers : Performer[];
  public venue : Venue;


  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.eventId = params['eventId'];
    });

    this.eventService.getEventbyID(this.eventId)
      .subscribe(
        (event : Event) => {
          this.title = event.title;
          this.category = event.category;
          this.cityName = event.cityName;
          this.url = event.url;
          this.startTime = event.startTime;
          this.endTime = event.endTime
        },
        (error)=> console.log(error)
      );



  }


}
