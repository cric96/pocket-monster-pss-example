package it.unibo.core.monster;

import java.util.Objects;

public final class MonsterStatsImpl implements Monster.Stats {
    private final int healthPoints;
    private final int baseAttack;
    private final int defensePoints;
    private final Type type;

    MonsterStatsImpl(final int healthPoints, final int baseAttack, final int defensePoints, final Type type) {
        this.healthPoints = healthPoints;
        this.baseAttack = baseAttack;
        this.defensePoints = defensePoints;
        this.type = type;
    }
    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public int getBaseAttack() {
        return this.baseAttack;
    }

    @Override
    public int getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MonsterStatsImpl that = (MonsterStatsImpl) o;
        return healthPoints == that.healthPoints && baseAttack == that.baseAttack && defensePoints == that.defensePoints && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoints, baseAttack, defensePoints, type);
    }

    @Override
    public String toString() {
        return "MonsterStatsImpl{" +
                "healthPoints=" + healthPoints +
                ", baseAttack=" + baseAttack +
                ", defensePoints=" + defensePoints +
                ", type=" + type +
                '}';
    }
}
