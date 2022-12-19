package classes
import Class

class Paladin(isRandom: Boolean): Class(isRandom) {

    override fun setClassVariables() {
        this.name = "Paladin"
        this.isSpellcaster = true
        this.hitDice = 10
        this.savThrows = listOf("Wisdom", "Charisma")
        this.equipmentChoices = listOf(
            listOf("Javelin", "any simple melee weapon"),
            listOf("Priest's Pack", "Explorer's Pack")
        )
        this.equipmentChoicesType = listOf("weapon", "other")
    }

    override fun addStaticEquipment() {
        chooseWeapon(true, true)
        for (i in 1..4) {
            this.weapons.add(rulebook.weapons[4])
        }
        this.equipment.add("Holy Symbol")
        this.equipment.add("Shield")
        this.hasShield = true
        this.armor = rulebook.armors[4]
    }
}