package it.unibo.main;

import it.unibo.controller.MatchImpl;
import it.unibo.core.match.BaseStrategy;
import it.unibo.core.match.Player;
import it.unibo.core.match.SimpleAIPlayer;
import it.unibo.core.monster.Monster;
import it.unibo.core.monster.MonsterBuilder;
import it.unibo.core.monster.Move;
import it.unibo.core.monster.TypeEnum;
import it.unibo.core.tool.SmallPotion;
import it.unibo.view.fx.MatchViewFX;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class AppFX extends Application {

    @Override
    public void start(Stage primaryStage) {
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
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        Player player1 = new SimpleAIPlayer();
        var potion = new SmallPotion();
        final var view = new MatchViewFX(primaryStage);
        final var match = new MatchImpl(pika, charmender, List.of(potion), new BaseStrategy(), player1, view);
        view.attachObserver(match);
        match.start();
    }

    static void run(final String[] args) {
        launch(args);
    }

    public static final class Main {
        private Main() {
            // the constructor will never be called directly.
        }

        public static void main(final String... args) {
            AppFX.run(args);
        }
    }
}