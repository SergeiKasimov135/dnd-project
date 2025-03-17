package ru.kasimov.character.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum Subrace {

    HIGH(Species.ELF),
    WOOD(Species.ELF),
    DARK(Species.ELF),

    FOREST(Species.GNOME),
    ROCK(Species.GNOME),

    CLOUD_GIANT(Species.GOLIATH),
    FIRE_GIANT(Species.GOLIATH),
    FROST_GIANT(Species.GOLIATH),
    HILL_GIANT(Species.GOLIATH),
    STONE_GIANT(Species.GOLIATH),
    STORM_GIANT(Species.GOLIATH),

    ABYSSAL(Species.TIEFLING),
    CHTHONIC(Species.TIEFLING),
    INFERNAL(Species.TIEFLING);

    private final Species species;

    public List<Subrace> getBySpecies(Species species) {
        return Arrays.stream(values())
                .filter(subrace -> subrace.species == species)
                .toList();
    }

}
