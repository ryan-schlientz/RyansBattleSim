import { Component, OnInit } from '@angular/core';
import { CreatureService } from 'src/app/services/creature.service'
import { Creature } from 'src/app/models/Creature';

@Component({
  selector: 'app-battle',
  templateUrl: './battle.component.html',
  styleUrls: ['./battle.component.css']
})
export class BattleComponent implements OnInit {

  constructor(private cs : CreatureService, ) { 

  }
  
  ngOnInit(): void {
    this.cs.getCreature().subscribe(
      (response) => {
        this.creature = response;
        this.MaxMonsterHp = this.creature.stats.maxHP;
        this.MonsterName = this.creature.name;
        this.CurrMonsterHp = this.MaxMonsterHp;
        this.MonsterAttack = this.creature.stats.attack;
        this.MonsterDefense = this.creature.stats.defense;
      }
    );
  }

  creature : Creature;

  attack: number = 25;
  defense: number = 20;
  MaxHp: number = 100;
  CurrHp: number = 100;

  MaxMonsterHp: number;
  MonsterName: string;
  CurrMonsterHp: number;
  MonsterAttack: number;
  MonsterDefense: number;


  fightLog = [];
  match: boolean = true;


  attackMonster() {
    if (this.match) {
      let dmg = this.random(this.attack) - this.MonsterDefense;
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
      this.addTofightLog("How did you did do that?");
      this.CurrMonsterHp = 0;
      this.CurrHp = 0;
      this.match = false;
    }
    else if (this.CurrMonsterHp <= 0 ) {
      this.addTofightLog("Victory");
      this.CurrMonsterHp = 0;
      this.match = false;
    }
    else if (this.CurrHp <= 0) {
      this.addTofightLog("You're bad. Uninstall");
      this.CurrHp = 0;
      this.match = false;
    }

  }

  addTofightLog(s){
    this.fightLog.unshift(s);
  }


}
