import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userServ :UserService) { }

  ngOnInit(): void {
  }

login(){
 this.userServ.login(new User("Greg", "1234")).subscribe(

  (response) =>{
    console.log(response);

    
  }
 )


}

}
