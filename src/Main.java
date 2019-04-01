
import engine.Engine;
import engine.GameLoader;
import game.Element;
import game.Game;
import game.Tile;
import impl.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.FirebaseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {


        Button startGameButton = new Button("Start Game");
        Button highScoreButton = new Button("Highscores");

        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startGame(primaryStage);
            }
        });


        VBox vBox = new VBox();
        vBox.getChildren().addAll(startGameButton,highScoreButton);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void startGame(Stage primaryStage){
        GameLoader gameLoader = new GameLoader();

        HashMap<Integer, Class<? extends Tile>> tileHashMap = new HashMap<>();
        tileHashMap.put(0,WaterTile.class);
        tileHashMap.put(1, SandTile.class);
        gameLoader.addTileConfiguration(tileHashMap);

        HashMap<Integer, Class<? extends Element>> elementHashMap = new HashMap<>();
        elementHashMap.put(0, Link.class);
//              elementHashMap.put(0, MouseCursor.class);
        gameLoader.addElementsConfiguration(elementHashMap);

        gameLoader.addLevel(1,"/resources/level1Tiles.txt","/resources/level1Elements.txt");

        Game game = gameLoader.load();

        game.getLevels().get(0).setFocusedElement(game.getLevels().get(0).getElements().get(0));
        game.setActiveLevel(game.getLevels().get(0));

        Engine engine = new Engine(game);
        engine.addBehavior(MoveOnMouseMove.class,new MouseMoveManager());
        engine.start(primaryStage);
    }
}
