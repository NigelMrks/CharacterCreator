package classes
import Class

class Rogue(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Rogue"
        this.isSpellcaster = false
        this.hitDice = 8
        this.savThrows = listOf("Dexterity", "Intelligence")
        this.equipmentChoices = listOf(
            listOf("Rapier", "Shortsword"),
            listOf("Shortbow", "Shortsword"),
            listOf("Burglar's Pack", "Dungeoneer's Pack", "Explorer's Pack")
        )
        this.equipmentChoicesType = listOf("weapon", "weapon", "other")
    }

    override fun addStaticEquipment() {
        this.armor = rulebook.armors[1]
        for (i in 1..2) {
            this.weapons.add(rulebook.weapons[1])
        }
        this.equipment.add("Thieves' Tools")
    }
}