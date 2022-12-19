package races
import Race

class Gnome(isRandom: Boolean) : Race(isRandom) {

    override fun setProperties() {
        this.name = "Gnome"
        this.hasSubrace = true
        this.int += 2
        this.speed = 25
        this.subraces = listOf(
            "Deep", "Rock"
        )
    }
    override fun addRacials() {
        var baseRacials: MutableList<String> = mutableListOf(
            "Darkvision",
            "Gnome Cunning"
        )
        if (!isRandom) println("Racial Abilities: $baseRacials")
        racials.addAll(baseRacials)
    }

    override fun addSubRacials(input: String) {
        var subRacials: MutableList<String> = mutableListOf()

        when(input) {
            "Deep" -> {
                dex += 1
                subRacials.add("Superior Darkvision")
                subRacials.remove("Darkvision")
                subRacials.add("Stone Camouflage")
                subrace = "Deep"
            }
            "Rock" -> {
                con += 1
                subRacials.add("Artificer's Lore")
                subRacials.add("Tinker")
                subrace = "Rock"
            }
        }
        if (!isRandom) println("Subracial Abilities: $subRacials")
        racials.addAll(subRacials)
    }
}