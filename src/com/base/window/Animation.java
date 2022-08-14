/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author dayne
 */
public class Animation {
    private final int speed;
    private final int frames;
    private boolean complete = false;
    private int index;
    private int count;
    private final BufferedImage[] images;
    private BufferedImage currentImg;
    
    public Animation(int speed, BufferedImage... args) {
        this.speed = speed;
        images = new BufferedImage[args.length];
        System.arraycopy(args, 0, images, 0, args.length);
        frames = args.length;
    }
    
    public void runAnimation() {
        index++;
        if (index > speed) {
            index = 0;
            switchFrame();
        }
    }
    
    public boolean isComplete() {
        return complete;
    }
    
    private void switchFrame() {
        for (int i = 0; i < frames; i++) {
            if (count == i) {
                currentImg = images[i];
            }
        }
        count++;
        
        if (count > frames) {
            count = 0;
        }
        
        if (count == 0) {
            complete = true;
        } else {
            complete = false;
        }
    }
    
    public void drawAnimation(Graphics g, int x, int y) {
        g.drawImage(currentImg, x, y, null);
    }
    
    public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
        g.drawImage(currentImg, x, y, scaleX, scaleY, null);
    }
    
}
