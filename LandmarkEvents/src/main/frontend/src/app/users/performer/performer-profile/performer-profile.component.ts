import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import {UserService} from "../../user.service";
import {Performer} from "../performer.model";
import {Eventee} from "../../eventee/eventee.model";

@Component({
  selector: 'app-performer-profile',
  templateUrl: './performer-profile.component.html',
  styleUrls: ['./performer-profile.component.css']
})
export class PerformerProfileComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router, private userService : UserService) { }
  performerid : number;
  eventee : Eventee[] = [];

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.performerid = params['performerId'];
    });

    this.userService.getEventee(this.performerid)
      .subscribe(
        (eventee : any[]) => {
          this.eventee = eventee
        },
        (error)=> console.log(error)
      );
  }



}
