import { Stats } from "src/app/models/Stats";

export class Creature {

    crId : number;
    name :string;
    stats : Stats;
    battleClass :string;

    constructor(name :string, battleClass :string) {
        this.crId = 2;
        this.name = name;
        this.stats = null;
        this.battleClass = battleClass;
    }
}