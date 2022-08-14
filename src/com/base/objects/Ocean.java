/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.GameObject;
import com.base.framework.ObjectId;
import com.base.framework.Texture;
import com.base.framework.TileId;
import com.base.window.Gameplay;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Ocean extends GameObject{

    private final TileId tid;
    private final Texture tex = Gameplay.getInstance();
    public Ocean(float x, float y, ObjectId id, TileId tid) {
        super(x, y, id);
        this.tid = tid;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
        switch (tid) {
            
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
}
