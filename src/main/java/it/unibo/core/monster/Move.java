package it.unibo.core.monster;
/**
 * Interface representing a move that a monster can perform.
 */
public interface Move {
    /**
     * Gets the name of the move.
     *
     * @return the name of the move
     */
    String getName();

    /**
     * Gets the power of the move.
     *
     * @return the power of the move
     */
    int getPower();

    /**
     * Gets the type of the move.
     *
     * @return the type of the move
     */
    Type getType();

    /**
     * Creates a new move with the specified name, power, and type.
     *
     * @param name the name of the move
     * @param power the power of the move
     * @param type the type of the move
     * @return a new instance of Move
     */
    static Move create(String name, int power, Type type) {
        return new MoveImpl(name, power, type);
    }
}