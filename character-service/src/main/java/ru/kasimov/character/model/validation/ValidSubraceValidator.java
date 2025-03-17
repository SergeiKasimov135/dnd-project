package ru.kasimov.character.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;
import ru.kasimov.character.model.dto.PlayableCharacterDto;

public class ValidSubraceValidator implements ConstraintValidator<ValidSubrace, PlayableCharacterDto> {
    @Override
    public boolean isValid(PlayableCharacterDto playableCharacterDto, ConstraintValidatorContext constraintValidatorContext) {
        if (playableCharacterDto.subrace() == null) {
            return true;
        }

        return playableCharacterDto.subrace().getSpecies().name().equals(playableCharacterDto.specie().name());
    }
}
