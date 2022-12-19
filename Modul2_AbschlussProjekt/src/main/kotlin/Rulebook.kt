class Rulebook {
    var skills: List<Skill> = listOf(
        Skill("Acrobatics", "Dexterity"),           //0
        Skill("Animal Handling", "Wisdom"),         //1
        Skill("Arcana", "Intelligence"),            //2
        Skill("Athletics", "Strength"),             //3
        Skill("Deception", "Charisma"),             //4
        Skill("History", "Intelligence"),           //5
        Skill("Insight", "Wisdom"),                 //6
        Skill("Intimidation", "Charisma"),          //7
        Skill("Investigation", "Intelligence"),     //8
        Skill("Medicine", "Wisdom"),                //9
        Skill("Nature", "Intelligence"),            //10
        Skill("Perception", "Wisdom"),              //11
        Skill("Performance", "Charisma"),           //12
        Skill("Persuasion", "Charisma"),            //13
        Skill("Religion", "Intelligence"),          //14
        Skill("Sleight of Hand", "Dexterity"),      //15
        Skill("Stealth", "Dexterity"),              //16
        Skill("Survival", "Wisdom")                 //17
    )
    var backgrounds: List<Background> = listOf(
        Background("Acolyte", listOf(skills[6], skills[14]), mapOf("gold" to 15)),
        Background("Charlatan", listOf(skills[4], skills[15]), mapOf("gold" to 15)),
        Background("Criminal", listOf(skills[4], skills[16]), mapOf("gold" to 15)),
        Background("Entertainer", listOf(skills[0], skills[12]), mapOf("gold" to 15)),
        Background("Folk Hero", listOf(skills[1], skills[17]), mapOf("gold" to 10)),
        Background("Gladiator", listOf(skills[0], skills[12]), mapOf("gold" to 15)),
        Background("Guild Artisan", listOf(skills[6], skills[13]), mapOf("gold" to 15)),
        Background("Hermit", listOf(skills[9], skills[14]), mapOf("gold" to 5)),
        Background("Knight", listOf(skills[5], skills[13]), mapOf("gold" to 25)),
        Background("Noble", listOf(skills[5], skills[13]), mapOf("gold" to 25)),
        Background("Outlander", listOf(skills[3], skills[17]), mapOf("gold" to 10)),
        Background("Pirate", listOf(skills[3], skills[11]), mapOf("gold" to 5)),
        Background("Sage", listOf(skills[2], skills[5]), mapOf("gold" to 10)),
        Background("Sailor", listOf(skills[3], skills[11]), mapOf("gold" to 5)),
        Background("Soldier", listOf(skills[3], skills[7]), mapOf("gold" to 10)),
        Background("Urchin", listOf(skills[15], skills[16]), mapOf("gold" to 10))
    )
    var weapons: List<Weapon> = listOf(
        Weapon("Club", false, false, 4,"bludgeoning", "5 ft."),
        Weapon("Dagger", false, false, 4,"piercing", "5 ft. (20/60 thrown)", isFinesse = true),
        Weapon("Greatclub", false, false, 8,"bludgeoning", "5 ft. (20/60 thrown)", isTwoHanded = true),
        Weapon("Handaxe", false, false, 6,"slashing", "5 ft."),
        Weapon("Javelin", false, false, 6,"piercing", "5 ft. (30/120 thrown)"),
        Weapon("Light Hammer", false, false, 4,"bludgeoning", "5 ft. (20/60 thrown)"),
        Weapon("Mace", false, false, 6,"bludgeoning", "5 ft."),
        Weapon("Quarterstaff", false, false, 6,"bludgeoning", "5 ft.", true),
        Weapon("Sickle", false, false, 4,"slashing", "5 ft."),
        Weapon("Spear", false, false, 6,"piercing", "5 ft. (20/60 thrown)", true),
        Weapon("Crossbow, light", false, true, 8,"piercing", "80/320 ft.", isTwoHanded = true),
        Weapon("Dart", false, true, 4,"piercing", "20/60 ft."),
        Weapon("Shortbow", false, true, 6,"piercing", "80/320 ft.", isTwoHanded = true),
        Weapon("Sling", false, true, 4,"bludgeoning", "30/120 ft."),
        Weapon("Battleaxe", true, false, 8,"slashing", "5 ft.", true),
        Weapon("Flail", true, false, 8,"bludgeoning", "5 ft."),
        Weapon("Glaive", true, false, 10,"slashing", "10 ft.", isTwoHanded = true),
        Weapon("Greataxe", true, false, 12,"slashing", "5 ft.", isTwoHanded = true),
        Weapon("Greatsword", true, false, 6,"slashing", "5 ft.", isTwoHanded = true),
        Weapon("Halberd", true, false, 10,"slashing", "10 ft.", isTwoHanded = true),
        Weapon("Lance", true, false, 12,"piercing", "10 ft.", isTwoHanded = true),
        Weapon("Longsword", true, false, 8,"slashing", "5 ft.", true),
        Weapon("Maul", true, false, 6,"bludgeoning", "5 ft.", isTwoHanded = true),
        Weapon("Morningstar", true, false, 8,"piercing", "5 ft."),
        Weapon("Pike", true, false, 10,"piercing", "10 ft.", isTwoHanded = true),
        Weapon("Rapier", true, false, 8,"piercing", "5 ft.", isFinesse = true),
        Weapon("Scimitar", true, false, 6,"slashing", "5 ft.", isFinesse = true),
        Weapon("Shortsword", true, false, 6,"piercing", "5 ft.", isFinesse = true),
        Weapon("Trident", true, false, 6,"piercing", "5 ft.", true),
        Weapon("War Pick", true, false, 8,"piercing", "5 ft."),
        Weapon("Warhammer", true, false, 8,"bludgeoning", "5 ft.", true),
        Weapon("Whip", true, false, 4,"slashing", "10 ft.", isFinesse = true),
        Weapon("Blowgun", true, true, 1,"piercing", "25/100 ft."),
        Weapon("Crossbow, hand", true, true, 6,"piercing", "30/120 ft."),
        Weapon("Crossbow, heavy", true, true, 10,"piercing", "100/400 ft.", isTwoHanded = true),
        Weapon("Longbow", true, true, 8,"piercing", "150/600 ft.", isTwoHanded = true),
        Weapon("Net", true, true, 0,"-", "5/15 ft."),
    )
    var armors: List<Armor> = listOf(
        Armor("Padded", "Light", 11),
        Armor("Leather", "Light", 11),
        Armor("Studded leather", "Light", 12),
        Armor("Hide", "Medium", 12),
        Armor("Chain shirt", "Medium", 13),
        Armor("Scale mail", "Medium", 14),
        Armor("Breastplate", "Medium", 14),
        Armor("Half plate", "Medium", 15),
        Armor("Ring mail", "Heavy", 14),
        Armor("Chain mail", "Heavy", 16),
        Armor("Splint", "Heavy", 17),
        Armor("Plate", "Heavy", 18),
    )
    var races: List<String> = listOf(
        "Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling"
    )
    var classes: List<String> = listOf(
        "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
        "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"
    )
    var subClasses: Map<String, List<String>> = mapOf(
        classes[0] to listOf(
            "Path of the Ancestral Guardian", "Path of the Berserker",
            "Path of the Storm Herald", "Path of the Totem Warrior",
            "Path of the Zealot"
        ),
        classes[1] to listOf(
            "College of Glamour", "College of Lore",
            "College of Swords", "College of Valor",
            "College of Whispers"
        ),
        classes[2] to listOf(
            "Forge Domain", "Grave Domain",
            "Knowledge Domain", "Life Domain",
            "Light Domain", "Nature Domain",
            "Tempest Domain", "Trickery Domain",
            "War Domain"
        ),
        classes[3] to listOf(
            "Circle of Dreams", "Circle of the Land",
            "Circle of the Moon", "Circle of the Shepherd",
        ),
        classes[4] to listOf(
            "Arcane Archer", "Battle Master",
            "Cavalier", "Champion",
            "Eldritch Knight", "Samurai"
        ),
        classes[5] to listOf(
            "Way of the Drunken Master", "Way of the Four Elements",
            "Way of the Kensei", "Way of the Open Hand",
            "Way of Shadow", "Way of the Sun Soul"
        ),
        classes[6] to listOf(
            "Oath of the Ancients", "Oath of Conquest",
            "Oath of Devotion", "Oath of Redemption",
            "Oath of Vengeance"
        ),
        classes[7] to listOf(
            "Beast Master Conclave", "Gloom Stalker Conclave",
            "Horizon Walker Conclave", "Hunter Conclave",
            "Monster Slayer Conclave"
        ),
        classes[8] to listOf(
            "Arcane Trickster", "Assassin",
            "Inquisitive", "Mastermind",
            "Scout", "Swashbuckler",
            "Thief"
        ),
        classes[9] to listOf(
            "Draconic Bloodline", "Divine Soul",
            "Shadow Magic", "Storm Sorcery",
            "Wild Magic"
        ),
        classes[10] to listOf(
            "Archfey", "Celestial",
            "Fiend", "Great Old One",
            "Hexblade",
        ),
        classes[11] to listOf(
            "School of Abjuration", "School of Conjuration",
            "School of Divination", "School of Enchantment",
            "School of Evocation", "School of Illusion",
            "School of Necromancy", "School of Transmutation",
            "School of War Magic"
        )
    )
}