/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.GameObject;
import com.base.framework.MushroomId;
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
public class Mushroom extends GameObject{

    private final MushroomId mid;
    private final Texture tex = Gameplay.getInstance();
    private Rectangle red, pink;
    
    public Mushroom(float x, float y, ObjectId id, MushroomId mid) {
        super(x, y, id);
        this.mid = mid;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        switch(mid) {
            case Pink:
                pink = new Rectangle((int) x, (int) y, tex.mushrooms[0].getWidth(), tex.mushrooms[0].getHeight());
                g.drawImage(tex.mushrooms[0], (int) x,  (int) y - 9, null);
                break;
            case Red:
                red = new Rectangle((int) x, (int) y, tex.mushrooms[1].getWidth(), tex.mushrooms[1].getHeight());
                g.drawImage(tex.mushrooms[1], (int) x,  (int) y - 9, null);
                break;
        }
    }

    @Override
    public Rectangle getBounds() {
        switch (mid) {
            case Pink:
                return pink;
            case Red:
                return red;
        }
        return null;
    }
    
}
