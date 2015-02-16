package surface;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.BufferUtils.*;

public class Lights {
    public static void init() {
        
        FloatBuffer ambient = createFloatBuffer(4).put(
                new float[] { 0.2f, 0.2f, 0.2f, 1.0f });
        ambient.flip();
        FloatBuffer position = createFloatBuffer(4).put(
                new float[] { 0.0f, 0.0f, 2.0f, 1.0f });
        position.flip();
        FloatBuffer mat_diffuse = createFloatBuffer(4).put(
                new float[] { 0.6f, 0.6f, 0.6f, 1.0f });
        mat_diffuse.flip();
        FloatBuffer mat_specular = createFloatBuffer(4).put(
                new float[] { 1.0f, 1.0f, 1.0f, 1.0f });
        mat_specular.flip();
        FloatBuffer mat_shininess = createFloatBuffer(4).put(
                new float[] { 50.0f, 0, 0, 0 });
        mat_shininess.flip();

        glEnable(GL_LIGHTING);
        glEnable(GL_LIGHT0);

        glLight(GL_LIGHT0, GL_AMBIENT, ambient);
        glLight(GL_LIGHT0, GL_POSITION, position);

        glMaterial(GL_FRONT, GL_DIFFUSE, mat_diffuse);
        glMaterial(GL_FRONT, GL_SPECULAR, mat_specular);
        glMaterial(GL_FRONT, GL_SHININESS, mat_shininess);
    }
}
