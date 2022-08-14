/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.GameObject;
import com.base.framework.ObjectId;
import com.base.framework.TileId;
import com.base.framework.Texture;
import com.base.window.Gameplay;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Tile extends GameObject {

    private final TileId tid;
    private final Texture tex = Gameplay.getInstance();
    private Rectangle bounds;
    public Tile(float x, float y, ObjectId id, TileId tid) {
        super(x, y, id);
        this.tid = tid;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics g) {
        switch(tid) {
            case TopLeft:
                g.drawImage(tex.platform_top[0], (int) x, (int) y, null);
                break;
            case TopMid:
                g.drawImage(tex.platform_top[1], (int) x, (int) y, null);
                break;
            case TopRight:
                g.drawImage(tex.platform_top[2], (int) x, (int) y, null);
                break;
                
            case MidLeft:
                g.drawImage(tex.platform_mid[0], (int) x, (int) y, null);
                break;
            case MidMid:
                g.drawImage(tex.platform_mid[1], (int) x, (int) y, null);
                break;
            case MidRight:
                g.drawImage(tex.platform_mid[2], (int) x, (int) y, null);
                break;
                
            case BotLeft:
                g.drawImage(tex.platform_bot[0], (int) x, (int) y, null);
                break;
            case BotMid:
                g.drawImage(tex.platform_bot[1], (int) x, (int) y, null);
                break;
            case BotRight:
                g.drawImage(tex.platform_bot[2], (int) x, (int) y, null);
                break;
            case LeftLedge:
                g.drawImage(tex.platform_left_ledge[0], (int) x, (int) y, null);
                break;
            case LeftLedgeExt:
                g.drawImage(tex.platform_left_ledge[1], (int) x, (int) y, null);
                break;
            case RightLedge:
                g.drawImage(tex.platform_right_ledge[0], (int) x, (int) y, null);
                break;
            case RightLedgeExt:
                g.drawImage(tex.platform_right_ledge[1], (int) x, (int) y, null);
                break;
            case OceanTop:
                g.drawImage(tex.platform_ocean[0], (int) x, (int) y, null);
                break;
            case OceanFloor:
                g.drawImage(tex.platform_ocean[1], (int) x, (int) y, null);
                break;
            case FloatingLedgeLeft:
                g.drawImage(tex.platform_floating_island[0], (int) x, (int) y, null);
                break;
            case FloatingLedgeMid:
                g.drawImage(tex.platform_floating_island[1], (int) x, (int) y, null);
                break;
            case FloatingLedgeRight:
                g.drawImage(tex.platform_floating_island[2], (int) x, (int) y, null);
                break;
        }
    }

    @Override
    public Rectangle getBounds() {
        switch(tid) {
            case TopLeft:
                return new Rectangle((int) x, (int) y, 64, 15);
        
            case TopMid:
                return new Rectangle((int) x, (int) y, 64, 15);
        
            case TopRight:
                return new Rectangle((int) x, (int) y, 64, 15);
                
            case LeftLedge:
                return new Rectangle((int) x, (int) y, 64, 15);
            
            case RightLedge:
                return new Rectangle((int) x, (int) y, 64, 15);
                
            case FloatingLedgeRight:
                return new Rectangle((int) x, (int) y, 64, 15);
            
            case FloatingLedgeMid:
                return new Rectangle((int) x, (int) y, 64, 15);
            
            case FloatingLedgeLeft:
                return new Rectangle((int) x, (int) y, 64, 15);
        }   
        return new Rectangle(0, 0, 0, 0);
    }
    
}
