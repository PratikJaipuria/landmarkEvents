import {User} from "../user.model";

export class Eventee extends User {

  constructor(firstName: string,lastName: string,userName: string,password: string){
    super(firstName,lastName,userName,password);
  }
}
