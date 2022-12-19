import java.util.*

open class Class(var isRandom: Boolean=false) {
    var name: String = "placeholder_class"
    var rulebook = Rulebook()
    var isSpellcaster: Boolean = false
    var hitDice: Int = 0
    var savThrows: List<String> = listOf()
    var armor: Armor = Armor("Unarmored", "Light", 10)
    var hasShield: Boolean = false
    var weapons: MutableList<Weapon> = mutableListOf(Weapon("Unarmed Strike", false, false, 1, "bludgeoning", "5 ft."))
    var equipment: MutableList<String> = mutableListOf()
    var classFeatures: MutableList<String> = mutableListOf()
    var actions: MutableList<Attack> = mutableListOf()
    var numberOfCantrips: Int = 0
    var numberOfSpells: Int = 0
    var spellSlotsLevelOne: Int = 0
    var spellSlotsLevelTwo: Int = 0
    var subClass: String = "None"
    var equipmentChoices: List<List<String>> = listOf(
        listOf("Weapon A", "Weapon B"),
        listOf("Armor A", "Armor B", "Armor C"),
        listOf("Other A", "Other B", "Other C", "Other D")
    )
    var equipmentChoicesType: List<String> = listOf("weapon", "armor", "other")

    init {
        setClassVariables()
        chooseEquipment()
        chooseSubClass()
    }
    open fun setClassVariables() {
        //The Super-Class "Class" has no Class Variables to set
    }
    fun chooseEquipment() {
        var stringListWeapons: MutableList<String> = mutableListOf()
        for (weapon in rulebook.weapons) {
            stringListWeapons.add(weapon.name)
        }
        var stringListArmors: MutableList<String> = mutableListOf()
        for (armor in rulebook.armors) {
            stringListArmors.add(armor.name)
        }
        if (!isRandom) {
            var choice: String
            var i = 0
            println("Characters of the " + this.name + " class have following " + equipmentChoices.size + " Equipment Choices:")
            for (element in equipmentChoices) {
                choice = choiceABCD(element)
                when (equipmentChoicesType[equipmentChoices.indexOf(element)]) {
                    "weapon" -> {
                        if (choice == "any simple weapon" || choice == "any simple melee weapon" || choice == "any martial weapon" || choice == "any martial melee weapon") {
                            when (choice) {
                                "any simple weapon" -> choice = chooseWeapon(false, true)
                                "any simple melee weapon" -> choice = chooseWeapon(false, false)
                                "any martial weapon" -> choice = chooseWeapon(true, true)
                                "any martial melee weapon" -> choice = chooseWeapon(true, false)
                            }
                        }
                        this.weapons.add(rulebook.weapons[stringListWeapons.indexOf(choice)])
                    }
                    "armor" -> {
                        this.armor = rulebook.armors[stringListArmors.indexOf(choice)]
                    }
                    "other" -> {
                        this.equipment.add(choice)
                    }
                }
            }
        }
        else {
            var random: String
            for (element in equipmentChoices) {
                random = element.random()
                when (equipmentChoicesType[equipmentChoices.indexOf(element)]) {
                    "weapon" -> {
                        if (random == "any simple weapon" || random == "any simple melee weapon" || random == "any martial weapon" || random == "any martial melee weapon") {
                            when (random) {
                                "any simple weapon" -> random = chooseWeapon(false, true)
                                "any simple melee weapon" -> random = chooseWeapon(false, false)
                                "any martial weapon" -> random = chooseWeapon(true, true)
                                "any martial melee weapon" -> random = chooseWeapon(true, false)
                            }
                        }
                        this.weapons.add(rulebook.weapons[stringListWeapons.indexOf(random)])
                    }
                    "armor" -> {
                        this.armor = rulebook.armors[stringListArmors.indexOf(random)]
                    }
                    "other" -> {
                        this.equipment.add(random)
                    }
                }
            }
        }
        addStaticEquipment()
    }
    open fun addStaticEquipment() {
        //The Super-Class "Class" has not static Equipment
    }
    fun choiceABCD(optionsList: List<String>): String {
        var choice: String = ""
        var input: String
        var inputs = "abcd"
        println("Choose one of the following:")
        for ((i, element) in optionsList.withIndex()) {
            println(inputs[i] + ". " + element)
        }
        when (optionsList.size) {
            2 -> print("Type 'a' or 'b': ")
            3 -> print("Type 'a', 'b' or 'c': ")
            4 -> print("Type 'a', 'b', 'c' or 'd': ")
        }
        input = readln().lowercase()
        while (input !in inputs) {
            println("Input invalid.")
            when (optionsList.size) {
                2 -> print("Type 'a' or 'b': ")
                3 -> print("Type 'a', 'b' or 'c': ")
                4 -> print("Type 'a', 'b', 'c' or 'd': ")
            }
            input = readln().lowercase()
        }
        when (optionsList.size) {
            2 -> {
                when (input) {
                    "a" -> choice = optionsList[0]
                    "b" -> choice = optionsList[1]
                }
            }
            3 -> {
                when (input) {
                    "a" -> choice = optionsList[0]
                    "b" -> choice = optionsList[1]
                    "c" -> choice = optionsList[2]
                }
            }
            4 -> {
                when (input) {
                    "a" -> choice = optionsList[0]
                    "b" -> choice = optionsList[1]
                    "c" -> choice = optionsList[2]
                    "d" -> choice = optionsList[3]
                }
            }
        }
        return choice
    }
    fun chooseWeapon(isMartial: Boolean = false, isRanged: Boolean = false): String {
        var weaponChoice: String
        var stringListWeapon: MutableList<String> = mutableListOf()
        var listSimpleMeleeWeapons: MutableList<String> = mutableListOf()
        var listSimpleRangedWeapons: MutableList<String> = mutableListOf()
        var listMartialMeleeWeapons: MutableList<String> = mutableListOf()
        var listMartialRangedWeapons: MutableList<String> = mutableListOf()
        for (weapon in rulebook.weapons) {
            if (!weapon.isMartial && !weapon.isRanged) {
                listSimpleMeleeWeapons.add(weapon.name)
            }
            else if (!weapon.isMartial && weapon.isRanged) {
                listSimpleRangedWeapons.add(weapon.name)
            }
            else if (weapon.isMartial && !weapon.isRanged) {
                listMartialMeleeWeapons.add(weapon.name)
            }
            else if (weapon.isMartial && weapon.isRanged) {
                listMartialRangedWeapons.add(weapon.name)
            }
        }
        if (!isMartial) {
            stringListWeapon.addAll(listSimpleMeleeWeapons)
            if (isRanged) {
                stringListWeapon.addAll(listSimpleRangedWeapons)
            }
        }
        else {
            stringListWeapon.addAll(listMartialMeleeWeapons)
            if (isRanged) {
                stringListWeapon.addAll(listMartialRangedWeapons)
            }
        }
        if (!isRandom) {
            var inputs: List<String> = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
            println("Choose one of the following weapons:")
            for (weapon in stringListWeapon) {
                println(inputs[stringListWeapon.indexOf(weapon)] + ". " + weapon)
            }
            print("Type 'a' to '${inputs[stringListWeapon.size-1]}': ")
            var choice = readln().lowercase()
            while (choice !in inputs && inputs.indexOf(choice) >= stringListWeapon.size) {
                println("Input was invalid.")
                print("Type 'a' to '${inputs[stringListWeapon.size-1]}': ")
                choice = readln().lowercase()
            }
            weaponChoice = stringListWeapon[inputs.indexOf(choice)]
        }
        else {
            weaponChoice = stringListWeapon.random()
        }
        return weaponChoice
    }
    fun chooseSubClass() {
        var subclasses: MutableList<String> = mutableListOf()
        subclasses.addAll(rulebook.subClasses[name]!!)
        if (!isRandom) {
            var inputs: List<String> = listOf("a","b","c","d","e","f","g","h","i")
            println("Please choose your subclass.")
            println("As a $name, you have the following options:")
            for (subclass in subclasses) {
                println(inputs[subclasses.indexOf(subclass)] + ". " + subclass)
            }
            print("Choose from the list above: ")
            var choice = readln().lowercase()
            while (choice !in inputs && inputs.indexOf(choice) >= subclasses.size) {
                println("Input was invalid.")
                print("Type 'a' to '${inputs[subclasses.size-1]}': ")
                choice = readln().lowercase()
            }
            this.subClass = subclasses[inputs.indexOf(choice)]
        }
        else {
            this.subClass = subclasses.random()
        }
    }

    open fun classActions() {

    }
}