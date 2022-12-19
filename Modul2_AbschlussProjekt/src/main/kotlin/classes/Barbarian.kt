package classes
import Class

class Barbarian(isRandom: Boolean): Class(isRandom) {
    var isRaging = false

    override fun setClassVariables() {
        this.name = "Barbarian"
        this.isSpellcaster = false
        this.hitDice = 12
        this.savThrows = listOf("Strength", "Constitution")
        this.equipmentChoices = listOf(
            listOf("Greataxe", "any martial melee weapon"),
            listOf("Handaxe", "any simple weapon")
        )
        this.equipmentChoicesType = listOf("weapon", "weapon")
    }

    override fun addStaticEquipment() {
        this.equipment.add("Explorer's Pack")
        for (i in 1..4) {
            this.weapons.add(rulebook.weapons[4])
        }
    }

}