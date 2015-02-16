package gameobjects;

public abstract class GameObject {
    
    // This method will tell this GameObject's drawer information
    // about the state of this GameObject.
    // It will act as a "snapshot" for the graphics to draw with.
    public abstract void updateDrawer();
    
    // This method will tell this GameObject's drawer to actually draw
    // using the information supplied by updateDrawer
    public abstract void draw();
}
