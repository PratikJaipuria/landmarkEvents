import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Event} from "../../event/event.model";
import {Venue} from "../../venue/venue.model";
import {SearchService} from "../search.service";
import {EventService} from "../../event/event.service";
import {isNumber} from "util";

@Component({
  selector: 'app-search-profile',
  templateUrl: './search-profile.component.html',
  styleUrls: ['./search-profile.component.css']
})
export class SearchProfileComponent implements OnInit {

  constructor(private eventService : EventService,private route: ActivatedRoute,private router: Router, private searchService : SearchService) {
  }

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

    if( isNumber(this.event) ){
      this.eventService.getEvent(this.eventId)
    }else{
      this.searchService.searchEventByID(this.eventId)
        .subscribe(
          (res : any[]) => {
            // console.log(res);
            // this.result.push(res['events']['event'])
          },
          (error)=> console.log(error)
        );
    }

    console.log(this.event);
    this.title = this.event.title;
    this.category = this.event.category;
    this.cityName = this.event.cityName;
    this.url = this.event.url;
    this.startTime = this.event.startTime;
    this.endTime = this.event.endTime;
    this.venue = this.event.venue;

  }
}
