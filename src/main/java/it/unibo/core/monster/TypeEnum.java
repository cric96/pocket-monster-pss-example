package it.unibo.core.monster;

import java.util.Set;

public enum TypeEnum implements Type {
    NORMAL("Normal", Set.of("Fighting"), Set.of()),
    FIGHTING("Fighting", Set.of("Flying", "Psychic", "Fairy"), Set.of("Rock", "Bug", "Dark")),
    FLYING("Flying", Set.of("Rock", "Electric", "Ice"), Set.of("Fighting", "Bug", "Grass")),
    POISON("Poison", Set.of("Ground", "Psychic"), Set.of("Fighting", "Poison", "Bug", "Grass", "Fairy")),
    GROUND("Ground", Set.of("Water", "Grass", "Ice"), Set.of("Poison", "Rock")),
    ROCK("Rock", Set.of("Fighting", "Ground", "Steel", "Water", "Grass"), Set.of("Normal", "Flying", "Poison", "Fire")),
    BUG("Bug", Set.of("Flying", "Rock", "Fire"), Set.of("Fighting", "Ground", "Grass")),
    GHOST("Ghost", Set.of("Ghost", "Dark"), Set.of("Normal", "Fighting")),
    STEEL("Steel", Set.of("Fighting", "Ground", "Fire"), Set.of("Normal", "Flying", "Rock", "Bug", "Steel", "Grass", "Psychic", "Ice", "Dragon", "Fairy")),
    FIRE("Fire", Set.of("Ground", "Rock", "Water"), Set.of("Bug", "Steel", "Fire", "Grass", "Ice", "Fairy")),
    WATER("Water", Set.of("Grass", "Electric"), Set.of("Steel", "Fire", "Water")),
    GRASS("Grass", Set.of("Flying", "Poison", "Bug", "Fire", "Ice"), Set.of("Ground", "Water", "Grass", "Electric")),
    ELECTRIC("Electric", Set.of("Ground"), Set.of("Flying", "Steel", "Electric")),
    PSYCHIC("Psychic", Set.of("Bug", "Ghost", "Dark"), Set.of("Fighting", "Psychic")),
    ICE("Ice", Set.of("Fighting", "Rock", "Steel", "Fire"), Set.of("Ice")),
    DRAGON("Dragon", Set.of("Ice", "Dragon", "Fairy"), Set.of("Steel")),
    DARK("Dark", Set.of("Fighting", "Bug", "Fairy"), Set.of("Ghost", "Dark")),
    FAIRY("Fairy", Set.of("Poison", "Steel"), Set.of("Fighting", "Bug", "Dark"));

    private final String name;
    private final Set<String> weakTo;
    private final Set<String> resistantTo;

    private TypeEnum(String name, Set<String> weakTo, Set<String> resistantTo) {
        this.name = name;
        this.weakTo = weakTo;
        this.resistantTo = resistantTo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isWeakTo(Type type) {
        return weakTo.contains(type.getName());
    }

    @Override
    public boolean isResistantTo(Type type) {
        return resistantTo.contains(type.getName());
    }
}
