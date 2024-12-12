package it.unibo.core.monster;

import it.unibo.core.tool.AttachableTool;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class MonsterImpl implements Monster {
    private final String name;
    private final Stats stats;
    private int health;
    private int attack;
    private int defense;
    private final List<Move> moves;
    private Optional<AttachableTool> tool = Optional.empty();
    MonsterImpl(final String name, final List<Move> moves, final Stats stats) {
        this.name = name;
        this.stats = stats;
        this.health = stats.getHealthPoints();
        this.attack = stats.getBaseAttack();
        this.defense = stats.getDefensePoints();
        this.moves = moves;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Stats getStats() {
        return this.stats;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void updateHealth(int health) {
        if (health + this.health > this.stats.getHealthPoints()) {
            this.health = this.stats.getHealthPoints();
        } else {
            this.health += health;
        }
    }

    @Override
    public void updateAttack(int attack) {
        this.attack += attack;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public void updateDefense(int defense) {
        this.defense += defense;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    @Override
    public Optional<AttachableTool> getTool() {
        return this.tool;
    }

    @Override
    public void setTool(AttachableTool tool) {
        this.tool = Optional.of(tool);
    }

    @Override
    public void removeTool() {
        this.tool = Optional.empty();
    }

    @Override
    public List<Move> getMoves() {
        return this.moves;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MonsterImpl monster = (MonsterImpl) o;
        return Objects.equals(name, monster.name) && Objects.equals(stats, monster.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stats);
    }

    @Override
    public String toString() {
        return "MonsterImpl{" +
                "name='" + name + '\'' +
                ", stats=" + stats +
                ", health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                ", moves=" + moves +
                ", tool=" + tool +
                '}';
    }
}
