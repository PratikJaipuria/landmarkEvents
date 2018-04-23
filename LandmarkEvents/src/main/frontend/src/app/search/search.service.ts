import {EventEmitter, Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/map";

@Injectable()
export class SearchService {

  //onTaskAdded = new EventEmitter<User>();
  constructor(private http: Http) {
  }

  searchQuery(category:string,location:string){
    let upcomingUrl = "http://api.eventful.com/json/events/search?app_key=4WfzV49BJWfGstmT&keywords=+" +category+ "&location="+ location;
    return this.http.get(upcomingUrl).map(response => response.json());
  }

  searchInternalQuery(category:string,location:string){
   return this.http.get('api/host/event?cityName='+location+'&category='+category).map(response => response.json());
  }

  searchEventByID(id:number){
    return this.http.get('http://api.eventful.com/json/events/get?app_key=4WfzV49BJWfGstmT&id='+id).map(response => response.json());
  }


}
