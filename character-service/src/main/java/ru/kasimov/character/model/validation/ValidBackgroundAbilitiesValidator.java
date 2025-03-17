package ru.kasimov.character.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.kasimov.character.model.dto.PlayableCharacterDto;
import ru.kasimov.character.model.enums.Ability;

import java.util.Arrays;
import java.util.List;

public class ValidBackgroundAbilitiesValidator implements ConstraintValidator<ValidBackgroundAbilities, PlayableCharacterDto> {

    @Override
    public boolean isValid(PlayableCharacterDto playableCharacterDto, ConstraintValidatorContext constraintValidatorContext) {
        if (playableCharacterDto.abilities() == null || playableCharacterDto.abilities().isEmpty() || playableCharacterDto.background() == null) {
            return true;
        }

        List<Ability> allowedAbilities = Arrays.asList(playableCharacterDto.background().getAbilities());

        for (PlayableCharacterDto.AbilityScoreDto abilityDto : playableCharacterDto.abilities()) {
            Integer backgroundModifier = abilityDto.backgroundModifier();

            if (backgroundModifier != null && backgroundModifier > 0 && !allowedAbilities.contains(abilityDto.ability())) {
                return false;
            }
        }

        return true;
    }

}
