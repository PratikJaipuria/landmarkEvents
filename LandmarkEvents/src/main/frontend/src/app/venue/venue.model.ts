export class Venue {

  id : number;
  name : string;
  address : string;
  url : string;
  events : Event[];


  constructor(name: string, address: string, url: string) {

    this.name = name;
    this.address = address;
    this.url = url;
  }
}
