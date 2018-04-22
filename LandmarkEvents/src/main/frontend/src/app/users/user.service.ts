import {EventEmitter, Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/map";
import {User} from "./user.model";
import {Performer} from "./performer/performer.model";

@Injectable()
export class UserService{

  //onTaskAdded = new EventEmitter<User>();
  constructor(private http:Http){
  }

  getEventee(id:number){
    return this.http.get('/api/performer/'+id+'/followers').map(response => response.json());
  }
  notFollowing(id:number){
    return this.http.get('/api/eventee/'+id+'/notfollowing').map(response => response.json());
  }
  unfollowPerformer(performer:Performer,id:number){
    return this.http.put('/api/eventee/'+id+'/unfollowperformer', performer).map(response => response.json());
  }
  followPerformer(performer:Performer,id:number){
    return this.http.put('/api/eventee/'+id+'/performer', performer).map(response => response.json());
  }
  getPerformersforEventee(id:number){
    return this.http.get('/api/eventee/'+id+'/performer').map(response => response.json());
  }
  getUsers(type:string){
    if(type=="HOST")
      return this.http.get('/api/host').map(response => response.json());
    if(type=="PERFORMER")
      return this.http.get('/api/performer').map(response => response.json());
    if(type=="EVENTEE")
      return this.http.get('/api/eventee').map(response => response.json());
  }

  saveUser(user : User, type : string){
      if(type=="HOST")
        return this.http.post('/api/host',user).map(response => response.json());
      if(type=="PERFORMER")
        return this.http.post('/api/performer',user).map(response => response.json());
      if(type=="EVENTEE")
        return this.http.post('/api/eventee',user).map(response => response.json());
  }

  updateUser(user : User , id : number, type : string){
    if(type=="HOST")
      return this.http.put('/api/host/' + id , user).map(response => response.json());
    if(type=="PERFORMER")
      return this.http.put('/api/performer/' + id , user).map(response => response.json());
    if(type=="EVENTEE")
      return this.http.put('/api/eventee/' + id , user).map(response => response.json());
  }
  deleteUser(user : User,type : string){
    console.log(user);
    if(type=="HOST")
      return this.http.delete('/api/host/' + user.id);//.map(response => response.json());
    if(type=="PERFORMER")
      return this.http.delete('/api/performer/' + user.id);
    if(type=="EVENTEE")
      return this.http.delete('/api/eventee/' + user.id);
  }
}
