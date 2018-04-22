import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";
import {Host} from "./host.model";
import {Router} from '@angular/router';
@Component({
  selector: 'app-host-register',
  templateUrl: './host-register.component.html',
  styleUrls: ['./host-register.component.css']
})
export class HostRegisterComponent implements OnInit {

  hosts:Host[] = [];
  id : number;
  userName : string;
  firstName : string;
  lastName : string;
  password : string;
  companyName : string;

  constructor(private userService : UserService, private router: Router) { }

  ngOnInit() {
    this.userService.getUsers("HOST")
      .subscribe(
        (users : any[]) => {
          this.hosts = users
        },
        (error)=> console.log(error)
      );
  }

  createEvent(id){
    this.router.navigate(['host/' + id +'/event']);
  };

  createHost(){
    let newHost = new Host(this.firstName,this.lastName,this.userName,this.password,this.companyName);
    this.userService.saveUser(newHost, "HOST").subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }

  updateHost(id){
    let newHost = new Host(this.firstName,this.lastName,this.userName,this.password, this.companyName);
    this.userService.updateUser(newHost,id,"HOST").subscribe(
      (data : any) => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );
  }
  changeHost(user){

    this.id = user.id;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.userName = user.userName;
    this.password = user.password;
    this.companyName = user.companyName;

  }

  deleteHost(user){

    this.userService.deleteUser(user,"HOST").subscribe(
      () => {
        this.ngOnInit();
      },
      (error)=> console.log(error)
    );

  }
}
