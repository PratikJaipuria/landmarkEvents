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
  id : number;
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
    this.userService.saveUser(newUser).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );


  }

  updateUser(id){
    let newUser = new User(this.firstName,this.lastName,this.userName,this.password);
    this.userService.updateUser(newUser,id).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }
  changeUser(user){

    this.id = user.id;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.userName = user.userName;
    this.password = user.password;

  }

  deleteUser(user){

    this.userService.deleteUser(user).subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );

  }
}
