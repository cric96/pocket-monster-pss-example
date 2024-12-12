package it.unibo.controller;

/**
 * Represents a match of monsters that can be started.
 * A match involves multiple monsters competing against each other.
 */
public interface Match {
    /**
     * Starts the match, initiating the competition between monsters.
     */
    void start();
}