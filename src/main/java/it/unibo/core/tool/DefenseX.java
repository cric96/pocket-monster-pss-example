package it.unibo.core.tool;

import it.unibo.core.monster.Monster;

public class DefenseX implements SingleUseTool {
    private final int damage;

    public DefenseX(String name, int damage) {
        this.damage = damage;
    }

    @Override
    public void use(Monster target) {
        target.updateDefense(damage);
    }

    @Override
    public String getName() {
        return "Defense X";
    }
}
