package it.unibo.view.fx;

import it.unibo.view.MatchView;
import it.unibo.view.MatchViewObserver;
import it.unibo.view.MonsterRender;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class MatchViewFX implements MatchView {
    private final BorderPane mainPane;
    private final MonsterPanel leftMonster; ;
    private final MonsterPanel rightMonster;
    private final ToolsPanel tools;
    private final InfoPanel info;
    private MovesPanel moves;
    private final Stage stage;
    // create a popup to show info
    public MatchViewFX(final Stage stage) {
        final VBox bottom = new VBox();
        // fill width with vbox
        bottom.setFillWidth(true);
        this.mainPane = new BorderPane();
        this.mainPane.setPadding(new Insets(20));
        this.tools = new ToolsPanel();
        this.moves = new MovesPanel();
        this.info = new InfoPanel();
        this.leftMonster = new MonsterPanel();
        this.rightMonster = new MonsterPanel();
        this.mainPane.setLeft(leftMonster.getPanel());
        this.mainPane.setRight(rightMonster.getPanel());
        bottom.getChildren().addAll(moves.getPanel(), info.getPanel());
        this.mainPane.setBottom(bottom);
        this.mainPane.setTop(tools.getPanel());
        this.stage = stage;
        // attach style
        this.mainPane.getStylesheets().add(getClass().getResource("/css/dracula.css").toExternalForm());

    }
    @Override
    public void renderTools(List<String> tool) {
        Platform.runLater(() -> tools.renderTools(tool));
    }

    @Override
    public void renderMoves(List<String> moves) {
        Platform.runLater(() -> this.moves.renderMoves(moves));
    }

    @Override
    public void renderPlayerMonster(MonsterRender monster) {
        Platform.runLater(() -> leftMonster.update(monster));
    }

    @Override
    public void renderEnemyMonster(MonsterRender monster) {
        Platform.runLater(() -> rightMonster.update(monster));
    }

    @Override
    public void performingMove(MonsterRender monster, String moveName) {
        Platform.runLater(() -> info.update(String.format("%s is performing %s", monster.getName(), moveName)));
    }

    @Override
    public void movePerformed() {
        Platform.runLater(() -> info.update(""));
    }

    @Override
    public void showWinner(String winner) {
        Platform.runLater(() -> info.update(String.format("%s wins!", winner)));
    }

    @Override
    public void close() {
        Platform.exit();
    }

    @Override
    public void attachObserver(MatchViewObserver observer) {
        this.tools.setObserver(observer);
        this.moves.setObserver(observer);
    }

    public void open() {
        stage.setScene(new javafx.scene.Scene(mainPane));
        stage.show();
    }
}
