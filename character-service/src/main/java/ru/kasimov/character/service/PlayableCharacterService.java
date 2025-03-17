package ru.kasimov.character.service;

import ru.kasimov.character.model.PlayableCharacter;
import ru.kasimov.character.model.dto.PlayableCharacterDto;

import java.util.Optional;

public interface PlayableCharacterService {

    Iterable<PlayableCharacter> findAllCharacters(String nameFilter);

    PlayableCharacter createCharacter(PlayableCharacterDto playableCharacterDto);

    Optional<PlayableCharacter> findCharacterById(Long characterId);

    PlayableCharacter editCharacter(Long characterId, PlayableCharacterDto playableCharacterDto);

    void deleteCharacterById(Long characterId);

}
