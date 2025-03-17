package ru.kasimov.character.model.dto;

import ru.kasimov.character.model.enums.*;
import ru.kasimov.character.model.validation.ValidBackgroundAbilities;
import ru.kasimov.character.model.validation.ValidSubrace;

import java.util.List;

@ValidSubrace
@ValidBackgroundAbilities
public record PlayableCharacterDto(
        String name,

        Species specie,

        Subrace subrace,

        CharacterClass characterClass,

        Background background,

        List<AbilityScoreDto> abilities
) {

    public record AbilityScoreDto(

            Ability ability,

            Integer baseScore,

            Integer backgroundModifier

    ) {}

}
