package impl;


import behavior.behaviors.Collidable;
import game.Tile;

public class SandTile extends Tile implements Collidable {
    public SandTile() {
        super("file:resources/SandTile.png");
    }

    @Override
    public void handleCollision(Collidable collidable) {

    }
}
