package it.unibo.core.match;

import it.unibo.core.monster.Monster;
import it.unibo.core.monster.Move;

/**
 * BaseStrategy is a basic implementation of the DamageStrategy interface.
 */
public class BaseStrategy implements DamageStrategy {

    /**
     * Calculates the damage dealt by the attacker to the defender.
     *
     * @param attacker the attacking monster
     * @param attackerMove the move used by the attacker
     * @param defender the defending monster
     * @return the calculated damage, ensuring it is not less than zero
     */
    @Override
    public int calculateDamage(Monster attacker, Move attackerMove, Monster defender) {
        int amount = attackerMove.getPower() + attacker.getAttack() - defender.getDefense();
        return Math.max(amount, 0);
    }
}