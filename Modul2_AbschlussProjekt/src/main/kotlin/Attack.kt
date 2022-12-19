open class Attack(
    var name: String,
    var damage: Int,
    var numberOfDie: Int = 1,
    var damageType: String,
    var abilityBonus: Int = 0,
    var getsDamageBonus: Boolean = false,
    var hasAdvantage: Boolean = false,
    var hasDisadvantage: Boolean = false,
    var totalUses: Int = 0
) {
    var timesUsed: Int = 0

    open fun checkForHit(
        ac: Int,
        user: String,
        hasAdvantage: Boolean = false,
        hasDisadvantage: Boolean = false
    ): Int {
        var isCritHit: Boolean = false
        var isCritFail: Boolean = false
        var damage: Int = 0
        var d20 = (1..20).random()
        if (hasAdvantage || this.hasAdvantage) {
            var advantage = (1..20).random()
            if (advantage > d20) d20 = advantage
        }
        if (hasDisadvantage || this.hasDisadvantage) {
            var disadvantage = (1..20).random()
            if (disadvantage < d20) d20 = disadvantage
        }
        if (d20 == 20) isCritHit = true
        if (d20 == 1) isCritFail = true
        d20 += 2
        d20 += this.abilityBonus
        if (d20 > ac && !isCritHit) {
            println("Attack with ${this.name} has hit!")
            damage = calcDamage()
        }
        else if (isCritHit) {
            println("Attack with ${this.name} has critically hit!")
            damage = calcDamage(true)
        }
        else if (d20 < ac && !isCritFail) {
            println("Attack with ${this.name} has missed!")
            damage = 0
        }
        else if (isCritFail) {
            println("Attack with ${this.name} has critically failed!")
            damage = 0
        }
        return damage
    }

    fun calcDamage(isCrit:Boolean = false): Int {
        var damage: Int = 0
        for (i in (1..this.numberOfDie)) {
            damage += (1..this.damage).random()
            if (isCrit) damage += (1..this.damage).random()
        }
        if (this.getsDamageBonus) damage += this.abilityBonus
        return damage
    }
}
