package it.unibo.core.monster;

import java.util.Objects;

public class MoveImpl implements Move {
    private String name;
    private int power;
    private Type type;

    MoveImpl(String name, int power, Type type) {
        this.name = name;
        this.power = power;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MoveImpl move = (MoveImpl) o;
        return power == move.power && Objects.equals(name, move.name) && Objects.equals(type, move.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power, type);
    }

    @Override
    public String toString() {
        return "MoveImpl{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", type=" + type +
                '}';
    }
}
