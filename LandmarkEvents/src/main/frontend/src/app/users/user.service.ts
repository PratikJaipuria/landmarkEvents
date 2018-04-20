import {EventEmitter, Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/map";
import {User} from "./user.model";

@Injectable()
export class UserService{

  //onTaskAdded = new EventEmitter<User>();
  constructor(private http:Http){
  }

  getUsers(){

    return this.http.get('/api/host').map(response => response.json());
  }

  saveUser(user : User){
      return this.http.post('/api/host',user).map(response => response.json());
  }
}
