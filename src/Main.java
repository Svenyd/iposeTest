import enginedingen.Engine;

import enginedingen.GameLoader;
import gamedingen.Element;
import gamedingen.Game;
import gamedingen.Level;
import gamedingen.Tile;
import impl.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        GameLoader gameLoader = new GameLoader();
        HashMap<Integer, Class<? extends Tile>> tileHashMap = new HashMap<>();
        tileHashMap.put(0,WaterTile.class);
        tileHashMap.put(1, SandTile.class);
        gameLoader.addTileConfiguration(tileHashMap);
        HashMap<Integer, Class<? extends Element>> elementHashMap = new HashMap<>();


        elementHashMap.put(0, Link.class);
//        elementHashMap.put(0, MouseCursor.class);

        gameLoader.addElementsConfiguration(elementHashMap);
        gameLoader.addLevel(1,"resources/level1Tiles.txt","resources/level1Elements.txt");

        Game game = gameLoader.load();

        game.getLevels().get(0).setFocusedElement(game.getLevels().get(0).getElements().get(0));
        game.setActiveLevel(game.getLevels().get(0));

        Engine engine = new Engine(game);
        engine.addBehavior(MoveOnMouseMove.class,new MouseMoveManager());
        engine.start(primaryStage);


    }
}
