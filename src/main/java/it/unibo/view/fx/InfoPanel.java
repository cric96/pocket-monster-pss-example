package it.unibo.view.fx;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class InfoPanel {
    private final HBox infoPanel = new HBox();
    private final Label label = new Label("Info Panel");
    public InfoPanel() {
        infoPanel.getChildren().add(label);
    }

    public Node getPanel() {
        return infoPanel;
    }

    public void update(String info) {
        label.setText(info);
    }
}
