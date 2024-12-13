package it.unibo.core.tool;

import it.unibo.core.monster.Monster;

public interface SingleUseTool extends Tool {
    void use(Monster target);
}
