package races
import Race
import SpecialAbility
import Attack

class Elf(isRandom: Boolean) : Race(isRandom) {
    override fun setProperties() {
        this.name = "Elf"
        this.hasSubrace = true
        this.dex += 2
        this.subraces = listOf(
            "Eladrin", "High", "Wood"
        )
    }
    override fun addRacials() {
        var baseRacials: MutableList<String> = mutableListOf(
            "Darkvision",
            "Fey Ancestry",
            "Keen Senses",
            "Trance",
            "Elf Weapon Training"
        )
        racialSkills.add("Perception")
        if (!isRandom) println("Racial Abilities: $baseRacials")
        racials.addAll(baseRacials)
    }

    override fun addSubRacials(input: String) {
        var subRacials: MutableList<String> = mutableListOf()

        when(input) {
            "Eladrin" -> {
                int += 1
                subRacials.add("Fey Step")
                subrace = "Eladrin"
            }
            "High" -> {
                int += 1
                subRacials.add("Cantrip - Wizard")
                specialAbilities.add(Attack("Firebolt", 10,1,"fire"))
                subrace = "High"
            }
            "Wood" -> {
                wis += 1
                subRacials.add("Fleet of Foot")
                this.speed = 35
                subRacials.add("Mask of the Wild")
                subrace = "Wood"
            }
        }
        if (!isRandom) println("Subracial Abilities: $subRacials")
        racials.addAll(subRacials)
    }
}