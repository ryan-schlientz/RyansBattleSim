export class Stats {

    id: number;
    currentHealth :number;
    maxHP: number;
    attack :number;
    defense :number;
    xp :number;
    gold :number;

    constructor(id:number, currentHealth :number, maxHP: number,
        attack :number, defense :number, xp :number, gold :number ) {
            this.id = id;
            this.currentHealth = currentHealth;
            this.maxHP = maxHP;
            this.attack = attack;
            this.defense = defense;
            this.xp = xp;
            this.gold = gold;
    }
}