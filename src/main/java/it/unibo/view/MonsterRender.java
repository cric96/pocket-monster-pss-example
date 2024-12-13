package it.unibo.view;

import it.unibo.core.monster.Move;

import java.util.List;

/**
 * Interface representing a renderable monster.
 */
public interface MonsterRender {
    /**
     * Gets the name of the monster.
     *
     * @return the name of the monster
     */
    String getName();

    /**
     * Gets the health of the monster.
     *
     * @return the health of the monster
     */
    int getHealth();

    /**
     * Creates a MonsterRender instance from a given Monster.
     *
     * @param monster the monster to create the render from
     * @return a MonsterRender instance
     */
    static MonsterRender fromMonster(it.unibo.core.monster.Monster monster) {
        return new MonsterRender() {
            @Override
            public String getName() {
                return monster.getName();
            }

            @Override
            public int getHealth() {
                return monster.getHealth();
            }
        };
    }
}