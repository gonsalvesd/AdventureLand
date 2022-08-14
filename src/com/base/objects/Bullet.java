/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.GameObject;
import com.base.framework.ObjectId;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Bullet extends GameObject {

    public Bullet(float x, float y, int vX, ObjectId id) {
        super(x, y, id);
        this.vX = vX;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        x += vX;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
    
}
