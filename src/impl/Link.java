package impl;


import behaviourdingen.behaviors.KeyPressed;
import gamedingen.Element;

import java.util.ArrayList;

public class Link extends Element implements KeyPressed {
    public Link() {
        super("file:resources/Link.png");
    }

    @Override
    public void handleKeyPresses(ArrayList<String> arrayList) {
        if(arrayList.contains("UP")){
            super.setY(super.getY()-10);
        }
        else if(arrayList.contains("DOWN")){
            super.setY(super.getY()+10);
        }
        else if (arrayList.contains("RIGHT")){
            super.setX(super.getX()+10);
        }
        else if (arrayList.contains("LEFT")){
            super.setX(super.getX()-10);
        }
    }
}
