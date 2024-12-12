package it.unibo.core.monster;

/**
 * Represents a type of monster with specific weaknesses and resistances.
 */
public interface Type {
    /**
     * Gets the name of the type.
     *
     * @return the name of the type
     */
    String getName();

    /**
     * Checks if this type is weak to another type.
     *
     * @param type the other type to check against
     * @return true if this type is weak to the other type, false otherwise
     */
    boolean isWeakTo(Type type);

    /**
     * Checks if this type is resistant to another type.
     *
     * @param type the other type to check against
     * @return true if this type is resistant to the other type, false otherwise
     */
    boolean isResistantTo(Type type);
}