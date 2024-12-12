package it.unibo.core.tool;

import java.util.Objects;

/**
 * Abstract base class for tools that can be used only once.
 */
public abstract class AbstractTool implements SingleUseTool {
    private String name;

    /**
     * Constructs an AbstractTool with the specified name.
     *
     * @param name the name of the tool
     */
    public AbstractTool(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the tool.
     *
     * @return the name of the tool
     */
    public String getName() {
        return name;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public final boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTool that = (AbstractTool) o;
        return Objects.equals(name, that.name);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }
}