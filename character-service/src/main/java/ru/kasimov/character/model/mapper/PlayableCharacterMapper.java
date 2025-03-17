package ru.kasimov.character.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kasimov.character.model.AbilityScore;
import ru.kasimov.character.model.PlayableCharacter;
import ru.kasimov.character.model.dto.PlayableCharacterDto;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PlayableCharacterMapper {

    PlayableCharacterMapper INSTANCE = Mappers.getMapper(PlayableCharacterMapper.class);

    @Mapping(target = "abilities", ignore = true)
    PlayableCharacter toEntity(PlayableCharacterDto playableCharacterDto);

    PlayableCharacterDto toDto(PlayableCharacter playableCharacter);

    default List<AbilityScore> mapAbilities(List<PlayableCharacterDto.AbilityScoreDto> abilityDtos,
                                            PlayableCharacter character) {
        if (abilityDtos == null || abilityDtos.isEmpty()) {
            abilityDtos = new ArrayList<>();
        }

        return abilityDtos.stream()
                .map(dto -> AbilityScore.builder()
                        .ability(dto.ability())
                        .baseScore(dto.baseScore() != null ? dto.baseScore() : 8)
                        .backgroundModifier(dto.backgroundModifier() != null ? dto.backgroundModifier() : 0)
                        .character(character)
                        .build())
                .toList();

    }

}
