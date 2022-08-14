/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.BrickSegment;
import com.base.framework.GameObject;
import com.base.framework.ObjectId;
import com.base.framework.Texture;
import com.base.window.Animation;
import com.base.window.Gameplay;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Block extends GameObject{
    private final int[] bits = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
    Texture tex = Gameplay.getInstance();
    Animation blocks = new Animation(10, tex.blocks[0], tex.blocks[1], tex.blocks[2]);
    BrickSegment bs;
    private int type;
    public Block(float x, float y, int type, ObjectId id, BrickSegment bs) {
        super(x, y, id);
        this.type = type;
        this.bs = bs;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        switch(bs) {
            case BrickLeft:
                g.drawImage(tex.blocks[1], (int) x, (int) y, 100, 50, null);
                break;
            case BrickRight:
                g.drawImage(tex.blocks[2], (int) x, (int) y, 100, 50, null);
                break;
            case BrickMid:
                g.drawImage(tex.blocks[0], (int) x, (int) y, 100, 50, null);
                break;
        }       
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, bits[4], bits[4]);
        
    }
    
    
}
