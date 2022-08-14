/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.BushId;
import com.base.framework.GameObject;
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
public class Bush extends GameObject {
    private final BushId bid;
    private final Texture tex = Gameplay.getInstance();
    
    public Bush(float x, float y, ObjectId id, BushId bid) {
        super(x, y, id);
        this.bid = bid;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
        switch(bid) {
            case BigGreenBush:
                g.drawImage(tex.bushes[0],(int) x, (int) y - 33, null);
                break;
            case BigPaleBush:
                g.drawImage(tex.bushes[1],(int) x, (int) y -33, null);
               break;
            case SmallGreenBush:
                g.drawImage(tex.bushes[2],(int) x, (int) y - 14, null);
                break;
            case SmallPaleBush:
                g.drawImage(tex.bushes[3],(int) x, (int) y - 13, null);
                break;
        }
    }

    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
