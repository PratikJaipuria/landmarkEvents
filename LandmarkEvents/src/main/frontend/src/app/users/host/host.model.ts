import {User} from "../user.model";

export class Host extends User {

  companyName : string;

  constructor(firstName: string,lastName: string,userName: string,password: string,companyName: string){
    super(firstName,lastName,userName,password, null);
    this.companyName = companyName;
  }
}
