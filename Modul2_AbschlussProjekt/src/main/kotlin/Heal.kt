class Heal(
    name: String,
    damage: Int,
    numberOfDie: Int = 1,
    abilityBonus: Int = 0,
    damageType: String,
    getsDamageBonus: Boolean = false,
    hasAdvantage: Boolean = false,
    hasDisadvantage: Boolean = false,
    totalUses: Int
): Attack(name, damage, numberOfDie,damageType, abilityBonus,getsDamageBonus, hasAdvantage, hasDisadvantage, totalUses) {

}
