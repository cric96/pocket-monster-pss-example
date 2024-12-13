package it.unibo.view.fx;

import it.unibo.view.MatchViewObserver;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class ToolsPanel {
    private MatchViewObserver observer;
    private HBox toolsPanel;

    public ToolsPanel() {
        this.toolsPanel = new HBox();
    }

    public void renderTools(List<String> tools) {
        // render tools
        for (var tool : tools) {
            // create a button for each tool
            var button = new Button(tool);
            button.setOnAction(e -> observer.onToolUse(tool));
            toolsPanel.getChildren().add(button);
        }
    }

    public Node getPanel() {
        return toolsPanel;
    }

    public void setObserver(MatchViewObserver observer) {
        this.observer = observer;
    }
}
