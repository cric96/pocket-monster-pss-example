package it.unibo.core.match;

import it.unibo.core.monster.Monster;
import it.unibo.core.monster.Move;

/**
 * Interface for defining a strategy to calculate damage in a match.
 */
public interface DamageStrategy {
    /**
     * Calculates the damage dealt by an attacker to a defender.
     *
     * @param attacker the monster performing the attack
     * @param attackerMove the move used by the attacker
     * @param defender the monster receiving the attack
     * @return the calculated damage as an integer
     */
    int calculateDamage(Monster attacker, Move attackerMove, Monster defender);
}