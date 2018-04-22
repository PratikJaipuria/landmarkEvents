import {User} from "../user.model";

export class Performer extends User {

  bio : string;

  constructor(firstName: string,lastName: string,userName: string,password: string,bio: string){
    super(firstName,lastName,userName,password, null);
    this.bio = bio;
  }
}
