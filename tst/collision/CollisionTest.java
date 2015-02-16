package collision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.Position;

public class CollisionTest {
    public static void main(String args[]) {
        HashMap<CollisionObject, List<CollisionObject>> collisions = new HashMap<>();
        
        List<CollisionObject> lst = new ArrayList<>();
        
        for (int i = 0; i < 10000; i++) {
            lst.add(new SimpleCollisionObject(5, new Position((Math.random() - 0.5) * 300,(Math.random() - 0.5) * 300), i + " object"));
        }
        long start = System.nanoTime();
        SuperCollider.dumbCollide(collisions, lst);
        System.out.println(System.nanoTime() - start);
        
        start = System.nanoTime();
        SuperCollider.collide(lst);
        System.out.println(System.nanoTime() - start);
    }
}
