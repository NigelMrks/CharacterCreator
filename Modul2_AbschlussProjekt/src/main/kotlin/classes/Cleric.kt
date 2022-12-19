package classes
import Class

class Cleric(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Cleric"
        this.isSpellcaster = true
        this.hitDice = 8
        this.savThrows = listOf("Wisdom", "Charisma")
        this.equipmentChoices = listOf(
            listOf("Scale mail", "Leather"),
            listOf("Crossbow, light", "any simple weapon"),
            listOf("Priest's Pack", "Explorer's Pack")
        )
        this.equipmentChoicesType = listOf("armor", "weapon", "other")
    }

    override fun addStaticEquipment() {
        this.equipment.add("Holy Symbol")
        this.equipment.add("Shield")
        this.hasShield = true
        this.weapons.add(rulebook.weapons[6])
    }
}