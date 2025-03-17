package ru.kasimov.character.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Background {

    ACOLYTE(new Ability[] {Ability.INTELLIGENCE, Ability.WISDOM, Ability.CHARISMA}),
    ARTISAN(new Ability[] {Ability.STRENGTH, Ability.DEXTERITY, Ability.INTELLIGENCE}),
    CHARLATAN(new Ability[] {Ability.DEXTERITY, Ability.CONSTITUTION, Ability.CHARISMA}),
    CRIMINAL(new Ability[] {Ability.DEXTERITY, Ability.CONSTITUTION, Ability.INTELLIGENCE}),
    ENTERTAINER(new Ability[] {Ability.STRENGTH, Ability.DEXTERITY, Ability.CHARISMA}),
    FARMER(new Ability[] {Ability.STRENGTH, Ability.CONSTITUTION, Ability.WISDOM}),
    GUARD(new Ability[] {Ability.STRENGTH, Ability.INTELLIGENCE, Ability.WISDOM}),
    GUIDE(new Ability[] {Ability.DEXTERITY, Ability.CONSTITUTION, Ability.WISDOM}),
    HERMIT(new Ability[] {Ability.CONSTITUTION, Ability.WISDOM, Ability.CHARISMA}),
    MERCHANT(new Ability[] {Ability.CONSTITUTION, Ability.INTELLIGENCE, Ability.CHARISMA}),
    NOBLE(new Ability[] {Ability.STRENGTH, Ability.INTELLIGENCE, Ability.CHARISMA}),
    SAGE(new Ability[] {Ability.CONSTITUTION, Ability.INTELLIGENCE, Ability.WISDOM}),
    SAILOR(new Ability[] {Ability.STRENGTH, Ability.DEXTERITY, Ability.WISDOM}),
    SCRIBE(new Ability[] {Ability.DEXTERITY, Ability.INTELLIGENCE, Ability.WISDOM}),
    SOLDIER(new Ability[] {Ability.STRENGTH, Ability.DEXTERITY, Ability.CONSTITUTION}),
    WAYFARER(new Ability[] {Ability.DEXTERITY, Ability.WISDOM, Ability.CHARISMA});

    private final Ability[] abilities;
    public static final int BACKGROUND_POINTS = 3;

}
