package ch.bbcag.bbcspaceinvader.gui.scenes;

import ch.bbcag.bbcspaceinvader.gui.Navigator;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import static ch.bbcag.bbcspaceinvader.common.Const.SCREEN_HEIGHT;
import static ch.bbcag.bbcspaceinvader.common.Const.SCREEN_WIDTH;

public class VictoryScene {

    private Scene scene;
    private Navigator navigator;
    private GameScene gameScene;

    public VictoryScene(Navigator navigator, GameScene gameScene) {
        this.navigator = navigator;
        this.gameScene = gameScene;
        createScene();
    }

    private void createScene() {
        Group victoryRoot = new Group();

        Image victorySceneImage = new Image(this.getClass().getResourceAsStream("/background_victory.png"));
        Canvas victoryCanvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        victoryCanvas.getGraphicsContext2D().drawImage(victorySceneImage, 0, 0);
        victoryRoot.getChildren().add(victoryCanvas);

        scene = new Scene(victoryRoot);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                switchToGameScene();
            } else if (e.getCode() == KeyCode.ESCAPE) {
                System.out.println("Key Pressed: " + e.getCode());
                switchToStartScene();
            }
        });
    }


    private void switchToGameScene() {
        gameScene.resetGame();
        navigator.navigateTo(gameScene.getScene());
    }

    private void switchToStartScene() {
        navigator.navigateTo(new StartScene(navigator).getScene());
    }
    public Scene getScene() {
        return scene;
    }
}
