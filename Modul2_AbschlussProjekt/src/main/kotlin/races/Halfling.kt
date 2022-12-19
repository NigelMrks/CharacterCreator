package races
import Race

class Halfling(isRandom: Boolean) : Race(isRandom) {
    override fun setProperties() {
        this.name = "Halfling"
        this.dex += 2
        this.speed = 25
        this.hasSubrace = true
        this.subraces = listOf(
            "Lightfoot", "Stout"
        )
    }
    override fun addRacials() {
        var baseRacials: MutableList<String> = mutableListOf(
            "Lucky",
            "Brave",
            "Halfling Nimbleness"
        )
        if (!isRandom) println("Racial Abilities: $baseRacials")
        racials.addAll(baseRacials)
    }
    override fun addSubRacials(input: String) {
        var subRacials: MutableList<String> = mutableListOf()

        when(input) {
            "Lightfoot" -> {
                cha += 1
                subRacials.add("Naturally Stealthy")
                subrace = "Lightfoot"
            }
            "Stout" -> {
                con += 1
                subRacials.add("Stout Resilience")
                subrace = "Stout"
            }
        }
        if (!isRandom) println("Subracial Abilities: $subRacials")
        racials.addAll(subRacials)
    }
}