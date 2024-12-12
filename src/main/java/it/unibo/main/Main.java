package it.unibo.main;

import it.unibo.core.match.BaseStrategy;
import it.unibo.core.match.DamageStrategy;
import it.unibo.core.match.Player;
import it.unibo.core.match.SimpleAIPlayer;
import it.unibo.core.monster.*;

public class Main {
    public static void main(String[] args) {
        Monster pika = new MonsterBuilder()
            .setName("Pikachu")
            .setType(TypeEnum.ELECTRIC)
            .setAttack(55)
            .setDefense(40)
            .setHp(135)
            .setMoves(
                Move.create("Thunder Shock", 40, TypeEnum.ELECTRIC),
                Move.create("Quick Attack", 40, TypeEnum.NORMAL),
                Move.create("Thunderbolt", 90, TypeEnum.ELECTRIC),
                Move.create("Iron Tail", 100, TypeEnum.STEEL)
            ).build();

        Monster charmender = new MonsterBuilder()
            .setName("Charmander")
            .setType(TypeEnum.FIRE)
            .setAttack(52)
            .setDefense(43)
            .setHp(200)
            .setMoves(
                Move.create("Scratch", 40, TypeEnum.NORMAL),
                Move.create("Ember", 40, TypeEnum.FIRE),
                Move.create("Flamethrower", 90, TypeEnum.FIRE),
                Move.create("Fire Spin", 35, TypeEnum.FIRE)
            ).build();

        Player player1 = new SimpleAIPlayer();
        Player player2 = new SimpleAIPlayer();
        DamageStrategy damageStrategy = new BaseStrategy();
        while (pika.isAlive() || charmender.isAlive()) {
            System.out.println("Pikachu: " + pika.getHealth());
            System.out.println("Charmander: " + charmender.getHealth());
            var move = player1.chooseMove(pika, charmender);
            System.out.printf("%s used %s\n", pika.getName(), move.getName());
            var damage = damageStrategy.calculateDamage(pika, move, charmender);
            charmender.updateHealth(-damage);
            System.out.printf("Charmander's health: %d\n", charmender.getHealth());
            var move2 = player2.chooseMove(charmender, pika);
            System.out.printf("%s used %s\n", charmender.getName(), move2.getName());
            damageStrategy.calculateDamage(charmender, move2, pika);
            pika.updateHealth(-damage);
            System.out.printf("Pikachu's health: %d\n", pika.getHealth());
        }
    }
}