package opengltest;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

//This import allows calls without the GL11.
import static org.lwjgl.opengl.GL11.*;

public class Test {
    
    private int width = 800;
    private int height = 800;
    
    private float x = 0;
    private float y = 0;
    private float z = 0;
    
    private float rotation = 0;
    
    public static void main(String[] args) {
        try {
            new Test().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception {
        init();
        loop();
    }
    
    private void init() throws Exception {
        //LWJGL 2 setup
        Display.setDisplayMode(new DisplayMode(width, height));
        Display.create();
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(-20, 20, -20, 20, -20, 20);
        glMatrixMode(GL_MODELVIEW);
    }
    
    private void loop() {
        while (!Display.isCloseRequested()) {
            glLoadIdentity();
            if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                y += .001f;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                y -= .001f;
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                x += .001f;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
                x -= .001f;
            }
            draw();
        }
    }
    
    private void draw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        drawSquare();
        glTranslatef(x, y, z);
//        drawCube();
        Display.update();
    }
    
    private void drawSquare() {
        glRotatef(0.01f, 2, 1, 0);
        glColor3f(0.5f, 0.5f, 1.0f);
        glBegin(GL_QUADS);
            glVertex2f(-1, -1);
            glVertex2f(1, -1);
            glVertex2f(1, 1);
            glVertex2f(-1, 1);
        glEnd();
    }
    
    private void drawCube() {
        rotation += 0.01f;
        glRotatef(rotation, 2, 1, 0);
        
        glBegin(GL_QUADS);
            glColor3f(0.0f,1.0f,0.0f); // Set The Color To Green
            glVertex3f( 1.0f, 1.0f,-1.0f); // Top Right Of The Quad (Top)
            glVertex3f(-1.0f, 1.0f,-1.0f); // Top Left Of The Quad (Top)
            glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad (Top)
            glVertex3f( 1.0f, 1.0f, 1.0f); // Bottom Right Of The Quad (Top)
            
            glColor3f(1.0f,0.5f,0.0f); // Set The Color To Orange
            glVertex3f( 1.0f,-1.0f, 1.0f); // Top Right Of The Quad (Bottom)
            glVertex3f(-1.0f,-1.0f, 1.0f); // Top Left Of The Quad (Bottom)
            glVertex3f(-1.0f,-1.0f,-1.0f); // Bottom Left Of The Quad (Bottom)
            glVertex3f( 1.0f,-1.0f,-1.0f); // Bottom Right Of The Quad (Bottom)
            
            glColor3f(1.0f,0.0f,0.0f); // Set The Color To Red
            glVertex3f( 1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Front)
            glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Front)
            glVertex3f(-1.0f,-1.0f, 1.0f); // Bottom Left Of The Quad (Front)
            glVertex3f( 1.0f,-1.0f, 1.0f); // Bottom Right Of The Quad (Front)
            
            glColor3f(1.0f,1.0f,0.0f); // Set The Color To Yellow
            glVertex3f( 1.0f,-1.0f,-1.0f); // Bottom Left Of The Quad (Back)
            glVertex3f(-1.0f,-1.0f,-1.0f); // Bottom Right Of The Quad (Back)
            glVertex3f(-1.0f, 1.0f,-1.0f); // Top Right Of The Quad (Back)
            glVertex3f( 1.0f, 1.0f,-1.0f); // Top Left Of The Quad (Back)
            
            glColor3f(0.0f,0.0f,1.0f); // Set The Color To Blue
            glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Left)
            glVertex3f(-1.0f, 1.0f,-1.0f); // Top Left Of The Quad (Left)
            glVertex3f(-1.0f,-1.0f,-1.0f); // Bottom Left Of The Quad (Left)
            glVertex3f(-1.0f,-1.0f, 1.0f); // Bottom Right Of The Quad (Left)
            
            glColor3f(1.0f,0.0f,1.0f); // Set The Color To Violet
            glVertex3f( 1.0f, 1.0f,-1.0f); // Top Right Of The Quad (Right)
            glVertex3f( 1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Right)
            glVertex3f( 1.0f,-1.0f, 1.0f); // Bottom Left Of The Quad (Right)
            glVertex3f( 1.0f,-1.0f,-1.0f); // Bottom Right Of The Quad (Right)
        glEnd();
    }
    
}