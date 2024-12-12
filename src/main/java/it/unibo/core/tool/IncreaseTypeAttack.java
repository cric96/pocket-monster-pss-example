package it.unibo.core.tool;

import it.unibo.core.monster.Type;

import java.util.Objects;

public class IncreaseTypeAttack implements AttachableTool {
    private final int damage;
    private final Type type;

    public IncreaseTypeAttack(String name, int damage, Type type) {
        this.damage = damage;
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public int getDamage() {
        return this.damage;
    }


    @Override
    public String getName() {
        return "Increase Type Attack";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IncreaseTypeAttack that = (IncreaseTypeAttack) o;
        return damage == that.damage && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(damage, type);
    }

    @Override
    public String toString() {
        return "IncreaseTypeAttack{" +
                "damage=" + damage +
                ", type=" + type +
                '}';
    }
}
