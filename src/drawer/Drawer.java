package drawer;

public abstract class Drawer {
    
    
    /**
     * The draw method will make specialized openGL calls for what it is trying to draw.
     * For example, the PlayerDrawer will use this draw method to draw a player.
     */
    public abstract void draw();
}
