package drawer;

import static org.lwjgl.opengl.GL11.*;
import util.Position;

public class PlayerDrawer extends Drawer {

    private Position position;

    private double size;

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void draw() {

        glBegin(GL_QUADS);
        {
            glColor3d(0.0f, 1.0f, 0.0f);
            glVertex3d(position.x + size, position.y + size, -1.0f);
            glVertex3d(position.x - size, position.y + size, -1.0f);
            glVertex3d(position.x - size, position.y + size, 1.0f);
            glVertex3d(position.x + size, position.y + size, 1.0f);
    
            glColor3d(1.0f, 0.5f, 0.0f);
            glVertex3d(position.x + size, position.y - size, 1.0f);
            glVertex3d(position.x - size, position.y - size, 1.0f);
            glVertex3d(position.x - size, position.y - size, -1.0f);
            glVertex3d(position.x + size, position.y - size, -1.0f);
    
            glColor3d(1.0f, 0.0f, 0.0f);
            glVertex3d(position.x + size, position.y + size, 1.0f);
            glVertex3d(position.x - size, position.y + size, 1.0f);
            glVertex3d(position.x - size, position.y - size, 1.0f);
            glVertex3d(position.x + size, position.y - size, 1.0f);
    
            glColor3d(1.0f, 1.0f, 0.0f);
            glVertex3d(position.x + size, position.y - size, -1.0f);
            glVertex3d(position.x - size, position.y - size, -1.0f);
            glVertex3d(position.x - size, position.y + size, -1.0f);
            glVertex3d(position.x + size, position.y + size, -1.0f);
    
            glColor3d(0.0f, 0.0f, 1.0f);
            glVertex3d(position.x - size, position.y + size, 1.0f);
            glVertex3d(position.x - size, position.y + size, -1.0f);
            glVertex3d(position.x - size, position.y - size, -1.0f);
            glVertex3d(position.x - size, position.y - size, 1.0f);
    
            glColor3d(1.0f, 0.0f, 1.0f);
            glVertex3d(position.x + size, position.y + size, -1.0f);
            glVertex3d(position.x + size, position.y + size, 1.0f);
            glVertex3d(position.x + size, position.y - size, 1.0f);
            glVertex3d(position.x + size, position.y - size, -1.0f);
        }
        glEnd();
    }
}
