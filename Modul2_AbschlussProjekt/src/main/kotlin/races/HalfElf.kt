package races
import Race
import java.util.*

class HalfElf(isRandom: Boolean) : Race(isRandom) {
    override fun setProperties() {
        this.name = "Half-Elf"
        this.cha += 2
    }
    override fun addRacials() {
        var baseRacials: MutableList<String> = mutableListOf(
            "Fey Ancestry",
            "Skill Versatility"
        )
        if (!isRandom) println("As a ${this.name} you get to choose 2 Ability Scores to increase by 1 other than Charisma.")
        var asiChoice: MutableList<String> = mutableListOf("str", "dex", "con", "int", "wis")
        for (i in 1..2) {
            if (!isRandom) println("Choose one of these: $asiChoice")
            var input = readln().lowercase()
            while(!asiChoice.contains(input)) {
                if (!isRandom) println("You have to choose one of the following: $asiChoice")
                input = readln().lowercase()
            }
            asiChoice.remove(input)
            when (input) {
                "str" -> this.str += 1
                "dex" -> this.dex += 1
                "con" -> this.con += 1
                "int" -> this.int += 1
                "wis" -> this.wis += 1
            }
        }
        if (!isRandom) println("As a ${this.name} you get Skill Versatility, allowing you to choose 2 of any Skill to be proficient in.")
        var skillVersatility: MutableList<String> = mutableListOf(
            "Acrobatics",  "Animal Handling", "Arcana", "Athletics",
            "Deception", "History", "Insight", "Intimidation",
            "Investigation", "Medicine", "Nature", "Perception",
            "Performance", "Persuasion", "Religion", "Sleight of Hand",
            "Stealth", "Survival"
        )
        for (i in 1..2) {
            if (!isRandom) println("Choose one of these: ")
            for(skill in skillVersatility) {
                if (!isRandom) println(skill)
            }
            var input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            while(!skillVersatility.contains(input)) {
                if (!isRandom) println("You have to choose one of the following:")
                for(skill in skillVersatility) {
                    if (!isRandom) println(skill)
                }
                input = readln().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
            skillVersatility.remove(input)
            racialSkills.add(input)
        }
        if (!isRandom) println("Racial Abilities: $baseRacials")
        racials.addAll(baseRacials)
    }
}