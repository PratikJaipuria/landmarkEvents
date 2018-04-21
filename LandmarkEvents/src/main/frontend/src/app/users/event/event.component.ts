import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";
import {User} from "../user.model";

@Component({
  selector: 'app-event',
  templateUrl: './event.html',
  styleUrls: ['./event.css']
})
export class HostAddListComponent implements OnInit {
  user: User;
  userName : string;
  firstName : string;
  lastName : string;
  password : string;
  constructor(private userService : UserService) { }

  createUser() {
    let newUser = new User(this.firstName,this.lastName,this.userName,this.password);
    this.userService.saveUser(newUser).subscribe();
  }
  ngOnInit() {
  }

}