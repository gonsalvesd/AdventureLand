/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.GameObject;
import com.base.framework.ObjectId;
import com.base.framework.Texture;
import com.base.framework.TreeId;
import com.base.window.Gameplay;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Tree extends GameObject{

    private Texture tex = Gameplay.getInstance();
    private TreeId tid;
    
    private Rectangle stump;
    private Rectangle green;
    private Rectangle lightGreen;
    
    public Tree(float x, float y, ObjectId id, TreeId tid) {
        super(x, y, id);
        this.tid = tid;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
        switch (tid) {
            case Stump:
                stump = new Rectangle((int) x, (int) y - 3, tex.trees[0].getWidth(), tex.trees[0].getHeight());
                g.drawImage(tex.trees[0], (int) x, (int) y - 3, 100, 35, null);
                break;
            case Green:
                green = new Rectangle((int) x, (int) y - 269, tex.trees[1].getWidth(), tex.trees[1].getHeight());
                g.drawImage(tex.trees[1], (int) x, (int) y - 269, null);
                break;
            case LightGreen:
                lightGreen = new Rectangle((int) x, (int) y - 243, tex.trees[2].getWidth(), tex.trees[2].getHeight());
                g.drawImage(tex.trees[2], (int) x, (int) y - 243, null);
                break;
        }
    }

    @Override
    public Rectangle getBounds() {
        switch(tid) {
            case Stump:
                return stump;
            case Green:
                return green;
            case LightGreen:
                return lightGreen;
        }
        return null;
    }
    
}
