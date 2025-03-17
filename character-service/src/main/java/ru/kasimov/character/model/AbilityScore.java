package ru.kasimov.character.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kasimov.character.model.enums.Ability;

@Entity
@Table(name = "ability_score")
@Getter
@Setter
@NoArgsConstructor
public class AbilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ability ability;

    @NotNull
    @Column(nullable = false)
    private Integer baseScore;

    @NotNull
    @Max(3)
    @Column(nullable = false)
    private Integer backgroundModifier;

    @NotNull
    @Column(nullable = false)
    private Integer total;

    @NotNull
    @Column(nullable = false)
    private Integer abilityModifier;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private PlayableCharacter character;

    @Builder
    public AbilityScore(Ability ability, Integer baseScore,
                        Integer backgroundModifier, PlayableCharacter character) {
        this.ability = ability;
        this.baseScore = baseScore;
        this.backgroundModifier = backgroundModifier;
        this.total = this.baseScore + this.backgroundModifier;
        this.abilityModifier = (this.total - 10) / 2;
        this.character = character;
    }

}
