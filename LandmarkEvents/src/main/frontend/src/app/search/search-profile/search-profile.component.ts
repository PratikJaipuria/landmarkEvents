import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Event} from "../../event/event.model";
import {Venue} from "../../venue/venue.model";

@Component({
  selector: 'app-search-profile',
  templateUrl: './search-profile.component.html',
  styleUrls: ['./search-profile.component.css']
})
export class SearchProfileComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router) {
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
      this.event = params['event'];
    });
    console.log(this.event);
    this.title = this.event.title;
    this.category = this.event.category;
    this.cityName = this.event.cityName;
    this.url = this.event.url;
    this.startTime = this.event.startTime;
    this.endTime = this.event.endTime;

  }
}
