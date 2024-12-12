package it.unibo.core.match;

import it.unibo.core.monster.Monster;
import it.unibo.core.monster.Move;
import it.unibo.core.tool.SingleUseTool;

import java.util.Optional;

/**
 * Represents a player in the match.
 */
public interface Player {

    /**
     * Chooses a move for the given attacker and defender monsters.
     *
     * @param attacker the monster that is attacking
     * @param defender the monster that is defending
     * @return the chosen move
     */
    Move chooseMove(Monster attacker, Monster defender);

    /**
     * Chooses a tool for the given attacker and defender monsters.
     *
     * @param attacker the monster that is attacking
     * @param defender the monster that is defending
     * @return an optional containing the chosen tool, or empty if no tool is chosen
     */
    Optional<SingleUseTool> chooseTool(Monster attacker, Monster defender);
}
