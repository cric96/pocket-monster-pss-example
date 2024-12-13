package it.unibo.view.fx;

import it.unibo.view.MatchViewObserver;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.List;

public class MovesPanel {
    private MatchViewObserver observer;
    private HBox movesPanel;

    public MovesPanel() {
        this.movesPanel = new HBox(10);
        this.movesPanel.setFillHeight(true);
    }

    public void renderMoves(List<String> moves) {
        // render moves
        for (var move : moves) {
            // create a button for each move
            var button = new Button(move);
            button.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(button, Priority.ALWAYS);
            button.setOnAction(e -> observer.onMoveSelected(move));
            movesPanel.getChildren().add(button);
        }
    }

    public Node getPanel() {
        return movesPanel;
    }

    public void setObserver(MatchViewObserver observer) {
        this.observer = observer;
    }
}
