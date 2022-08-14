/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.ConstructId;
import com.base.framework.GameObject;
import com.base.framework.ObjectId;
import com.base.framework.Texture;
import com.base.window.Gameplay;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Construct extends GameObject{

    private ConstructId cid;
    private final Texture tex = Gameplay.getInstance();
    private Rectangle bounds, bounds2, bounds3, bounds4;
    
    public Construct(float x, float y, ObjectId id, ConstructId cid) {
        super(x, y, id);
        this.cid = cid;
        this.x = x;
        this.y = y;
        bounds = new Rectangle(0,0,0,0);
        bounds2 = new Rectangle(0,0,0,0);
        bounds3 = new Rectangle(0,0,0,0);
        bounds4 = new Rectangle(0,0,0,0);
    }

    @Override
    public void tick(LinkedList <GameObject> objecvt) {
        switch(cid) {
            case SmallFloatingIsland:
                bounds = new Rectangle((int) x, (int) y, tex.constructs[0].getWidth(), tex.constructs[0].getHeight());
                break;
            case MediumFloatingIsland:
                bounds = new Rectangle((int) x, (int) y, tex.constructs[1].getWidth(), tex.constructs[1].getHeight());
                break;
            case LargeFloatingIsland:
                bounds = new Rectangle((int) x, (int) y, tex.constructs[2].getWidth(), tex.constructs[2].getHeight());
                break;
            case MediumPlatform:
                bounds = new Rectangle((int) x + 256, (int) y, 320, 10);
                bounds2 = new Rectangle((int) x + 64, (int) y + 128, 192, 10);
                bounds3 = new Rectangle((int) x + 576, (int) y + 128, 192, 10);
                bounds4 = new Rectangle((int) x, (int) y + 256, tex.constructs[4].getWidth(), 10);
                break;
            case Platform:
                bounds = new Rectangle((int) x, (int) y, tex.constructs[3].getWidth(), tex.constructs[3].getHeight());
                break;
        }
    }

    @Override
    public void render(Graphics g) {
        switch(cid) {
            case SmallFloatingIsland:
                g.drawImage(tex.constructs[0], (int) x, (int) y, null);
                break;
            case MediumFloatingIsland:
                g.drawImage(tex.constructs[1], (int) x, (int) y, null);
                break;
            case LargeFloatingIsland:
                g.drawImage(tex.constructs[2], (int) x, (int) y, null);
                break;
            case MediumPlatform:
                g.drawImage(tex.constructs[4], (int) x, (int) y, null);
                break;
            case Platform:
                g.drawImage(tex.constructs[3], (int) x, (int) y, null);
                break;
        }
        g.setColor(Color.GREEN);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.drawRect(bounds2.x, bounds2.y, bounds2.width, bounds2.height);
        g.drawRect(bounds3.x, bounds3.y, bounds3.width, bounds3.height);
        g.drawRect(bounds4.x, bounds4.y, bounds4.width, bounds4.height);
        
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setConstructId(ConstructId cid) {
        this.cid = cid;
    }
    
    public ConstructId getConstructId() {
        return cid;
    }
    

    @Override
    public Rectangle getBounds() {
        return bounds;
    }
    
    public Rectangle getBounds2() {
        return bounds2;
    }
    
    public Rectangle getBounds3() {
        return bounds3;
    }
    
    public Rectangle getBounds4() {
        return bounds4;
    }


}