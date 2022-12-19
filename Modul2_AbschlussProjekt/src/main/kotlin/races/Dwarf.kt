package races
import Race
import java.lang.Exception

class Dwarf(isRandom: Boolean) : Race(isRandom) {

    override fun setProperties() {
        this.name = "Dwarf"
        this.hasSubrace = true
        this.con += 2
        this.speed = 25
        this.subraces = listOf(
            "Hill", "Mountain"
        )
    }
    override fun addRacials() {
        var baseRacials: MutableList<String> = mutableListOf(
            "Darkvision",
            "Dwarven Resilience",
            "Dwarven Combat Training",
            "Stonecunning"
        )
        var toolProficiency: List<String> = listOf("Smith's Tools", "Brewer's Supplies", "Mason's Tools")
        if (isRandom) {
            println("The ${this.name} Racial Ability, Tool Proficiency, lets you choose one of the the following proficiencies:")
            for (element in toolProficiency) {
                println("${toolProficiency.indexOf(element)+1}. $element")
            }
            println("Type in the number corresponding to cour choice:")
            var input: Int
            var inputIsValid: Boolean = false
            do {
                try {
                    input = readln().toInt()
                    if (!(1..toolProficiency.size).contains(input)) {
                        println("Please select a number between 1 and ${toolProficiency.size}.")
                        inputIsValid = false
                    }
                    else {
                        println("You have chosen: Tool Proficiency - " + toolProficiency[input-1])
                        baseRacials.add("Tool Proficiency - " + toolProficiency[input-1])
                        inputIsValid = true
                    }
                }
                catch (ex:Exception) {
                    println("Please select a number between 1 and ${toolProficiency.size}.")
                    inputIsValid = false
                }
            }
            while (!inputIsValid)
        }
        else baseRacials.add("Tool Proficiency - " + toolProficiency.random())
        if (!isRandom) println("Racial Abilities: $baseRacials")
        racials.addAll(baseRacials)
    }

    override fun addSubRacials(input: String) {
        var subRacials: MutableList<String> = mutableListOf()

        when(input) {
            "Hill" -> {
                wis += 1
                subRacials.add("Dwarven Toughness")
                this.bonusHP = 3
                subrace = "Hill"
            }
            "Mountain" -> {
                str += 2
                subRacials.add("Dwarven Armor Training")
                subrace = "Mountain"
            }
        }
        if (!isRandom) println("Subracial Abilities: $subRacials")
        racials.addAll(subRacials)
    }
}