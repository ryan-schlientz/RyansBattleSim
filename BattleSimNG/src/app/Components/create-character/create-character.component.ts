import { Component, OnInit } from '@angular/core';
import { CharacterService } from 'src/app/services/character.service';
import { Creature } from 'src/app/models/Creature';

@Component({
  selector: 'app-create-character',
  templateUrl: './create-character.component.html',
  styleUrls: ['./create-character.component.css']
})
export class CreateCharacterComponent implements OnInit {

  constructor(private charServ : CharacterService ) { }

  ngOnInit(): void {
  }

 

  create(){
    this.charServ.create(new Creature("Carl", "Melee")).subscribe(

      (response) =>{
        console.log(response);
  }
    )
}


}
