import { Stats } from "src/app/models/Stats";

export class Creature {

    crId : number;
    name :string;
    stats : Stats;
    battleClass :string;

    constructor(crId :number, name :string, stats :Stats, battleClass :string) {
        this.crId = crId;
        this.name = name;
        this.stats = stats;
        this.battleClass = battleClass;
    }
}