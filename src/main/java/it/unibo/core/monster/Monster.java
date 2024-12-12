package it.unibo.core.monster;

import it.unibo.core.tool.AttachableTool;
import java.util.List;
import java.util.Optional;

/**
 * Represents a Monster with various attributes and actions.
 */
public interface Monster {
    /**
     * Represents the statistics of a Monster.
     */
    interface Stats {
        /**
         * Gets the health points of the Monster.
         * @return the health points
         */
        int getHealthPoints();

        /**
         * Gets the base attack value of the Monster.
         * @return the base attack value
         */
        int getBaseAttack();

        /**
         * Gets the defense points of the Monster.
         * @return the defense points
         */
        int getDefensePoints();

        /**
         * Gets the type of the Monster.
         * @return the type
         */
        Type getType();
    }

    /**
     * Gets the name of the Monster.
     * @return the name
     */
    String getName();

    /**
     * Gets the statistics of the Monster.
     * @return the statistics
     */
    Stats getStats();

    /**
     * Gets the current health of the Monster.
     * @return the current health
     */
    int getHealth();

    /**
     * Updates the health of the Monster.
     * @param health the new health value
     */
    void updateHealth(int health);

    /**
     * Checks if the Monster is alive.
     * @return true if the Monster is alive, false otherwise
     */
    boolean isAlive();

    /**
     * Updates the attack value of the Monster.
     * @param attack the new attack value
     */
    void updateAttack(int attack);

    /**
     * Gets the current attack value of the Monster.
     * @return the current attack value
     */
    int getAttack();

    /**
     * Updates the defense value of the Monster.
     * @param defense the new defense value
     */
    void updateDefense(int defense);

    /**
     * Gets the current defense value of the Monster.
     * @return the current defense value
     */
    int getDefense();

    /**
     * Gets the tool attached to the Monster, if any.
     * @return an Optional containing the attached tool, or an empty Optional if no tool is attached
     */
    Optional<AttachableTool> getTool();

    /**
     * Sets a tool to be attached to the Monster.
     * @param tool the tool to attach
     */
    void setTool(AttachableTool tool);

    /**
     * Removes the tool attached to the Monster.
     */
    void removeTool();

    /**
     * Gets the list of moves available to the Monster.
     * @return the list of moves
     */
    List<Move> getMoves();
}