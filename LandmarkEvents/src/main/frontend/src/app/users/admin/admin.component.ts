import { Component, OnInit } from '@angular/core';
import {User} from "../user.model";
import {UserService} from "../user.service";
import {Performer} from "../performer/performer.model";
import {Eventee} from "../eventee/eventee.model";
import {Host} from "../host/host.model";
// import {Router} from "@angular/router";

@Component({
  selector: 'app-performer',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  performers:Performer[] = [];
  eventees:Eventee[] = [];
  hosts:Host[] = [];
  entries:string[] = ["HOST", "EVENTEE", "PERFORMER"];
  tempVal: string='None';
  id : number;
  type: string;
  userName : string;
  firstName : string;
  lastName : string;
  password : string;

  constructor(private userService : UserService) { }

  ngOnInit() {
    this.userService.getUsers("PERFORMER")
      .subscribe(
        (users : Performer[]) => {
          this.performers = users
        },
        (error)=> console.log(error)
      );

    this.userService.getUsers("HOST")
      .subscribe(
        (users : Host[]) => {
          this.hosts = users
        },
        (error)=> console.log(error)
      );

    this.userService.getUsers("EVENTEE")
      .subscribe(
        (users : Eventee[]) => {
          this.eventees = users
        },
        (error)=> console.log(error)
      );
  }

  createUser(){
    console.log("TempValue", this.tempVal);
    if(this.tempVal != 'None'){
      let newUser = new User(this.firstName,this.lastName,this.userName,this.password,this.tempVal);
      this.userService.saveUser(newUser,this.tempVal).subscribe(
        () => {
          this.ngOnInit();
        },
        (error)=> console.log(error)
      );
    } else{
      alert("Cannot create User");
    }


  }

  updateUser(id, type){
    let newUser = new Performer(this.firstName,this.lastName,this.userName,this.password,type);
    this.userService.updateUser(newUser,id,type).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }
  changeUser(user, type){

    this.id = user.id;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.userName = user.userName;
    this.password = user.password;
    this.type = type;

  }

  deletePerformer(user, type){

    this.userService.deleteUser(user,type).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );

  }

}

