package ru.kasimov.character.service;

import lombok.RequiredArgsConstructor;
import org.mapstruct.ap.internal.model.assignment.ExistingInstanceSetterWrapperForCollectionsAndMaps;
import org.springframework.stereotype.Service;
import ru.kasimov.character.model.AbilityScore;
import ru.kasimov.character.model.PlayableCharacter;
import ru.kasimov.character.model.dto.PlayableCharacterDto;
import ru.kasimov.character.model.mapper.PlayableCharacterMapper;
import ru.kasimov.character.repository.PlayableCharacterRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultCharacterService implements PlayableCharacterService {

    private final PlayableCharacterRepository characterRepository;

    @Override
    public Iterable<PlayableCharacter> findAllCharacters(String nameFilter) {
        if (nameFilter == null || !nameFilter.isBlank()) {
            return this.characterRepository.findAllByNameLikeIgnoreCase("%" + nameFilter + "%");
        } else {
            return this.characterRepository.findAll();
        }
    }

    @Override
    public PlayableCharacter createCharacter(PlayableCharacterDto playableCharacterDto) {
        PlayableCharacter playableCharacter = PlayableCharacterMapper.INSTANCE.toEntity(playableCharacterDto);

        List<AbilityScore> abilities = PlayableCharacterMapper.INSTANCE.mapAbilities(
                playableCharacterDto.abilities(), playableCharacter
        );
        playableCharacter.setAbilities(abilities);

        return this.characterRepository.save(playableCharacter);
    }

    @Override
    public Optional<PlayableCharacter> findCharacterById(Long characterId) {
        return this.characterRepository.findById(characterId);
    }

    @Override
    public PlayableCharacter editCharacter(Long characterId, PlayableCharacterDto playableCharacterDto) {
        return this.characterRepository.findById(characterId)
                .map(existedCharacter -> {
                    existedCharacter.setName(playableCharacterDto.name());
                    existedCharacter.setSpecie(playableCharacterDto.specie());
                    existedCharacter.setSubrace(playableCharacterDto.subrace());
                    existedCharacter.setCharacterClass(playableCharacterDto.characterClass());
                    existedCharacter.setBackground(playableCharacterDto.background());

                    List<AbilityScore> abilities = PlayableCharacterMapper.INSTANCE.mapAbilities(
                            playableCharacterDto.abilities(), existedCharacter
                    );
                    existedCharacter.setAbilities(abilities);

                    return this.characterRepository.save(existedCharacter);
                })
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteCharacterById(Long characterId) {
        this.characterRepository.deleteById(characterId);
    }

}
