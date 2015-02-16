package collision;

import util.Position;

public class SimpleCollisionObject implements CollisionObject {
    private double radius;
    private Position location;
    private String name;
    
    public SimpleCollisionObject(double radius, Position location, String name) {
        this.radius = radius;
        this.location = location;
        this.name = name;
    }
    
    @Override
    public Position getLocation() {
        return location;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void collide(CollisionObject other) {
        //System.out.println(this + " was hit by " + other);
    }
    
    @Override
    public String toString() {
        return name;
    }
}
