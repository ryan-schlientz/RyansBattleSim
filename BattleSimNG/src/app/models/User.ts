export class User {

    id : number;
    username :string;
    password :string;
    Role : any;
  

    constructor(username :string, password :string) {
        this.id = 1;
        this.username = username;
        this.password = password;
        this.Role=null;
    }
}