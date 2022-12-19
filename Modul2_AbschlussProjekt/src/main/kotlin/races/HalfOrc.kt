package races
import Race

class HalfOrc(isRandom: Boolean) : Race(isRandom) {
    override fun setProperties() {
        this.name = "Half-Orc"
        this.str += 2
        this.con += 1
    }
    override fun addRacials() {
        var baseRacials: MutableList<String> = mutableListOf(
            "Darkvision",
            "Menacing",
            "Relentless Endurance",
            "Savage Attacks"
        )
        if (!isRandom) println("Racial Abilities: $baseRacials")
        racials.addAll(baseRacials)
    }
}