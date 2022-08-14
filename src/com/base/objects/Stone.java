/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.GameObject;
import com.base.framework.ObjectId;
import com.base.framework.StoneId;
import com.base.framework.Texture;
import com.base.window.Gameplay;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Stone extends GameObject {
    private StoneId sid;
    private Texture tex = Gameplay.getInstance();
    public Stone(float x, float y, ObjectId id, StoneId sid) {
        super(x, y, id);
        this.sid = sid;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
        switch(sid) {
            case HugeStone:
                g.drawImage(tex.stones[0], (int) x, (int) y - 22, null);
                break;
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
}
