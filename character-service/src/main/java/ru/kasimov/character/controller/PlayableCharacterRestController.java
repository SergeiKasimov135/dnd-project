package ru.kasimov.character.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kasimov.character.model.PlayableCharacter;
import ru.kasimov.character.model.dto.PlayableCharacterDto;
import ru.kasimov.character.service.PlayableCharacterService;

@RestController
@RequestMapping("/api/v1/characters")
@RequiredArgsConstructor
public class PlayableCharacterRestController {

    private final PlayableCharacterService characterService;

    @GetMapping
    public ResponseEntity<Iterable<PlayableCharacter>> findAllCharacters(
            @RequestParam(name = "name", required = false) String nameFilter) {
        return ResponseEntity.ok(this.characterService.findAllCharacters(nameFilter));
    }

    @PostMapping
    public ResponseEntity<PlayableCharacter> createCharacter(@RequestBody @Valid PlayableCharacterDto characterDto) {
        return ResponseEntity.ok(this.characterService.createCharacter(characterDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayableCharacter> findCharacterById(@PathVariable Long id) {
        return this.characterService.findCharacterById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlayableCharacter> editCharacter(@PathVariable Long id,
                                                               @RequestBody @Valid PlayableCharacterDto characterDto) {
        return ResponseEntity.ok(this.characterService.editCharacter(id, characterDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacterById(@PathVariable Long id) {
        this.characterService.deleteCharacterById(id);

        return ResponseEntity.noContent().build();
    }

}
