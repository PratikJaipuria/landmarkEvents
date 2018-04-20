export class User {

  public id : number;
  public firstName : string;
  public lastName : string;
  public userName : string;
  public password : string;


  constructor(firstName: string,lastName: string,userName: string,password: string){
   	this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
  }

}
