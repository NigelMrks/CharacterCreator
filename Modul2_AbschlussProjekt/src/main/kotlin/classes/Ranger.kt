package classes
import Class

class Ranger(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Ranger"
        this.isSpellcaster = true
        this.hitDice = 10
        this.savThrows = listOf("Strength", "Dexterity")
        this.equipmentChoices = listOf(
            listOf("Scale mail", "Leather"),
            listOf("Shortsword", "any simple melee weapon"),
            listOf("Shortsword", "any simple melee weapon"),
            listOf("Dungeoneer's Pack", "Explorer's Pack")
        )
        this.equipmentChoicesType = listOf("armor", "weapon", "weapon", "other")
    }

    override fun addStaticEquipment() {
        this.weapons.add(rulebook.weapons[35])
    }
}