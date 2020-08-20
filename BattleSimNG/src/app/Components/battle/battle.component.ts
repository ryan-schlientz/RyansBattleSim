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
  attack: number = 13;
  defense: number = 2;
  MaxHp: number = 100;
  CurrHp: number = 100;

  MaxMonsterHp: number = 100;
  MonsterName: string= "TheMegreganator";
  CurrMonsterHp: number = 100;
  MonsterAttack: number = 7;
  Monsterdefense: number = 0;


  fightLog = [];
  match: boolean = true;


  attackMonster() {
    if (this.match) {
      console.log("waaaa");
      let dmg = this.random(this.attack) - this.Monsterdefense;
      if(dmg<1)
        dmg = 1;
      this.CurrMonsterHp -= dmg;
      this.addTofightLog("Player dealt " + dmg + " damage. The monster crys :(~ !");
      this.monsterResponse();
  
    }
  }
  random(i:number){
    return Math.floor(Math.random() * i) + 1;
  }
  defend() {
    if (this.match) {
      this.addTofightLog("You wimp");
      console.log("defendwaaaa");
      this.monsterResponse();
    }

  }
  monsterResponse() {
    //  let move:number = Math.floor(Math.random() * 2);
    if (this.match) {
      let move: number = 0;
      switch (move) {
        //Monster Attac
        case 0:
          let dmg = this.random(this.MonsterAttack) - this.defense;
          if(dmg<1)
            dmg = 1;
          this.CurrHp -= dmg;
          this.addTofightLog("The " + this.MonsterName + " dealt " + dmg + " damage. waaaaaaaaaa");
          break;
        //Monster protec
        //    case 1:
      }
      this.refCheck();
    }
  }
  refCheck() {
    if (this.CurrMonsterHp <= 0 && this.CurrHp <= 0 ) {
      console.log("Both of you are dead");
      this.addTofightLog("How did you did do that?");
      this.CurrMonsterHp = 0;
      this.CurrHp = 0;
      this.match = false;
    }
    else if (this.CurrMonsterHp <= 0 ) {
      console.log("Victory");
      this.addTofightLog("Victory");
      this.CurrMonsterHp = 0;
      this.match = false;
    }
    else if (this.CurrHp <= 0) {
      console.log("You're bad.uninstall");
      this.addTofightLog("You're bad. Uninstall");
      this.CurrHp = 0;
      this.match = false;
    }

  }

  addTofightLog(s){
    this.fightLog.unshift(s);
  }


}
