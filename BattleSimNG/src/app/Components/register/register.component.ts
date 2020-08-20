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

register(){
 this.userServ.register(new User("Greg", "1234")).subscribe(

  (response) =>{
    console.log(response);

    
  }
 )


}

}
