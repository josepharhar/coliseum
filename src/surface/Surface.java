package surface;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.BufferUtils.*;

public class Surface {
    
    public static float[] pointsArray = new float[]{
        -1.5f, -1.5f, 4f, -0.5f, -1.5f, 2f,
        0.5f, -1.5f, -1f, 1.5f, -1.5f, 2f,
        -1.5f, -.5f, 1f, -.5f, -.5f, 3f,
        .5f, -.5f, 0f, 1.5f, -.5f, -1f,
        -1.5f, .5f, 4f, -.5f, .5f, 0f,
        0.5f, 0.5f, 3.0f, 1.5f, 0.5f, 4.0f,
        -1.5f, 1.5f, -2f, -0.5f, 1.5f, -2f,
        0.5f, 1.5f, 0f, 1.5f, 1.5f, -1f
    };
    
    public static void init() {
        glClearColor(0f, 0f, 0f, 0f);
        
        FloatBuffer pointsBuffer = createFloatBuffer(pointsArray.length);
        pointsBuffer.put(pointsArray);
        pointsBuffer.flip();
        
        glMap2f(GL_MAP2_VERTEX_3, 0f, 1f, 3, 4, 0, 1f, 12, 4, pointsBuffer);
        glEnable(GL_MAP2_VERTEX_3);
        glMapGrid2f(20, 0, 1, 20, 0, 1);
        glEnable(GL_DEPTH_TEST);
        glShadeModel(GL_FLAT);
    }
    
    public static void draw() {
        glColor3f(1f, 1f, 1f);
        glPushMatrix();
            glEvalMesh2(GL_FILL, 0, 20, 0, 20);
//            glRotatef(85f, 1f, 1f, 1f);
//            for (int i = 0; i < 8; i++) {
//                glBegin(GL_LINE_STRIP);
//                    for (int j = 0; j <= 30; j++) {
//                        glEvalCoord2f((float)j/30.0f, (float)i/8.0f);
//                    }
//                glEnd();
//                glBegin(GL_LINE_STRIP);
//                    for (int j = 0; j <= 30; j++) {
//                        glEvalCoord2f((float)i/8.0f, (float)j/30.0f);
//                    }
//                glEnd();
//            }
        glPopMatrix();
    }
}
