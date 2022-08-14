/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.framework;

import com.base.objects.CommandLine;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author dayne
 */
public class MouseInput extends MouseAdapter{
    private Rectangle Object;
    private int x, y, w, h;
    private CommandState cmdState;
    private CommandLine cmd;
    public MouseInput() {
        this.x = 0;
        this.y = 0;
        this.w = 0;
        this.h = 0;   
        cmd = new CommandLine(505,100);
        cmdState = CommandState.Null;
        Object = new Rectangle(this.x, this.y, this.w, this.h);
    }
    
    public void setBounds(Rectangle bounds) {
        Object = bounds;   
    }
    
    public Rectangle getBounds() {
        return Object;
    }
    
    public CommandState getCommandState() {
        return cmdState;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        Rectangle Mouse = new Rectangle(e.getX(), e.getY(), 10, 10);
        
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println(e.getX() + "," + e.getY());
            if (Mouse.intersects(Object)) {
                
                if (cmdState == CommandState.Enabled) {
                    cmdState = CommandState.Disabled;
                } else {
                    cmdState = CommandState.Enabled;
                }
                System.out.println(cmdState);
            }
        }
    }
}
