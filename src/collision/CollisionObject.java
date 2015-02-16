package collision;

import util.Position;

public interface CollisionObject {
    public Position getLocation();
    public double getRadius();
    public void collide(CollisionObject other);
}
