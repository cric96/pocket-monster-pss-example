package it.unibo.view;

/**
 * Observer interface for match view events.
 */
public interface MatchViewObserver {

    /**
     * Called when a tool is used.
     *
     * @param toolName the name of the tool used
     */
    void onToolUse(String toolName);

    /**
     * Called when a move is selected.
     *
     * @param moveName the name of the move selected
     */
    void onMoveSelected(String moveName);
}
