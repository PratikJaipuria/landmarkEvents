import { Component, OnInit } from '@angular/core';
import {Host} from "../host/host.model";
import {UserService} from "../user.service";
import {Eventee} from "./eventee.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-eventee',
  templateUrl: './eventee.component.html',
  styleUrls: ['./eventee.component.css']
})
export class EventeeComponent implements OnInit {

  evetees:Eventee[] = [];
  id : number;
  userName : string;
  firstName : string;
  lastName : string;
  password : string;

  constructor(private userService : UserService,private router: Router) { }

  ngOnInit() {
    this.userService.getUsers("EVENTEE")
      .subscribe(
        (users : any[]) => {
          this.evetees = users
        },
        (error)=> console.log(error)
      );
  }

  profile(id){
    this.router.navigate(['eventee/' + id]);
  };

  createEventee(){

    let newEventee = new Eventee(this.firstName,this.lastName,this.userName,this.password);
    this.userService.saveUser(newEventee, "EVENTEE").subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }

  updateEventee(id){
    let newEventee = new Eventee(this.firstName,this.lastName,this.userName,this.password);
    this.userService.updateUser(newEventee,id,"EVENTEE").subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }
  changeEventee(user){

    this.id = user.id;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.userName = user.userName;
    this.password = user.password;

  }

  deleteEventee(user){

    this.userService.deleteUser(user,"EVENTEE").subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );

  }

}
