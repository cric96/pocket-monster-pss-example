package it.unibo.core.monster;

import java.util.List;

/**
 * Builder class for creating Monster objects.
 */
public class MonsterBuilder {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private Type type;
    private List<Move> moves;

    /**
     * Constructs a new MonsterBuilder with default values.
     */
    public MonsterBuilder() {
        this.name = "";
        this.hp = 0;
        this.attack = 0;
        this.defense = 0;
        this.type = null;
        this.moves = List.of();
    }

    /**
     * Sets the name of the monster.
     *
     * @param name the name of the monster
     * @return the current instance of MonsterBuilder
     */
    public MonsterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the HP (health points) of the monster.
     *
     * @param hp the HP of the monster
     * @return the current instance of MonsterBuilder
     */
    public MonsterBuilder setHp(int hp) {
        this.hp = hp;
        return this;
    }

    /**
     * Sets the attack value of the monster.
     *
     * @param attack the attack value of the monster
     * @return the current instance of MonsterBuilder
     */
    public MonsterBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    /**
     * Sets the defense value of the monster.
     *
     * @param defense the defense value of the monster
     * @return the current instance of MonsterBuilder
     */
    public MonsterBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    /**
     * Sets the type of the monster.
     *
     * @param type the type of the monster
     * @return the current instance of MonsterBuilder
     */
    public MonsterBuilder setType(Type type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the moves of the monster.
     *
     * @param first the first move
     * @param second the second move
     * @param third the third move
     * @param fourth the fourth move
     * @return the current instance of MonsterBuilder
     */
    public MonsterBuilder setMoves(Move first, Move second, Move third, Move fourth) {
        this.moves = List.of(first, second, third, fourth);
        return this;
    }

    /**
     * Builds and returns a Monster object.
     *
     * @return a new Monster object
     * @throws IllegalStateException if any of the required fields are not set correctly
     */
    public Monster build() {
        checkRequirements();
        return new MonsterImpl(this.name, this.moves, new MonsterStatsImpl(this.hp, this.attack, this.defense, this.type));
    }

    /**
     * Checks if all required fields are set correctly.
     *
     * @throws IllegalStateException if any of the required fields are not set correctly
     */
    private void checkRequirements() {
        if (this.name == null) {
            throw new IllegalStateException("Name cannot be null");
        }
        if (this.hp <= 0) {
            throw new IllegalStateException("HP must be greater than 0");
        }
        if (this.attack <= 0) {
            throw new IllegalStateException("Attack must be greater than 0");
        }
        if (this.defense <= 0) {
            throw new IllegalStateException("Defense must be greater than 0");
        }
        if (this.type == null) {
            throw new IllegalStateException("Type cannot be null");
        }
        if (this.moves.size() > 4) {
            throw new IllegalStateException("Moves must be less than 4");
        }
    }
}