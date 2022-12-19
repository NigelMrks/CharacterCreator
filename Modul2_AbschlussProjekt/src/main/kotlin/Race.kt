import java.util.*

open class Race(var isRandom: Boolean = false) {
    var name: String = "placeholder_race_name"
    var speed: Int = 30
    var str: Int = 0
    var dex: Int = 0
    var con: Int = 0
    var int: Int = 0
    var wis: Int = 0
    var cha: Int = 0
    var bonusHP: Int = 0
    var attributes: List<String> = listOf()
    var racialSkills: MutableList<String> = mutableListOf()
    var racials: MutableList<String> = mutableListOf()
    var hasSubrace: Boolean = false
    var subraces: List<String> = listOf()
    var subrace: String = "placeholder_subrace"
    var specialAbilities: MutableList<Attack> = mutableListOf()

    init {
        this.setProperties()
        this.addRacials()
        if(hasSubrace) {
            this.chooseSubrace()
        }
        this.attributes = listOf("+$str Strength", "+$dex Dexterity", "+$con Constitution", "+$int Intelligence", "+$wis Wisdom", "+$cha Charisma")
    }
    open fun setProperties() {
        // No Properties to set
    }

    open fun addRacials() {
        // This race has no racial traits
        println("Racial Abilities: None")
    }
    fun chooseSubrace() {
        if (!isRandom) {
            if (this.name[0].lowercase() in "aeiou") println("As an ${this.name} you have the following subrace options: ")
            else println("As a ${this.name} you have the following subrace options: ")
            println(this.subraces)
            println("Please choose a subrace from the list above:")
            var input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            while(!this.subraces.contains(input)) {
                println("Your input was invalid. Please choose from the following list:")
                println(this.subraces)
                input = readln()
            }
            addSubRacials(input)
        }
        else {
            var random = this.subraces.random()
            addSubRacials(random)
        }
    }
    open fun addSubRacials(input: String) {
        // This race has no Subraces
    }
}