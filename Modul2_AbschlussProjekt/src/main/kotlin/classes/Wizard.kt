package classes
import Class

class Wizard(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Wizard"
        this.isSpellcaster = true
        this.hitDice = 6
        this.savThrows = listOf("Intelligence", "Wisdom")
        this.equipmentChoices = listOf(
            listOf("Quarterstaff", "Dagger"),
            listOf("Component Pouch", "Arcane Focus"),
            listOf("Scholar's Pack", "Explorer's Pack")
        )
        this.equipmentChoicesType = listOf("weapon", "other", "other")
    }

    override fun addStaticEquipment() {
        this.equipment.add("Spellbook")
    }
}