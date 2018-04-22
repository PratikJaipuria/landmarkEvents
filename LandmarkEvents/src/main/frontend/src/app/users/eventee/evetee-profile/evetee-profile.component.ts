import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {UserService} from "../../user.service";
import {Performer} from "../../performer/performer.model";
import {Event} from "../../../event/event.model";

@Component({
  selector: 'app-evetee-profile',
  templateUrl: './evetee-profile.component.html',
  styleUrls: ['./evetee-profile.component.css']
})
export class EveteeProfileComponent implements OnInit {

  eventeeid : number;
  performers : Performer[] = [];
  performer : Performer;
  notFollowing : Performer[] = [];
  constructor(private route: ActivatedRoute,private router: Router, private userService : UserService) { }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.eventeeid = params['eventeeId'];
    });

    this.userService.getPerformersforEventee(this.eventeeid)
      .subscribe(
        (performers : any[]) => {
          this.performers = performers
        },
        (error)=> console.log(error)
      );

    this.userService.notFollowing(this.eventeeid)
      .subscribe(
        (performers : any[]) => {
            this.notFollowing = performers
        },
        (error)=> console.log(error)
      );

  }

  addPerformer(addPerf){
    this.userService.followPerformer(addPerf, this.eventeeid).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }

  removePerformer(addPerf){
    this.userService.unfollowPerformer(addPerf, this.eventeeid).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }
}
