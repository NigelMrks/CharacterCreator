import kotlin.system.exitProcess

val rulebook = Rulebook()
var pc: Character? = null
var isRandom: Boolean = false

fun main() {
    while (pc == null) {
        startUp()
        while (true) {
            mainMenu()
        }
    }
}
fun startUp() {
    println("Welcome to the Character Creator.")
    println("First we should make sure to create a character.")
    println("Type 'randomize' to fully randomize a character or 'create' to be guided to the creation process.")
    println("You can still decide to randomize any particular steps if you decide to choose 'create'.")
    print("Type: ")
    var input = readln().lowercase()
    while (input != "randomize" && input != "create") {
        println("Input was invalid. Please type 'randomize' or 'create'.")
        print("Type: ")
        input = readln().lowercase()
    }
    isRandom = input == "randomize"
    pc = Character(isRandom)
    println("Character Creation complete. Moving to Main Menu...")
}
fun mainMenu() {
    var input: String? = null
    val optionList: List<String> = listOf("show", "change", "delete", "start", "close")
    do {
        if (input !in optionList && input != null)
        println("---Character Creator Main Menu---")
        println("Current Character: " + pc!!.name)
        println("---Options---")
        println("1. Show Character Description (type: 'show')")
//        println("2. Change Character Detail (type: 'change')")
        println("2. Delete ${pc!!.name} and create new Character (type: 'delete')")
//        println("4. Start Game (type: 'start')")
        println("3. Close Character Creator (type: 'close')")
        println("--------------")
        println("What would you like to do?")
        print("Type: ")
        input = readln().lowercase()
    }
    while (input !in optionList)
    when (input) {
        "show" -> {
            showCharacterDescription()
        }
//        "change" -> {
//            changeCharacterDetail()
//        }
        "delete" -> {
            deleteCharacter()
        }
//        "start" -> {
//            startGame()
//        }
        "close" -> {
            println("Thank you for using the Character Creator.")
            println("Have a nice day!")
            exitProcess(0)
        }
    }
}

fun showCharacterDescription() {
    println("---Show Character Description---")
    println("Name: " + pc!!.name)
    if (pc!!.characterRace!!.hasSubrace) {
        println("Race: " + pc!!.characterRace!!.subrace + " " + pc!!.characterRace!!.name)
    }
    else {
        println("Race: " + pc!!.characterRace!!.name)
    }
    println("Class: " + pc!!.characterClass!!.name + " - " + pc!!.characterClass!!.subClass)
    println("Background: " + pc!!.background!!.name)
    println("Level: " + pc!!.level)
    println("HP: " + pc!!.hp + " (1D" + pc!!.characterClass!!.hitDice + ")")
    println("AC: " + pc!!.ac + " (${pc!!.characterClass!!.armor.name})")
    print("Strength: " + pc!!.strength)
    if (pc!!.getMod(pc!!.strength) >= 0) println(" (+" + pc!!.getMod(pc!!.strength) + ")")
    else println(" (" + pc!!.getMod(pc!!.strength) + ")")
    print("Dexterity: " + pc!!.dexterity)
    if (pc!!.getMod(pc!!.dexterity) >= 0) println(" (+" + pc!!.getMod(pc!!.dexterity) + ")")
    else println(" (" + pc!!.getMod(pc!!.dexterity) + ")")
    print("Constitution: " + pc!!.constitution)
    if (pc!!.getMod(pc!!.constitution) >= 0) println(" (+" + pc!!.getMod(pc!!.constitution) + ")")
    else println(" (" + pc!!.getMod(pc!!.constitution) + ")")
    print("Intelligence: " + pc!!.intelligence)
    if (pc!!.getMod(pc!!.intelligence) >= 0) println(" (+" + pc!!.getMod(pc!!.intelligence) + ")")
    else println(" (" + pc!!.getMod(pc!!.intelligence) + ")")
    print("Wisdom: " + pc!!.wisdom)
    if (pc!!.getMod(pc!!.wisdom) >= 0) println(" (+" + pc!!.getMod(pc!!.wisdom) + ")")
    else println(" (" + pc!!.getMod(pc!!.wisdom) + ")")
    print("Charisma: " + pc!!.charisma)
    if (pc!!.getMod(pc!!.charisma) >= 0) println(" (+" + pc!!.getMod(pc!!.charisma) + ")")
    else println(" (" + pc!!.getMod(pc!!.charisma) + ")")
    println("---Inventory---")
    var weaponList: MutableList<String> = mutableListOf()
    for (weapon in pc!!.characterClass!!.weapons) if(weapon.name != "Unarmed Strike") weaponList.add(weapon.name)
    println("Weapons: $weaponList")
    println("Other Equipment: " + pc!!.characterClass!!.equipment)
    println("---Returning to Main Menu---")
}
fun changeCharacterDetail() {
    println("---Change Character---")
    println("This function is not available yet.")
    println("---Returning to Main Menu---")
}
fun deleteCharacter() {
    var confirm: String
    println("This will delete ${pc!!.name}. Are you sure?")
    print("Confirm? (yes/no): ")
    confirm = readln().lowercase()
    while (confirm != "yes" && confirm != "no") {
        println("Input was invalid. Type 'yes' or 'no' to confirm.")
        print("Confirm? (yes/no): ")
        confirm = readln().lowercase()
    }
    if (confirm == "yes") {
        println("Deleting ${pc!!.name}...")
        println("---Creating New Character---")
        println("Type 'randomize' to fully randomize a character or 'create' to be guided to the creation process.")
        println("You can still decide to randomize any particular steps if you decide to choose 'create'.")
        print("Type: ")
        var input = readln().lowercase()
        while (input != "randomize" && input != "create") {
            println("Input was invalid. Please type 'randomize' or 'create'.")
            print("Type: ")
            input = readln().lowercase()
        }
        isRandom = input == "randomize"
        pc = Character(isRandom)
    }
    println("---Returning to Main Menu---")
}
fun startGame() {
    println("---Combat Game---")
    println("This function is not available yet.")
    println("---Returning to Main Menu---")
}

