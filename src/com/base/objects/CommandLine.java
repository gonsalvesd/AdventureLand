/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.CommandState;
import com.base.framework.GameObject;
import com.base.framework.KeyInput;
import com.base.framework.ObjectId;
import com.base.window.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class CommandLine implements KeyListener{
    private CommandState cs;
    private boolean submitCommand;
    private String command;
    private ArrayList <String> commandHistory;
    private final char CURSOR = '_';
    private final char CURSOR_OFF = ' ';
    float x,y;
    public CommandLine(float x, float y) {
        this.x = x;
        this.y = y;
        cs = CommandState.Null;
        commandHistory = new ArrayList();
    }

    public void tick() {
        if (submitCommand) {
            System.out.println("now submitting command");
            commandHistory.add(command);
        }
    }

    public void render(Graphics g) {
        g.drawRect(505, 100, 300, 100);
        switch(cs) {
            case Enabled:
                g.setColor(Color.GREEN);
                g.drawRect(505, 100, 300, 20);
                g.drawString(command+CURSOR, 505, 115);
                break;
                
            case Disabled:
                g.setColor(Color.GREEN);
                g.drawRect((int) x, (int) y, 300, 20);
                g.drawString("", (int) x, (int) y);
                break;
        }
        int startPoint = 100;
        for (int i = 0; i < commandHistory.size(); i++) {
            if (i > commandHistory.size() - 5) {
                g.drawString(commandHistory.get(i), 505, startPoint);
                startPoint -= 20;
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x + 505, (int)y +100, 300, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) submitCommand = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public boolean isSubmitting() {
        return submitCommand;
    }
}
