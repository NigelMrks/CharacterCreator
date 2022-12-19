package classes
import Class

class Monk(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Monk"
        this.isSpellcaster = false
        this.hitDice = 8
        this.savThrows = listOf("Strength", "Dexterity")
        this.equipmentChoices = listOf(
            listOf("Shortsword", "any simple weapon"),
            listOf("Dungeoneer's Pack", "Explorer's Pack")
        )
        this.equipmentChoicesType = listOf("weapon", "other")
    }

    override fun addStaticEquipment() {
        for (i in 1..10) {
            this.weapons.add(rulebook.weapons[11])
        }
    }
}