package it.unibo.controller;

import it.unibo.core.match.DamageStrategy;
import it.unibo.core.match.Player;
import it.unibo.core.monster.Monster;
import it.unibo.core.monster.Move;
import it.unibo.core.tool.SingleUseTool;
import it.unibo.view.MatchView;
import it.unibo.view.MatchViewObserver;
import it.unibo.view.MonsterRender;
import java.util.List;

/**
 * Implementation of the Match interface.
 * Handles the logic for a match between two monsters.
 */
public class MatchImpl implements MatchViewObserver, Match {
    private static final int SLEEP_TIME = 1000;
    private final Monster monsterPlayer;
    private final Monster monsterOpponent;
    private final List<SingleUseTool> tools;
    private final MatchView view;
    private final DamageStrategy damageStrategy;
    private final Player enemyAi;

    /**
     * Constructs a new MatchImpl.
     *
     * @param monsterPlayer the player's monster
     * @param monsterOpponent the opponent's monster
     * @param tools the list of tools available
     * @param damageStrategy the strategy to calculate damage
     * @param enemyAi the AI controlling the enemy
     * @param view the view to render the match
     */
    public MatchImpl(
        Monster monsterPlayer,
        Monster monsterOpponent,
        List<SingleUseTool> tools,
        DamageStrategy damageStrategy,
        Player enemyAi,
        MatchView view
    ) {
        this.monsterPlayer = monsterPlayer;
        this.monsterOpponent = monsterOpponent;
        this.view = view;
        this.tools = tools;
        this.damageStrategy = damageStrategy;
        this.enemyAi = enemyAi;
    }

    /**
     * Handles the event when a tool is used.
     *
     * @param toolName the name of the tool used
     */
    @Override
    public void onToolUse(String toolName) {
        async(() -> {
            for (SingleUseTool tool : tools) {
                if (tool.getName().equals(toolName)) {
                    tool.use(monsterPlayer);
                    view.renderPlayerMonster(MonsterRender.fromMonster(monsterPlayer));
                }
            }
            view.renderTools(adaptTools());
        });
    }

    /**
     * Handles the event when a move is selected.
     *
     * @param moveName the name of the move selected
     */
    @Override
    public void onMoveSelected(String moveName) {
        async(() -> {
            var move = monsterPlayer.getMoves().stream().filter(m -> m.getName().equals(moveName)).findFirst().get();
            var damage = damageStrategy.calculateDamage(monsterPlayer, move, monsterOpponent);
            monsterOpponent.updateHealth(-damage);
            view.performingMove(MonsterRender.fromMonster(monsterPlayer), moveName);
            sleep();
            view.renderEnemyMonster(MonsterRender.fromMonster(monsterOpponent));
            view.movePerformed();
            if (monsterOpponent.getHealth() <= 0) {
                winning("Player");
            } else {
                var enemyMove = enemyAi.chooseMove(monsterOpponent, monsterPlayer);
                var enemyDamage = damageStrategy.calculateDamage(monsterOpponent, enemyMove, monsterPlayer);
                view.performingMove(MonsterRender.fromMonster(monsterOpponent), enemyMove.getName());
                sleep();
                monsterPlayer.updateHealth(-enemyDamage);
                view.renderEnemyMonster(MonsterRender.fromMonster(monsterOpponent));
                view.movePerformed();
                if (monsterPlayer.getHealth() <= 0) {
                    winning("Enemy");
                }
            }
        });
    }

    /**
     * Starts the match.
     * Initializes the view and renders the initial state.
     */
    public void start() {
        view.open();
        view.renderPlayerMonster(MonsterRender.fromMonster(monsterPlayer));
        view.renderEnemyMonster(MonsterRender.fromMonster(monsterOpponent));
        view.renderTools(adaptTools());
        view.renderMoves(adaptMoves());
    }

    /**
     * Adapts the list of tools to a list of tool names.
     *
     * @return the list of tool names
     */
    private List<String> adaptTools() {
        return this.tools.stream().map(SingleUseTool::getName).toList();
    }

    /**
     * Adapts the list of moves to a list of move names.
     *
     * @return the list of move names
     */
    private List<String> adaptMoves() {
        return this.monsterPlayer.getMoves().stream().map(Move::getName).toList();
    }

    /**
     * Sleeps for a predefined amount of time.
     */
    private void sleep() {
        try {
            Thread.sleep(MatchImpl.SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void winning(final String who) {
        view.showWinner(who);
        sleep();
        view.close();
    }

    private void async(final Runnable runnable) {
        new Thread(runnable).start();
    }
}