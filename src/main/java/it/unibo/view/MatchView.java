package it.unibo.view;

import java.util.List;

/**
 * Interface representing the view for a match.
 */
public interface MatchView {

    /**
     * Renders the tools available.
     *
     * @param tool the list of tools to render
     */
    void renderTools(List<String> tool);

    /**
     * Renders the moves available.
     *
     * @param moves the list of moves to render
     */
    void renderMoves(List<String> moves);

    /**
     * Renders the player's monster.
     *
     * @param monster the player's monster to render
     */
    void renderPlayerMonster(MonsterRender monster);

    /**
     * Renders the enemy's monster.
     *
     * @param monster the enemy's monster to render
     */
    void renderEnemyMonster(MonsterRender monster);

    /**
     * Indicates that a move is being performed.
     *
     * @param monster the monster performing the move
     * @param moveName the name of the move being performed
     */
    void performingMove(MonsterRender monster, String moveName);

    /**
     * Indicates that a move has been performed.
     */
    void movePerformed();

    /**
     * Displays the winner of the match.
     *
     * @param winner the name of the winner
     */
    void showWinner(String winner);

    /**
     * Closes the view.
     */
    void close();

    /**
     * Opens the view.
     */
    void open();

    /**
     * Attaches an observer to the view.
     *
     * @param observer the observer to attach
     */
    void attachObserver(MatchViewObserver observer);
}