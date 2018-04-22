import {User} from "../users/user.model";

export class Search {

  public id : number;
  public category : string;
  public location : string;


  constructor(category: string, location: string) {
    this.category = category;
    this.location = location;
  }

// constructor(firstName: string,lastName: string,userName: string,password: string){
  //   this.firstName = firstName;
  //   this.lastName = lastName;
  //   this.userName = userName;
  //   this.password = password;
  // }

}
