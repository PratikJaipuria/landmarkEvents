import { Component, OnInit } from '@angular/core';
import {Performer} from "./performer.model";
import {UserService} from "../user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-performer',
  templateUrl: './performer.component.html',
  styleUrls: ['./performer.component.css']
})
export class PerformerComponent implements OnInit {

  performers:Performer[] = [];
  id : number;
  userName : string;
  firstName : string;
  lastName : string;
  password : string;
  bio : string;
  constructor(private userService : UserService,private router: Router) { }

  ngOnInit() {
    this.userService.getUsers("PERFORMER")
      .subscribe(
        (users : any[]) => {
          this.performers = users
        },
        (error)=> console.log(error)
      );
  }

  createPerformer(){

    let newEventee = new Performer(this.firstName,this.lastName,this.userName,this.password,this.bio);
    this.userService.saveUser(newEventee, "PERFORMER").subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );


  }

  profile(id){
    this.router.navigate(['performer/' + id]);
  };
  updatePerformer(id){
    let newEventee = new Performer(this.firstName,this.lastName,this.userName,this.password,this.bio);
    this.userService.updateUser(newEventee,id,"PERFORMER").subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }
  changePerformer(user){

    this.id = user.id;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.userName = user.userName;
    this.password = user.password;
    this.bio = user.bio;

  }

  deletePerformer(user){

    this.userService.deleteUser(user,"PERFORMER").subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );

  }

}

