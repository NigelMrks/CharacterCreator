class Weapon(
    var name: String,
    var isMartial: Boolean,
    var isRanged: Boolean,
    var damage: Int,
    var damageType: String,
    var range: String,
    var isVersatile: Boolean = false,
    var isFinesse: Boolean = false,
    var isTwoHanded: Boolean = false
    ) {
//        fun damage(damageBonus: Int): Int {
//            return (1..this.damageDie).random() * numberOfDie + damageBonus + magicDamageBonus
//        }
}