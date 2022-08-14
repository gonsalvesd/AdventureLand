/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.GameObject;
import com.base.framework.LevelId;
import com.base.framework.ObjectId;
import com.base.framework.Texture;
import com.base.window.Gameplay;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Crate extends GameObject{

    private Rectangle crate;
    private final Texture tex = Gameplay.getInstance();
    private final LevelId lid;
    
    public Crate(float x, float y, ObjectId id, LevelId lid) {
        super(x, y, id);
        this.lid = lid;
    }
    
    //public Crate(float x, float y, ObjectId id)

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
        switch(lid) {
            case One:
                crate = new Rectangle ((int) x, (int) y - 45, tex.crate.getWidth(), tex.crate.getHeight()); 
                g.drawImage(tex.crate, (int) x, (int) y - 45, null);
                break;
            case Two:
                crate = new Rectangle ((int) x, (int) y - 89, tex.crate.getWidth(), tex.crate.getHeight()); 
                g.drawImage(tex.crate, (int) x, (int) y - 89, null);
                System.out.println((y-89)-(y-45));
                break;
            case Three:
                crate = new Rectangle ((int) x, (int) y - 133, tex.crate.getWidth(), tex.crate.getHeight()); 
                g.drawImage(tex.crate, (int) x, (int) y - 133, null);
                break;
            case Left:
                crate = new Rectangle((int) x - 44, (int) y - 45, tex.crate.getWidth(), tex.crate.getHeight());
                g.drawImage(tex.crate, (int) x - 44, (int) y - 45, null);
                break;
        }
    }
        

    @Override
    public Rectangle getBounds() {
        return crate;
    }
    
}
