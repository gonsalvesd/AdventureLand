/*
 * To change this license header, choose Lice                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  nse Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.window;

import com.base.framework.GameObject;

/**
 *
 * @author dayne
 */
public class Camera {
    public Camera() {
        this.x = 0;
        this.y = 0;
    }
    public void setX(float x) {
        this.x = x;
    }
    
    public void setY(float y) {
        this.y = y;
    }
    
    public void tick(GameObject player) {
        setX(-player.getX() + 150);
        setY(-player.getY() + 350);
    } 

    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    private float x,y;
    
}
