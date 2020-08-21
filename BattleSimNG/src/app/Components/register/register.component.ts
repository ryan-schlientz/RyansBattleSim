import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userServ :UserService) { }

  ngOnInit(): void {
  }

  uname : string;
  pword : string;

register(){
 this.userServ.register(new User(this.uname, this.pword)).subscribe(

  (response) =>{
    console.log(response);

    
  }
 )


}

}
