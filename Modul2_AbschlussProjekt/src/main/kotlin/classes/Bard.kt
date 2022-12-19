package classes
import Class

class Bard(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Bard"
        this.isSpellcaster = true
        this.hitDice = 8
        this.savThrows = listOf("Dexterity", "Charisma")
        this.equipmentChoices = listOf(
            listOf("Rapier", "Longsword", "any simple weapon"),
            listOf("Diplomat's Pack", "Entertainer's Pack")
        )
        this.equipmentChoicesType = listOf("weapon", "other")
    }

    override fun addStaticEquipment() {
        this.equipment.add("Lute")
        this.armor = rulebook.armors[1]
        this.weapons.add(rulebook.weapons[1])
    }
}