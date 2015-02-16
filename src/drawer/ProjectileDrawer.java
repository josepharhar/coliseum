package drawer;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.glu.Sphere;

import util.Position;

public class ProjectileDrawer extends Drawer {

    private Position position;

    // This has to be a float for sphere.draw
    private float size;

    private Sphere sphere = new Sphere();

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSize(double size) {
        this.size = (float) size;
    }

    public void draw() {

        glPushMatrix();
        {
            glTranslated(position.x, position.y, 0d);

            sphere.draw(size, 16, 16);
        }
        glPopMatrix();
    }
}
