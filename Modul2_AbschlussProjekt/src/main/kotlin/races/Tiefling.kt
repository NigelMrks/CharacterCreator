package races
import Race

class Tiefling(isRandom: Boolean) : Race(isRandom) {
    override fun setProperties() {
        this.name = "Tiefling"
        this.str += 2
        this.con += 1
    }
    override fun addRacials() {
        var baseRacials: MutableList<String> = mutableListOf(
            "Darkvision",
            "Hellish Resistance",
            "Infernal Legacy"
        )
        if (!isRandom) println("Racial Abilities: $baseRacials")
        racials.addAll(baseRacials)
    }
}