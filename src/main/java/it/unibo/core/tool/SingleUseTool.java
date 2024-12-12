package it.unibo.core.tool;

import it.unibo.core.monster.Monster;

public interface SingleUseTool {
    void use(Monster target);
    String getName();
}
