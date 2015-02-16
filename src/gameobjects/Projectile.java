package gameobjects;

import util.Position;
import drawer.ProjectileDrawer;

public class Projectile extends GameObject {
    
    private Position position;
    
    private double size;

    private ProjectileDrawer drawer;
    
    public void updateDrawer() {
        drawer.setPosition(position);
        drawer.setSize(size);
    }
    
    public void draw() {
        drawer.draw();
    }
}
