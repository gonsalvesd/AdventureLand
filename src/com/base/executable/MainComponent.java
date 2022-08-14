/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.base.executable;

import com.base.window.Gameplay;
import com.base.window.Window;
import java.io.IOException;

/**
 *
 * @author dayne
 */
public class MainComponent {
    public static final String TITLE = "Adventure Land - Alpha v0.1";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    public static void main(String[] args) throws IOException {
        Window gameWindow = new Window(WIDTH, HEIGHT, TITLE, new Gameplay());
    }
    
}
