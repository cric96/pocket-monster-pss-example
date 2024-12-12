package it.unibo.view.fx;

import it.unibo.view.MonsterRender;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.Objects;


public class MonsterPanel {
    private final VBox monsterPanel;
    private final ImageView monsterImage;
    private final Label monsterName;
    private final Label monsterHealth;
    public MonsterPanel() {
        this.monsterPanel = new VBox(10); // Spacing of 10 between children
        monsterPanel.setAlignment(Pos.CENTER);

        // Initialize ImageView
        monsterImage = new ImageView();
        monsterImage.setFitWidth(200);
        monsterImage.setFitHeight(200);

        // Initialize monsterName Label
        monsterName = new Label("Monster Name");
        monsterName.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        monsterName.setTextAlignment(TextAlignment.CENTER);

        // Initialize monsterHealth Label
        monsterHealth = new Label("Health: 100");
        monsterHealth.setFont(Font.font("Arial", 16));
        monsterHealth.setTextAlignment(TextAlignment.CENTER);
        this.monsterPanel.getChildren().addAll(monsterName, monsterImage, monsterHealth);

    }

    public Node getPanel() {
        return monsterPanel;
    }

    public void update(MonsterRender render) {
        System.out.println(render.getName());
        var image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageFromMonster(render.getName()))));
        monsterImage.setImage(image);
        monsterName.setText(render.getName());
        monsterHealth.setText("Health: " + render.getHealth());
    }

    private String imageFromMonster(String name) {
        return "/monsters/" + name.toLowerCase() + ".png";
    }
}
