package it.unibo.core.monster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterImplTest {
    private MonsterImpl monster;
    private Monster.Stats stats;
    private List<Move> moves;

    @BeforeEach
    void setUp() {
        stats = new MonsterStatsImpl(100, 50, 50, TypeEnum.ELECTRIC); // Example stats
        moves = List.of(
            new MoveImpl("Thunderbolt", 100, TypeEnum.ELECTRIC),
            new MoveImpl("Quick Attack", 40, TypeEnum.NORMAL),
            new MoveImpl("Iron Tail", 100, TypeEnum.STEEL),
            new MoveImpl("Thunder", 110, TypeEnum.ELECTRIC)
        );
        monster = new MonsterImpl("Pikachu", moves, stats);
    }

    @Test
    void testGetName() {
        assertEquals("Pikachu", monster.getName());
    }

    @Test
    void testGetStats() {
        assertEquals(stats, monster.getStats());
    }

    @Test
    void testGetHealth() {
        assertEquals(100, monster.getHealth());
    }

    @Test
    void testIsAlive() {
        assertTrue(monster.isAlive());
        monster.updateHealth(-monster.getHealth());
        assertFalse(monster.isAlive());
    }

    @Test
    void testUpdateHealth() {
        monster.updateHealth(-50);
        assertEquals(50, monster.getHealth());
        monster.updateHealth(200);
        assertEquals(100, monster.getHealth());
    }

    @Test
    void testUpdateAttack() {
        monster.updateAttack(10);
        assertEquals(10 + monster.getStats().getBaseAttack(), monster.getAttack());
    }

    @Test
    void testUpdateDefense() {
        monster.updateDefense(10);
        assertEquals(10 + monster.getStats().getDefensePoints(), monster.getDefense());
    }

    @Test
    void testGetMoves() {
        assertEquals(4, monster.getMoves().size());
        assertEquals(moves, monster.getMoves());
    }
}