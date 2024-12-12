package it.unibo.core.tool;

import it.unibo.core.monster.Monster;

public class AttackX extends AbstractTool {
    private final int damage;

    public AttackX(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    @Override
    public void use(Monster target) {
        target.updateAttack(damage);
    }

    @Override
    public String getName() {
        return "Attack X";
    }
}
