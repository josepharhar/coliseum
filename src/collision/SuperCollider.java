package collision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import util.Position;

public class SuperCollider {
    private static final int MAGIC_NUMBER = 12;

    public static void collide(List<CollisionObject> objects) {
        HashMap<CollisionObject, List<CollisionObject>> collisions = new HashMap<>();
        recursiveCollide(collisions, objects);
    }

    private static void recursiveCollide(HashMap<CollisionObject, List<CollisionObject>> collisions, List<CollisionObject> objects) {
        if (objects.size() < MAGIC_NUMBER) {
            dumbCollide(collisions, objects);
            return;
        }
        Position middle = findMiddle(objects);
        List<CollisionObject> topLeft = new ArrayList<CollisionObject>(objects.size() / 2);
        List<CollisionObject> topRight = new ArrayList<CollisionObject>(objects.size() / 2);
        List<CollisionObject> bottomLeft = new ArrayList<CollisionObject>(objects.size() / 2);
        List<CollisionObject> bottomRight = new ArrayList<CollisionObject>(objects.size() / 2);
        int doubled = 0;
        int numAdded = 0;
        for (CollisionObject obj : objects) {
            numAdded = 0;
            Position pos = obj.getLocation();
            if (pos.x + obj.getRadius() > middle.x) {
                if (pos.y + obj.getRadius() > middle.y) {
                    numAdded++;
                    topLeft.add(obj);
                }
                if (pos.y - obj.getRadius() < middle.y) {
                    numAdded++;
                    topRight.add(obj);
                }
            }
            if (pos.x - obj.getRadius() < middle.x) {
                if (pos.y + obj.getRadius() > middle.y) {
                    numAdded++;
                    bottomLeft.add(obj);
                }
                if (pos.y - obj.getRadius() < middle.y) {
                    numAdded++;
                    bottomRight.add(obj);
                }
            }
            if (numAdded > 1) {
                doubled += numAdded - 1;
            }
            if (doubled > objects.size()) {
                break;
            }
        }
        if (doubled > objects.size()) {
            dumbCollide(collisions, objects);
        } else {
            recursiveCollide(collisions, topLeft);
            recursiveCollide(collisions, topRight);
            recursiveCollide(collisions, bottomLeft);
            recursiveCollide(collisions, bottomRight);
        }
    }

    public static void dumbCollide(HashMap<CollisionObject, List<CollisionObject>> collisions, List<CollisionObject> objects) {
        for (CollisionObject a : objects) {
            for (CollisionObject b : objects) {
                if (a != b && Position.distance(a.getLocation(), b.getLocation()) < a.getRadius() + b.getRadius()) {
                    List<CollisionObject> alreadyCollided = collisions.get(a);
                    if (alreadyCollided == null || !alreadyCollided.contains(b)) {
                        a.collide(b);
                        if (alreadyCollided == null) {
                            alreadyCollided = new LinkedList<CollisionObject>();
                            collisions.put(a, alreadyCollided);
                        }
                        alreadyCollided.add(b);
                    }
                }
            }
        }
    }

    private static Position findMiddle(List<CollisionObject> objects) {
        double x = 0.0;
        double y = 0.0;
        int count = 0;
        for (CollisionObject obj : objects) {
            x += obj.getLocation().x;
            y += obj.getLocation().y;
            count++;
        }
        return new Position(x / count, y / count);
    }
}
