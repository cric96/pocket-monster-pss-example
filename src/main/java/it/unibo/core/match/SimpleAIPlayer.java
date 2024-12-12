package it.unibo.core.match;

import it.unibo.core.monster.Monster;
import it.unibo.core.monster.Move;
import it.unibo.core.tool.SingleUseTool;

import java.util.Optional;
import java.util.Random;

/**
 * A simple AI player that randomly chooses moves.
 */
public class SimpleAIPlayer implements Player {
    private final Random random = new Random();

    /**
     * Chooses a random move from the attacker's available moves.
     *
     * @param attacker the attacking monster
     * @param defender the defending monster
     * @return the chosen move
     */
    @Override
    public Move chooseMove(Monster attacker, Monster defender) {
        return attacker.getMoves().get(random.nextInt(attacker.getMoves().size()));
    }

    /**
     * Chooses a tool to use. This implementation always returns an empty Optional.
     *
     * @param attacker the attacking monster
     * @param defender the defending monster
     * @return an empty Optional
     */
    @Override
    public Optional<SingleUseTool> chooseTool(Monster attacker, Monster defender) {
        return Optional.empty();
    }
}
