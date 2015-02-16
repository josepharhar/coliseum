package drawer;

import static org.lwjgl.opengl.GL11.*;
import util.Position;

public class PlayerDrawer extends Drawer {

    private Position position;

    private double size;

    // rotation in radians
    private double rotation;

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void draw() {

        glPushMatrix();
        {
            glTranslated(position.x, position.y, 0d);
            glRotated(rotation, 1d, 0d, 0d);

            glBegin(GL_QUADS);
            {
                glColor3d(0.0f, 1.0f, 0.0f);
                glVertex3d(size, size, -1.0f);
                glVertex3d(-size, size, -1.0f);
                glVertex3d(-size, size, 1.0f);
                glVertex3d(size, size, 1.0f);

                glColor3d(1.0f, 0.5f, 0.0f);
                glVertex3d(size, -size, 1.0f);
                glVertex3d(-size, -size, 1.0f);
                glVertex3d(-size, -size, -1.0f);
                glVertex3d(size, -size, -1.0f);

                glColor3d(1.0f, 0.0f, 0.0f);
                glVertex3d(size, size, 1.0f);
                glVertex3d(-size, size, 1.0f);
                glVertex3d(-size, -size, 1.0f);
                glVertex3d(size, -size, 1.0f);

                glColor3d(1.0f, 1.0f, 0.0f);
                glVertex3d(size, -size, -1.0f);
                glVertex3d(-size, -size, -1.0f);
                glVertex3d(-size, size, -1.0f);
                glVertex3d(size, size, -1.0f);

                glColor3d(0.0f, 0.0f, 1.0f);
                glVertex3d(-size, size, 1.0f);
                glVertex3d(-size, size, -1.0f);
                glVertex3d(-size, -size, -1.0f);
                glVertex3d(-size, -size, 1.0f);

                glColor3d(1.0f, 0.0f, 1.0f);
                glVertex3d(size, size, -1.0f);
                glVertex3d(size, size, 1.0f);
                glVertex3d(size, -size, 1.0f);
                glVertex3d(size, -size, -1.0f);
            }
            glEnd();

        }
        glPopMatrix();
    }
}
