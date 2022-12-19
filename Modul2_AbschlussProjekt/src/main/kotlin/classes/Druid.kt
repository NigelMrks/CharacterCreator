package classes
import Class

class Druid(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Druid"
        this.isSpellcaster = true
        this.hitDice = 8
        this.savThrows = listOf("Intelligence", "Wisdom")
        this.equipmentChoices = listOf(
            listOf("Scimitar", "any simple melee weapon")
        )
        this.equipmentChoicesType = listOf("weapon")
    }

    override fun addStaticEquipment() {
        this.equipment.add("Explorer's Pack")
        this.equipment.add("Druidic Focus")
        this.equipment.add("Shield")
        this.hasShield = true
        this.armor = rulebook.armors[1]
        this.weapons.add(rulebook.weapons[1])
    }
}