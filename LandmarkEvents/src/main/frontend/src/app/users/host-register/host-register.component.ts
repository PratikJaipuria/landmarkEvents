import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";
import {User} from "../user.model";

@Component({
  selector: 'app-host-register',
  templateUrl: './host-register.component.html',
  styleUrls: ['./host-register.component.css']
})
export class HostRegisterComponent implements OnInit {

  users:User[] = [];
  userName : string;
  firstName : string;
  lastName : string;
  password : string;

  constructor(private userService : UserService) { }

  ngOnInit() {


    this.userService.getUsers()
      .subscribe(
        (users : any[]) => {
          this.users = users
        },
        (error)=> console.log(error)
      );
  }

  createUser(user){

    let newUser = new User(this.firstName,this.lastName,this.userName,this.password);
    this.userService.saveUser(newUser).subscribe();
    this.ngOnInit();
  }
}
