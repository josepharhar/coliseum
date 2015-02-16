package gui;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GUI implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public void run() {
        try {
            init();
            loop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception {
        // LWJGL 2 setup
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
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

            } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {

            }
            if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {

            } else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)){

            }
            draw();
        }
    }
    
    private void draw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        
        Display.update();
    }

}
