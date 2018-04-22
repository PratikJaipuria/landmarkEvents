import {Performer} from "../users/performer/performer.model";
import {Venue} from "../venue/venue.model";

export class Event {

  public url : string;
  public title : string;
  public cityName : string;
  public category : string;
  public startTime : Date;
  public endTime : Date;
  // public performers : Performer[];
  public venue : Venue;

  constructor(url: string, title: string, cityName: string, category: string, startTime: Date,endTime: Date
              ,venue : Venue) {

    this.url = url;
    this.title = title;
    this.cityName = cityName;
    this.category = category;
    this.startTime = startTime;
    this.endTime = endTime;
    // this.performers = performers;
    this.venue = venue;
  }
}
