package ru.kasimov.character.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kasimov.character.model.enums.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
@Getter
@Setter
@NoArgsConstructor
public class PlayableCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Species specie;

    @Enumerated(EnumType.STRING)
    private Subrace subrace;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CharacterClass characterClass;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Background background;

    @OneToMany(
            mappedBy = "character",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<AbilityScore> abilities = new ArrayList<>();

    @Builder
    public PlayableCharacter(String name, Species specie,
                             Subrace subrace, CharacterClass characterClass,
                             Background background, List<AbilityScore> abilities) {
        this.name = name;
        this.specie = specie;
        this.subrace = subrace;
        this.characterClass = characterClass;
        this.background = background;
        this.abilities = abilities;
    }

}
