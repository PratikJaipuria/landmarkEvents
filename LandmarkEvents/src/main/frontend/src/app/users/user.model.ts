export class User {

  public id : number;
  public type:string;
  public firstName : string;
  public lastName : string;
  public userName : string;
  public password : string;


  constructor(firstName: string,lastName: string,userName: string,password: string, type:string){
    this.type = type;
   	this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
  }

}
