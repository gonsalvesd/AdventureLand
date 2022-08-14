/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.window;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author dayne
 */
public class Window {
    
    public Window(int width, int height, String title, Gameplay gameplay) {
        gameplay.setPreferredSize(new Dimension(width, height));
        gameplay.setMinimumSize(new Dimension(width, height));
        gameplay.setMaximumSize(new Dimension(width, height));
        JFrame frame = new JFrame(title);
        frame.add(gameplay);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        gameplay.start();
    }
    
}
