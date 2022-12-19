package races
import Race
import SpecialAbility

class Dragonborn(isRandom: Boolean) : Race(isRandom) {

    override fun setProperties() {
        this.name = "Dragonborn"
        this.hasSubrace = true
        this.str += 2
        this.cha += 1
        this.subraces = listOf(
            "Black", "Blue", "Brass", "Bronze", "Copper",
            "Gold", "Green", "Red", "Silver", "White"
        )
    }
    override fun addRacials() {
        var baseRacials: MutableList<String> = mutableListOf(
            "Draconic Ancestry"
        )
        if (!isRandom) println("Racial Abilities: $baseRacials")
        racials.addAll(baseRacials)
    }

    override fun addSubRacials(input: String) {
        var subRacials: MutableList<String> = mutableListOf()
        var breathWeaponType: String = ""
        when(input) {
            "Black" -> {
                subRacials.add("Breath Weapon - Acid, 5 by 30 ft. line (Dex. save)")
                subRacials.add("Damage Resistance - Acid")
                subrace = "Black"
                breathWeaponType = "acid"
            }
            "Blue" -> {
                subRacials.add("Breath Weapon - Lightning, 5 by 30 ft. line (Dex. save)")
                subRacials.add("Damage Resistance - Lightning")
                subrace = "Blue"
                breathWeaponType = "lightning"
            }
            "Brass" -> {
                subRacials.add("Breath Weapon - Fire, 5 by 30 ft. line (Dex. save)")
                subRacials.add("Damage Resistance - Fire")
                subrace = "Brass"
                breathWeaponType = "fire"
            }
            "Bronze" -> {
                subRacials.add("Breath Weapon - Lightning, 5 by 30 ft. line (Dex. save)")
                subRacials.add("Damage Resistance - Lightning")
                subrace = "Bronze"
                breathWeaponType = "lightning"
            }
            "Gold" -> {
                subRacials.add("Breath Weapon - Fire, 15 ft. cone (Dex. save)")
                subRacials.add("Damage Resistance - Fire")
                subrace = "Gold"
                breathWeaponType = "fire"
            }
            "Green" -> {
                subRacials.add("Breath Weapon - Poison, 15 ft. cone (Con. save)")
                subRacials.add("Damage Resistance - Poison")
                subrace = "Green"
                breathWeaponType = "poison"
            }
            "Red" -> {
                subRacials.add("Breath Weapon - Fire, 15 ft. cone (Dex. save)")
                subRacials.add("Damage Resistance - Fire")
                subrace = "Red"
                breathWeaponType = "fire"
            }
            "Silver" -> {
                subRacials.add("Breath Weapon - Cold, 15 ft. cone (Con. save)")
                subRacials.add("Damage Resistance - Cold")
                subrace = "Silver"
                breathWeaponType = "cold"
            }
            "White" -> {
                subRacials.add("Breath Weapon - Cold, 15 ft. cone (Con. save)")
                subRacials.add("Damage Resistance - Cold")
                subrace = "White"
                breathWeaponType = "cold"
            }
        }
        specialAbilities.add(SpecialAbility("Breath Weapon", 6,2,0,breathWeaponType, totalUses = 1))
        if (!isRandom) if (!isRandom) println("Subracial Abilities: $subRacials")
        racials.addAll(subRacials)
    }
}