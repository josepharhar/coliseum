package surface;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.BufferUtils.*;

public class Axis {
    public static void draw() {
        
        glLineWidth(2f);
        
        // X Axis
        glColor3f(1f, 0f, 0f);
        glBegin(GL_LINES);
            glVertex3f(0f, 0f, 0f);
            glVertex3f(1f, 0f, 0f);
        glEnd();

        // Y axis
        glColor3f(0f, 1f, 0f);
        glBegin(GL_LINES);
            glVertex3f(0f, 0f, 0f);
            glVertex3f(0f, 1f, 0f);
        glEnd();
        
        // Z axis
        glColor3f(0f, 0f, 1f);
        glBegin(GL_LINES);
            glVertex3f(0f, 0f, 0f);
            glVertex3f(0f, 0f, 1f);
        glEnd();
    }
}
