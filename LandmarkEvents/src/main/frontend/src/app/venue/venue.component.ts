import { Component, OnInit } from '@angular/core';
import {Host} from "../users/host/host.model";
import {Venue} from "./venue.model";
import {VenueService} from "./venue.service";

@Component({
  selector: 'app-venue',
  templateUrl: './venue.component.html',
  styleUrls: ['./venue.component.css']
})
export class VenueComponent implements OnInit {


  venues:Venue[] = [];
  id : number;
  name : string;
  address : string;
  url : string;

  constructor(private venueService : VenueService) { }

  ngOnInit() {
    this.venueService.getVenue()
      .subscribe(
        (venues : any[]) => {
          this.venues = venues
        },
        (error)=> console.log(error)
      );
  }

  createVenue(venue){

    let newVenue = new Venue(this.name,this.address,this.url);
    this.venueService.saveVenue(newVenue).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }

  updateVenue(id){
    let newVenue = new Venue(this.name,this.address,this.url);
    this.venueService.updateVenue(newVenue, id).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }
  changeVenue(venue){

    this.id =venue.id;
    this.name =venue.name;
    this.address = venue.address;
    this.url = venue.url;
  }

  deleteVenue(venue){

    this.venueService.deleteVenue(venue).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );

  }


}
