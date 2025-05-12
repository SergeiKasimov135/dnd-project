package ru.kasimov.character.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kasimov.character.model.PlayableCharacter;

@Repository
public interface PlayableCharacterRepository extends JpaRepository<PlayableCharacter, Long> {

    Iterable<PlayableCharacter> findAllByNameLikeIgnoreCase(String nameFilter);

}