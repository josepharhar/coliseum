package gameobjects;

import util.Position;
import drawer.PlayerDrawer;

public class Player extends GameObject {
    
    private Position position;
    
    private double size;
    
    private double rotation;
    
    private PlayerDrawer drawer;
    
    public Player(Position position, double size) {
        this.position = position;
        this.size = size;
        rotation = Math.random() * Math.PI * 2;
        drawer = new PlayerDrawer();
    }
    
    public void updateDrawer() {
        drawer.setPosition(new Position(position));
        drawer.setSize(size);
        
        //rotation is just a graphical effect that causes the cube to rotate
        rotation += 1d;
        drawer.setRotation(rotation);
    }
    
    public void draw() {
        drawer.draw();
    }
}
