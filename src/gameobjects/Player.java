package gameobjects;

import util.Position;
import drawer.PlayerDrawer;

public class Player extends GameObject {
    
    private Position position;
    
    private double size;
    
    private double rotation;
    
    private PlayerDrawer drawer;
    
    public Player() {
        
    }
    
    public void updateDrawer() {
        drawer.setPosition(position);
        drawer.setSize(size);
        
        //rotation is just a graphical effect that causes the cube to rotate
        rotation += 0.01d;
        drawer.setRotation(rotation);
    }
    
    public void draw() {
        drawer.draw();
    }
}
