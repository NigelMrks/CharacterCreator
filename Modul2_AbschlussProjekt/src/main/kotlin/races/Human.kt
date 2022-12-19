package races
import Race

class Human(isRandom: Boolean) : Race(isRandom) {
    override fun setProperties() {
        this.name = "Human"
        this.str += 1
        this.dex += 1
        this.con += 1
        this.int += 1
        this.wis += 1
        this.cha += 1
    }
}