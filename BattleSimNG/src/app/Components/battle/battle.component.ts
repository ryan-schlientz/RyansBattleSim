import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-battle',
  templateUrl: './battle.component.html',
  styleUrls: ['./battle.component.css']
})
export class BattleComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
   attack:number = 1;
   defense:number = 2;
   MaxHp:number=-1;
   MonsterHp:number=9000;


}
