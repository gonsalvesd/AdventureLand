/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.framework;

import com.base.objects.Bullet;
import com.base.window.Handler;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author dayne
 */
public class KeyInput extends KeyAdapter {
    public KeyInput(Handler handler) {
        this.handler = handler;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
        
        if (key == KeyEvent.VK_ENTER) {
            submitCommand = true;
        }
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ObjectId.Player) {
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVX(-5);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVX(5);
                }
                if (key == KeyEvent.VK_SPACE) {
                    tempObject.setJumping(true);
                    tempObject.setVY(-13);
                }
                
                if (key == KeyEvent.VK_C) {
                    if (tempObject.getFacing() == 0) {
                        tempObject.setFacing(1);
                    }
                    handler.addObject(new Bullet(tempObject.getX()+20, tempObject.getY()+50, tempObject.getFacing() * 10, ObjectId.Bullet));
                }
                
                if (key == KeyEvent.VK_V) {
                    if (tempObject.getAttackState() != null) {

                        if (tempObject.getFacing() < 0) {

                            if (tempObject.isJumping()) {
                                tempObject.setAttackState(AttackState.JumpLeft);
                                tempObject.setAttackingLeft(false);
                                tempObject.setAttackingRight(false);
                                tempObject.setJumpAttackingLeft(true);
                                tempObject.setJumpAttackingRight(false);
                            } else {
                                tempObject.setAttackState(AttackState.Left);
                                tempObject.setAttackingLeft(true);
                                tempObject.setAttackingRight(false);
                                tempObject.setJumpAttackingLeft(false);
                                tempObject.setJumpAttackingRight(false);
                            }
                        } else if (tempObject.getFacing() > 0) {
                            if (tempObject.isJumping()) {
                                tempObject.setAttackState(AttackState.JumpRight);
                                tempObject.setAttackingLeft(false);
                                tempObject.setAttackingRight(false);
                                tempObject.setJumpAttackingLeft(false);
                                tempObject.setJumpAttackingRight(true);
                            } else {
                                tempObject.setAttackState(AttackState.Right);
                                tempObject.setAttackingLeft(false);
                                tempObject.setAttackingRight(true);
                                tempObject.setJumpAttackingLeft(false);
                                tempObject.setJumpAttackingRight(false);
                            }
                        } 
                    }
                }
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_0 && !dropHP) {
            dropHP = true;
        } else if (key == KeyEvent.VK_0 && dropHP) {
            dropHP = false;
        }
        if (key == KeyEvent.VK_9 && !dropMP) {
            dropMP = true;
        } else if (key == KeyEvent.VK_9 && dropMP) {
            dropMP = false;
        }
        if (key == KeyEvent.VK_8 && !dropEXP) {
            dropEXP = true;
        } else if (key == KeyEvent.VK_8 && dropEXP) {
            dropEXP = false;
        }
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ObjectId.Player) {
                if (key == KeyEvent.VK_LEFT) tempObject.setVX(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVX(0);
            }
        }
    }
    
    public boolean isDroppingHp() {
        return dropHP;
    }
    public boolean isDroppingMp() {
        return dropMP;
    }
    public boolean isDroppingExp() {
        return dropEXP;
    }
    public boolean isSubmittingCommand() {
        return submitCommand;
    }
    
    private boolean dropHP;
    private boolean dropMP;
    private boolean dropEXP;
    private boolean submitCommand;
    private final Handler handler;
}
