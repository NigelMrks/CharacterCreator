package classes
import Class

class Fighter(isRandom: Boolean, var isRedPrince: Boolean = false): Class(isRandom) {

    init {
        setClassVariables()
        if (isRedPrince){
            createRedPrince()
        }
        else {
            chooseEquipment()
            chooseSubClass()
        }

    }

    override fun setClassVariables() {
        this.name = "Fighter"
        this.isSpellcaster = false
        this.hitDice = 10
        this.savThrows = listOf("Strength", "Constitution")
        this.equipmentChoices = listOf(
            listOf("Chain mail", "Leather"),
            listOf("Crossbow, light", "Handaxe"),
            listOf("Dungeoneer's Pack", "Explorer's Pack")
        )
        this.equipmentChoicesType = listOf("armor", "weapon", "other")
    }

    override fun addStaticEquipment() {
        chooseWeapon(true, true)
        this.equipment.add("Shield")
        this.hasShield = true
    }

    fun createRedPrince() {

        this.hasShield = true
        this.armor = rulebook.armors[9]
        this.weapons.add(rulebook.weapons[18])
        this.weapons.add(rulebook.weapons[21])
    }

    override fun classActions() {

    }
}