import classes.*
import races.*
import java.lang.Exception
import java.util.*

class Character(var isRandom: Boolean = false) {
    var rulebook: Rulebook = Rulebook()
    var name: String
    var strength: Int = 10
    var dexterity: Int = 10
    var constitution: Int = 10
    var intelligence: Int = 10
    var wisdom: Int = 10
    var charisma: Int = 10
    var proficiencyBonus: Int = 2
    var characterClass: Class? = null
    var characterRace: Race? = null
    var background: Background? = null
    var ac: Int = 10
    var hp: Int = 0
    var level: Int = 3
    var weaponAttacks: MutableList<Attack> = mutableListOf()
    var spells: List<Attack> = mutableListOf()
    var otherAbilities: MutableList<Attack> = mutableListOf()

    init {
        name = chooseName()
        if (!isRandom) {
            allocateAttributes(rollAttributes())
            chooseRace()
            chooseClass()
            chooseBackground()
        }
        else {
            randomize()
        }
        ac = getAC()
        hp = getHP()
        addWeaponAttacks()
    }

    private fun chooseName(): String {
        println("Please choose your characters name:")
        print("My name is..")
        var name: String = readln()
        println("Your name is now: $name.")
        return name
    }
    private fun rollAttributes(): MutableList<Int> {
        var attributes: MutableList<Int> = mutableListOf()
        var roll: MutableList<Int> = mutableListOf()
        var rollTotal: Int
        var die1: Int
        var die2: Int
        var die3: Int
        var die4: Int
        println("---Rolling for Stats---")
        for (i in 1..6) {
            println("Roll #$i:")
            die1 = (1..6).random()
            die2 = (1..6).random()
            die3 = (1..6).random()
            die4 = (1..6).random()
            roll.addAll(listOf(die1, die2, die3, die4))
            println(roll)
            println("Dropping lowest..")
            roll.remove(roll.min())
            rollTotal = roll[0] + roll[1] + roll[2]
            println("${roll[0]} + ${roll[1]} + ${roll[2]} = $rollTotal")
            roll.clear()
            attributes.add(rollTotal)
        }
        println("Your rolls: $attributes")
        println("-----------------------")
        return attributes
    }
    private fun allocateAttributes(attributes: MutableList<Int>) {
        var listStats: List<String> = listOf("Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma")
        var input: Int
        var inputIsValid: Boolean = false
        println("---Allocating Attributes---")
        for (element in listStats) {
            println("Your Attributes: $attributes")
            do {
                try {
                    print("Choose from the list above to allocate to $element: ")
                    input = readln().toInt()
                    if (input in attributes) {
                        println("Your $element is now $input.")
                        when (element) {
                            "Strength" -> this.strength = input
                            "Dexterity" -> this.dexterity = input
                            "Constitution" -> this.constitution = input
                            "Intelligence" -> this.intelligence = input
                            "Wisdom" -> this.wisdom = input
                            "Charisma" -> this.charisma = input
                        }
                        attributes.remove(input)
                        inputIsValid = true
                    }
                    else {
                        println("You can only choose from the following list: $attributes")
                        inputIsValid = false
                    }
                }
                catch (ex: Exception) {
                    println("You can only choose from the following list: $attributes")
                    inputIsValid = false
                }
            }
            while (!inputIsValid)
        }
        println("----------------------------")
    }
    private fun chooseRace() {
        var input: String
        println("---Choosing Race---")
        println("Please choose from the following list:")
        for ((i, race) in rulebook.races.withIndex()) {
            println("${i+1}. $race")
        }
        println("10. Random")
        print("Type name: ")
        input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        while (input !in rulebook.races && input != "Random") {
            println("Input was invalid.")
            print("Please choose from the list above: ")
            input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
        if (input == "Random") {
            input = rulebook.races.random()
        }
        when (input) {
            rulebook.races[0] -> this.characterRace = Dragonborn(false)
            rulebook.races[1] -> this.characterRace = Dwarf(false)
            rulebook.races[2] -> this.characterRace = Elf(false)
            rulebook.races[3] -> this.characterRace = Gnome(false)
            rulebook.races[4] -> this.characterRace = HalfElf(false)
            rulebook.races[5] -> this.characterRace = Halfling(false)
            rulebook.races[6] -> this.characterRace = HalfOrc(false)
            rulebook.races[7] -> this.characterRace = Human(false)
            rulebook.races[8] -> this.characterRace = Tiefling(false)
        }
        println("You have chosen the following Race:")
        if (this.characterRace!!.hasSubrace) println("Race: " + this.characterRace!!.subrace + " " + this.characterRace!!.name)
        else println("Race: " + this.characterRace!!.name)
        println(this.characterRace!!.attributes)
        println("Racials: " + this.characterRace!!.racials)
        if (this.characterRace!!.racialSkills.isNotEmpty()) ("Skill Proficiencies: " + this.characterRace!!.racialSkills)
        println("Speed: " + this.characterRace!!.speed)
        println("-------------------")
        this.strength += characterRace!!.str
        this.dexterity += characterRace!!.dex
        this.constitution += characterRace!!.con
        this.intelligence += characterRace!!.int
        this.wisdom += characterRace!!.wis
        this.charisma += characterRace!!.cha
    }
    private fun chooseClass() {
        var input: String
        var isRandom: Boolean = false
        println("---Choosing Class---")
        println("Choose from the following list:")
        for ((i, element) in rulebook.classes.withIndex()) {
            println("${i+1}. $element")
        }
        println("13. Random")
        print("Type name: ")
        input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        while (input !in rulebook.classes && input != "Random") {
            println("Input was invalid.")
            print("Please choose from the list above: ")
            input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
        println("Would you like to 'randomize' any choices? Or 'create' your class manually?")
        var inputRandom = readln().lowercase()
        while (inputRandom != "randomize" && inputRandom != "create") {
            println("Input was invalid. Please type 'randomize' or 'create':")
            inputRandom = readln().lowercase()
        }
        isRandom = inputRandom == "randomize"
        if (input == "Random") {
            input = rulebook.classes.random()
        }
        when (input) {
            rulebook.classes[0] -> this.characterClass = Barbarian(isRandom)
            rulebook.classes[1] -> this.characterClass = Bard(isRandom)
            rulebook.classes[2] -> this.characterClass = Cleric(isRandom)
            rulebook.classes[3] -> this.characterClass = Druid(isRandom)
            rulebook.classes[4] -> this.characterClass = Fighter(isRandom)
            rulebook.classes[5] -> this.characterClass = Monk(isRandom)
            rulebook.classes[6] -> this.characterClass = Paladin(isRandom)
            rulebook.classes[7] -> this.characterClass = Ranger(isRandom)
            rulebook.classes[8] -> this.characterClass = Rogue(isRandom)
            rulebook.classes[9] -> this.characterClass = Sorcerer(isRandom)
            rulebook.classes[10] -> this.characterClass = Warlock(isRandom)
            rulebook.classes[11] -> this.characterClass = Wizard(isRandom)
        }
        var weapons: MutableList<String> = mutableListOf()
        println("You have chosen the following Class:")
        println("Class: " + this.characterClass!!.name)
        println("Subclass: " + this.characterClass!!.subClass)
        println("Hit Die: 1D" + this.characterClass!!.hitDice)
        println("Saving Throws: " + this.characterClass!!.savThrows)
        if (this.characterClass!!.hasShield) println("Armor: " + this.characterClass!!.armor.name + " + Shield")
        else println("Armor: " + this.characterClass!!.armor.name)
        for (weapon in this.characterClass!!.weapons) {
            weapons.add(weapon.name)
        }
        println("Weapons: $weapons")
        println("Other Equipment: " + this.characterClass!!.equipment)
        println("-------------------")
    }
    private fun chooseBackground() {
        var input: String
        println("---Choosing Background---")
        println("Choose from the following list:")
        for ((i, element) in rulebook.backgrounds.withIndex()) {
            println("${i+1}. ${element.name}")
        }
        println("17. Random")
        print("Type name: ")
        input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        var stringListBackgrounds: MutableList<String> = mutableListOf()
        for (background in rulebook.backgrounds) {
            stringListBackgrounds.add(background.name)
        }
        while (input !in stringListBackgrounds && input != "Random") {
            println("Input was invalid.")
            print("Please choose from the list above: ")
            input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
        if (input == "Random") {
            input = rulebook.backgrounds.random().name
        }
        this.background = rulebook.backgrounds[stringListBackgrounds.indexOf(input)]
        println("You have chosen the following Background:")
        println("Background: " + this.background!!.name)
        println("Skills: " + this.background!!.skillProfs[0].name + ", " + this.background!!.skillProfs[1].name)
        println("-------------------------")
    }
    private fun randomize() {
        var roll: MutableList<Int> = mutableListOf((1..6).random(), (1..6).random(), (1..6).random(), (1..6).random())
        roll.remove(roll.min())
        this.strength = roll.sum()
        roll.clear()
        roll = mutableListOf((1..6).random(), (1..6).random(), (1..6).random(), (1..6).random())
        roll.remove(roll.min())
        this.dexterity = roll.sum()
        roll.clear()
        roll = mutableListOf((1..6).random(), (1..6).random(), (1..6).random(), (1..6).random())
        roll.remove(roll.min())
        this.constitution = roll.sum()
        roll.clear()
        roll = mutableListOf((1..6).random(), (1..6).random(), (1..6).random(), (1..6).random())
        roll.remove(roll.min())
        this.intelligence = roll.sum()
        roll.clear()
        roll = mutableListOf((1..6).random(), (1..6).random(), (1..6).random(), (1..6).random())
        roll.remove(roll.min())
        this.wisdom = roll.sum()
        roll.clear()
        roll = mutableListOf((1..6).random(), (1..6).random(), (1..6).random(), (1..6).random())
        roll.remove(roll.min())
        this.charisma = roll.sum()
        roll.clear()
        when (rulebook.classes.random()) {
            rulebook.classes[0] -> this.characterClass = Barbarian(isRandom)
            rulebook.classes[1] -> this.characterClass = Bard(isRandom)
            rulebook.classes[2] -> this.characterClass = Cleric(isRandom)
            rulebook.classes[3] -> this.characterClass = Druid(isRandom)
            rulebook.classes[4] -> this.characterClass = Fighter(isRandom)
            rulebook.classes[5] -> this.characterClass = Monk(isRandom)
            rulebook.classes[6] -> this.characterClass = Paladin(isRandom)
            rulebook.classes[7] -> this.characterClass = Ranger(isRandom)
            rulebook.classes[8] -> this.characterClass = Rogue(isRandom)
            rulebook.classes[9] -> this.characterClass = Sorcerer(isRandom)
            rulebook.classes[10] -> this.characterClass = Warlock(isRandom)
            rulebook.classes[11] -> this.characterClass = Wizard(isRandom)
        }
        when (rulebook.races.random()) {
            rulebook.races[0] -> this.characterRace = Dragonborn(true)
            rulebook.races[1] -> this.characterRace = Dwarf(true)
            rulebook.races[2] -> this.characterRace = Elf(true)
            rulebook.races[3] -> this.characterRace = Gnome(true)
            rulebook.races[4] -> this.characterRace = HalfElf(true)
            rulebook.races[5] -> this.characterRace = Halfling(true)
            rulebook.races[6] -> this.characterRace = HalfOrc(true)
            rulebook.races[7] -> this.characterRace = Human(true)
            rulebook.races[8] -> this.characterRace = Tiefling(true)
        }
        this.background = rulebook.backgrounds.random()

    }
    fun getMod(ability: Int): Int {
        var mod: Int = 0
        when (ability) {
            in (0..1) -> mod = -5
            in (2..3) -> mod = -4
            in (4..5) -> mod = -3
            in (6..7) -> mod = -2
            in (8..9) -> mod = -1
            in (10..11) -> mod = -0
            in (12..13) -> mod = 1
            in (14..15) -> mod = 2
            in (16..17) -> mod = 3
            in (18..19) -> mod = 4
            in (20..21) -> mod = 5
            in (22..23) -> mod = 6
            in (24..25) -> mod = 7
            in (26..27) -> mod = 8
            in (28..29) -> mod = 9
            30 -> mod = 10
        }
        return mod
    }
    private fun getAC(): Int {
        var ac: Int = this.characterClass!!.armor.baseAC
        if (this.characterClass!!.name == "Barbarian" && this.characterClass!!.armor.name == "Unarmored") {
            ac += getMod(this.constitution)
        }
        else if (this.characterClass!!.name == "Monk" && this.characterClass!!.armor.name == "Unarmored") {
            ac += getMod(this.wisdom)
        }
        when(this.characterClass!!.armor.type) {
            "Light" -> {
                ac += getMod(this.dexterity)
            }
            "Medium" -> {
                if (getMod(this.dexterity) <= 2) ac += getMod(this.dexterity)
                else ac +=2
            }
            "Heavy" -> {
            }
        }
        if (this.characterClass!!.hasShield) ac += 2
        return ac
    }
    private fun getHP(): Int {
        var hp = 0
        var input: String = ""
        hp += characterClass!!.hitDice + this.constitution
        if (!isRandom) {
            println("Would you like roll for your HP? (Range between 1 and ${characterClass!!.hitDice} + ${getMod(this.constitution)})")
            println("Or take the medium? (${(characterClass!!.hitDice/2)+1} + ${getMod(this.constitution)})")
            print("Type 'roll' or 'medium': ")
            input = readln().lowercase()
            while (input != "roll" && input != "medium") {
                println("Input was invalid. Please type 'roll' or 'medium'.")
                print("Type: ")
                input = readln().lowercase()
            }
        }
        if (isRandom || input == "roll") {
            for (i in (2..this.level)) {
                hp += (1..this.characterClass!!.hitDice).random() + getMod(this.constitution)
            }
        }
        else {
            for (i in (2..this.level)) {
                hp += (characterClass!!.hitDice/2) + 1 + getMod(this.constitution)
            }
        }
        if (!isRandom) println("Your HP is now $hp.")
        return hp
    }
    private fun addWeaponAttacks() {
        var weaponAttacks: MutableList<Attack> = mutableListOf()
        for (weapon in this.characterClass!!.weapons) {
            var abilityBonus = getMod(this.strength)
            if (weapon.isFinesse || weapon.isRanged) abilityBonus = getMod(this.dexterity)
            if (weapon.name == "Greatsword" || weapon.name == "Maul") {
                weaponAttacks.add(Attack(weapon.name, weapon.damage,2,weapon.damageType,abilityBonus,true))
            }
            else {
                if (weapon.isVersatile) {
                    weaponAttacks.add(Attack("${weapon.name} (1-handed)", weapon.damage,1,weapon.damageType,abilityBonus,true))
                    weaponAttacks.add(Attack("${weapon.name} (2-handed)", weapon.damage+2,1,weapon.damageType,abilityBonus,true))
                }
                else weaponAttacks.add(Attack(weapon.name, weapon.damage,1,weapon.damageType,abilityBonus,true))
            }
        }
        this.weaponAttacks.addAll(weaponAttacks)
    }
}
