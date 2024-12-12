package it.unibo.core.tool;

import it.unibo.core.monster.Monster;

public abstract class PotionLike extends AbstractTool {
    private int amount;
    public PotionLike(String name, int amount) {
        super(name);
        this.amount = amount;
    }

    @Override
    public void use(Monster target) {
        target.updateHealth(amount);
    }

    @Override
    public String toString() {
        return "PotionLike{" +
                "amount=" + amount +
                '}';
    }
}
