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
    console.log(this.eventId);

    this.eventService.getEvent(this.eventId).subscribe(
      (res : Event)=>{
        console.log(res);
              this.title =res[0].title;
              this.cityName = res[0].cityName;
              this.url = res[0].url;
              this.startTime = res[0].startTime;
              this.endTime = res[0].endTime;
      },
      () =>{
        this.searchService.searchEventByID(this.eventId)
                .subscribe(
                  (res : any) => {
                    console.log(res);
                    this.title =res.title;
                    this.cityName = res.city;
                    this.url = res.url;
                    this.startTime = res.start_time;
                    this.endTime = res.end_time;

                  },
                  (error)=> console.log(error)
                )}
      // (error: any)=> {console.log(error)}
    );
    // this.eventService.getEvent(this.eventId).subscribe(
    //   (res : Event) => {
    //
    //     console.log("Value   --> ",res);
    //     if(res===null){
    //
    //       this.title =res[0].title;
    //       this.cityName = res[0].cityName;
    //       this.url = res[0].url;
    //       this.startTime = res[0].startTime;
    //       this.endTime = res[0].endTime;
    //     }else{
    //       this.searchService.searchEventByID(this.eventId)
    //         .subscribe(
    //           (res : any) => {
    //             console.log(res);
    //             this.title =res.title;
    //             this.cityName = res.city;
    //             this.url = res.url;
    //             this.startTime = res.start_time;
    //             this.endTime = res.end_time;
    //
    //           },
    //           (error)=> console.log(error)
    //         )
    //     }
    //
    //   }
    // );

  }
}
