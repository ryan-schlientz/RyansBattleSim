import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userServ :UserService, private router :Router) { }

  ngOnInit(): void {
  }

  ifLogin: boolean = false;

loginUser(){
 this.userServ.loginUser(new User("username", "password")).subscribe(

  (response) =>{
    console.log(response);
    console.log("success");
    if (response ==null){
      this.ifLogin=true;
      this.router.navigate(['myAccount']);



    }

    
  }
 )


}

}
