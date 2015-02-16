package surface;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;

//This import allows calls without the GL11.
import static org.lwjgl.opengl.GL11.*;

public class Runner {
    
    private int width = 800;
    private int height = 800;
    
    private float x = 0;
    private float y = 0;
    private float z = 0;

    double downx = 0.0;
    double downy = 0.0;
    boolean pressed = false;
    float diffx = 0.0f;
    float diffy = 0.0f;
    float rotation = 0.0f;
    
    public static void main(String[] args) {
        try {
            new Runner().run();
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
        DisplayMode displayMode = new DisplayMode(width, height);
        Display.setDisplayMode(displayMode);
        Display.setResizable(true);
        Display.create();
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(-5, 5, -5, 5, -5, 5);
        glMatrixMode(GL_MODELVIEW);
        
//        BezierCurve.init();
        Surface.init();
        
        Lights.init();
    }
    
    private void loop() {
        while (!Display.isCloseRequested()) {
            glLoadIdentity();
            
            //Keyboard
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
            if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
                z += .001f;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_S)){
                z -= .001f;
            }
            
            //Mouse
            if (Mouse.isButtonDown(0)) {
                if (!pressed) {
                    // Just clicked down for the first time, need to store this cursor location
                    pressed = true;
                    downx = Mouse.getX();
                    downy = Mouse.getY();
                } else {
                    // Being held down, need to update rotation relative to init location
                    diffy = (float) -(Mouse.getX() - downx);
                    diffx = (float) -(Mouse.getY() - downy);
                    
                    //total distance cursor has traveled to be used for the rotation
                    double distance = Math.sqrt(diffx * diffx + diffy * diffy);
                    //20 pixels will be 180 degrees of rotation
                    //glRotatef uses DEGREES, NOT RADIANS
                    rotation = (float) (distance / 3.0);
                }
            } else {
                pressed = false;
            }
            
            //Draw
            draw();
        }
    }
    
    private void draw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glTranslatef(x, y, z);
        
//        rotation += 0.01f;
        System.out.println("Rotation: " + rotation);
        System.out.println("diffx: " + diffx);
        System.out.println("diffy: " + diffy);
        glRotatef(rotation, diffx, -diffy, 0f);
        
        Axis.draw();
        
//        BezierCurve.draw();
        Surface.draw();
        
        Display.update();
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