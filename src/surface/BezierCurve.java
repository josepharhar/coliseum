package surface;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.BufferUtils.*;

public class BezierCurve {
    
    public static float[] pointsArray = new float[]{
        -4f, -4f, 0f,
        -2f, 4f, 0f,
        2f, -4f, 0f,
        4f, 4f, 0f
    };
    
    public static void init() {
        glClearColor(0f, 0f, 0f, 0f);
        glShadeModel(GL_FLAT);
        
        FloatBuffer pointsBuffer = createFloatBuffer(pointsArray.length);
        pointsBuffer.put(pointsArray);
        pointsBuffer.flip();
        
        glMap1f(GL_MAP1_VERTEX_3, 0f, 1f, 3, 4, pointsBuffer);
        glEnable(GL_MAP1_VERTEX_3);
    }
    
    public static void draw() {
        glBegin(GL_LINE_STRIP);
            for (int i = 0; i < 30; i++) {
                glEvalCoord1f((float)((float)i/30f));
            }
        glEnd();
        
        glPointSize(3);
        glBegin(GL_POINTS);
        for (int i = 0; i < pointsArray.length; i += 3) {
            glVertex3f(pointsArray[i], pointsArray[i + 1], pointsArray[i + 2]);
        }
        glEnd();
    }
}
