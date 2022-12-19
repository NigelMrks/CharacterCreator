package classes
import Class

class Warlock(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Warlock"
        this.isSpellcaster = true
        this.hitDice = 8
        this.savThrows = listOf("Wisdom", "Charisma")
        this.equipmentChoices = listOf(
            listOf("Crossbow, light", "any simple weapon"),
            listOf("Component Pouch", "Arcane Focus"),
            listOf("Dungeoneer's Pack", "Scholar's Pack")
        )
        this.equipmentChoicesType = listOf("weapon", "other", "other")
    }

    override fun addStaticEquipment() {
        this.armor = rulebook.armors[1]
        chooseWeapon(false, true)
        for (i in 1..2) {
            this.weapons.add(rulebook.weapons[1])
        }
    }
}