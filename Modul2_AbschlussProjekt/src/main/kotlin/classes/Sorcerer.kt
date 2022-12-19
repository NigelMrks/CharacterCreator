package classes
import Class

class Sorcerer(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Sorcerer"
        this.isSpellcaster = true
        this.hitDice = 6
        this.savThrows = listOf("Constitution", "Charisma")
        this.equipmentChoices = listOf(
            listOf("Crossbow, light", "any simple weapon"),
            listOf("Component Pouch", "Arcane Focus"),
            listOf("Dungeoneer's Pack", "Explorer's Pack")
        )
        this.equipmentChoicesType = listOf("weapon", "other", "other")
    }

    override fun addStaticEquipment() {
        for (i in 1..2) {
            this.weapons.add(rulebook.weapons[1])
        }
    }
}