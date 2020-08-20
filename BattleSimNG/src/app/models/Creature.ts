export class Creature {

    crId : number;
    name :string;
    battleClass :string;

    constructor(crId :number, name :string, battleClass :string) {
        this.crId = crId;
        this.name = name;
        this.battleClass = battleClass;
    }
}