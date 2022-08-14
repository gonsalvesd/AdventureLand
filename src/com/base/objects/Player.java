/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.objects;

import com.base.framework.AttackState;
import com.base.framework.GameObject;
import com.base.framework.ObjectId;
import com.base.framework.Texture;
import com.base.window.Animation;
import com.base.window.Gameplay;
import com.base.window.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public class Player extends GameObject 
{
    private final int[] bits = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
    private final float width = bits[5];
    private final float height = bits[5] + bits[4];
    private final float gravity = 0.5f;
    private final float MAX_SPEED = 10;
    private final Handler handler;
    private final int type;
    private Rectangle[] bounds;
    Texture tex = Gameplay.getInstance();
    private final Animation playerWalkRight;
    private final Animation playerWalkLeft;
    private final Animation playerIdleRight;
    private final Animation playerIdleLeft;
    private final Animation playerJumpRight;
    private final Animation playerJumpLeft;
    private final Animation playerAttackRight;
    private final Animation playerAttackLeft;
    private final Animation playerJumpAttackRight;
    private final Animation playerJumpAttackLeft;
    
    public Player(float x, float y, int type, Handler handler, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
        this.type = type;
        facing = 1;
        playerIdleRight = new Animation(2, tex.player_idle_right[0], tex.player_idle_right[1], tex.player_idle_right[2], tex.player_idle_right[3], tex.player_idle_right[4], 
                tex.player_idle_right[5], tex.player_idle_right[6], tex.player_idle_right[7], tex.player_idle_right[8], tex.player_idle_right[9]
        );
        
        playerIdleLeft = new Animation(2, tex.player_idle_left[0], tex.player_idle_left[1], tex.player_idle_left[2], tex.player_idle_left[3], tex.player_idle_left[4], 
                tex.player_idle_left[5], tex.player_idle_left[6], tex.player_idle_left[7], tex.player_idle_left[8], tex.player_idle_left[9]
        );
        
        playerWalkRight = new Animation(2,tex.player_right[0],tex.player_right[1], tex.player_right[2], tex.player_right[3], tex.player_right[4], 
                tex.player_right[5], tex.player_right[6], tex.player_right[7], tex.player_right[8], tex.player_right[9]
        );
        
        playerWalkLeft = new Animation(2, tex.player_left[0], tex.player_left[1], tex.player_left[2], tex.player_left[3], tex.player_left[4], 
                tex.player_left[5], tex.player_left[6], tex.player_left[7], tex.player_left[8], tex.player_left[9]
        );
         
        playerJumpRight = new Animation(2, tex.player_jump_right[0], tex.player_jump_right[1], tex.player_jump_right[2], tex.player_jump_right[3], tex.player_jump_right[4],
        tex.player_jump_right[6], tex.player_jump_right[7], tex.player_jump_right[8], tex.player_jump_right[9]
        );
        
        playerJumpLeft = new Animation(2, tex.player_jump_left[0], tex.player_jump_left[1], tex.player_jump_left[2], tex.player_jump_left[3], tex.player_jump_left[4],
        tex.player_jump_left[5], tex.player_jump_left[6], tex.player_jump_left[7], tex.player_jump_left[8], tex.player_jump_left[9]
        );
        
        playerAttackRight = new Animation(2, tex.player_attack_right[0], tex.player_attack_right[1], tex.player_attack_right[2], tex.player_attack_right[3], tex.player_attack_right[4],
        tex.player_attack_right[5], tex.player_attack_right[6], tex.player_attack_right[7], tex.player_attack_right[8], tex.player_attack_right[9]
        );
        
        playerAttackLeft = new Animation(2, tex.player_attack_left[0], tex.player_attack_left[1], tex.player_attack_left[2], tex.player_attack_left[3], tex.player_attack_left[4],
        tex.player_attack_left[5], tex.player_attack_left[6], tex.player_attack_left[7], tex.player_attack_left[8], tex.player_attack_left[9]
        );
        
        playerJumpAttackRight = new Animation(2, tex.player_jumpAttack_right[0], tex.player_jumpAttack_right[1], tex.player_jumpAttack_right[2], tex.player_jumpAttack_right[3], tex.player_jumpAttack_right[4],
        tex.player_jumpAttack_right[5], tex.player_jumpAttack_right[6], tex.player_jumpAttack_right[7], tex.player_jumpAttack_right[8], tex.player_jumpAttack_right[9]
        );
        
        playerJumpAttackLeft = new Animation(2, tex.player_jumpAttack_left[0], tex.player_jumpAttack_left[1], tex.player_jumpAttack_left[2], tex.player_jumpAttack_left[3], tex.player_jumpAttack_left[4],
        tex.player_jumpAttack_left[5], tex.player_jumpAttack_left[6], tex.player_jumpAttack_left[7], tex.player_jumpAttack_left[8], tex.player_jumpAttack_left[9]
        );
        
        //playerRunLeft;
        //playerRunRight;
        
    }
    
    public void boundsIntake(Rectangle...args) {
        bounds = new Rectangle[args.length];
        System.arraycopy(args, 0, bounds, 0, args.length);
    }
    
    private void collisionDetection(LinkedList<GameObject> object) {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ObjectId.Construct) {
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    if (!jumping) {
                        //y = tempObject.getY() + 15;
                        //vY = 0;
                    }
                }
                if (getBounds().intersects(tempObject.getBounds())) {
                    y = tempObject.getY() - height;
                    vY = 0;
                    dropping = false;
                    jumping = false;
                } else if (!getBounds().intersects(tempObject.getBounds())) {
                    dropping = true;
                }
                if (getBoundsRight().intersects(tempObject.getBounds())) {
                    if (!jumping) {
                        x = tempObject.getX() - width;
                    }
                }
                if (getBoundsLeft().intersects(tempObject.getBounds())) {
                    if (!jumping) {
                        x = tempObject.getX() + bits[6];
                    }
                }
                
               
            }
        }
    }
    @Override
    public void tick(LinkedList<GameObject> object) {
        x+= vX;
        y+= vY;
        
        if (vX > 0) facing = 1;
        else if (vX < 0) facing = -1;
        if (as == null) {
            as = AttackState.Null;
        }
        playerIdleRight.runAnimation();
        playerIdleLeft.runAnimation();
        playerWalkRight.runAnimation();
        playerWalkLeft.runAnimation();
        playerJumpRight.runAnimation();
        playerJumpLeft.runAnimation();
        playerAttackRight.runAnimation();
        playerAttackLeft.runAnimation();
        playerJumpAttackRight.runAnimation();
        playerJumpAttackLeft.runAnimation();
        
        switch (as) {
            case Right:
                if (playerAttackRight.isComplete()) {
                    attackingRight = false;
                }
                break;
            case Left:
                if (playerAttackLeft.isComplete()) {
                    attackingLeft = false;
                }
                break;
                
            case JumpRight:
                if (playerJumpAttackRight.isComplete()) {
                    jumpAttackingRight = false;
                }
                break;
                
            case JumpLeft:
                if (playerJumpAttackLeft.isComplete()) {
                    jumpAttackingLeft = false;
                }
                break;
        }
        
        if (dropping || jumping) {
            vY += gravity;
            if (vY > MAX_SPEED) vY = MAX_SPEED;
        }
        collisionDetection(object);
    }

    @Override
    public void render(Graphics g) {
        g.drawString(x+","+y,25 ,25);
        if(vX != 0) {
            
            if (getFacing() > 0) {
                
                if (isJumping()) {
                    
                    if (isJumpAttackingRight()) {
                        playerAttackRight.drawAnimation(g, (int) x, (int) y - 20);
                    } else {
                        playerJumpRight.drawAnimation(g, (int) x, (int) y - 20);
                    }
                    
                } else {
               
                    if (isAttackingRight()) {
                        playerJumpAttackRight.drawAnimation(g, (int) x, (int) y - 20);
                    } else {
                        playerWalkRight.drawAnimation(g, (int) x, (int) y - 20);
                    }
                }
                
            } else if (getFacing() < 0) {
                
                if (isJumping()) {
                    
                    if (isJumpAttackingLeft()) {
                        playerAttackLeft.drawAnimation(g, (int) x, (int) y - 20);
                    } else {
                        playerJumpLeft.drawAnimation(g, (int) x, (int) y - 20);
                    }
                    
                } else {
                    
                    if (isAttackingLeft()) {
                        playerJumpAttackLeft.drawAnimation(g, (int) x, (int) y - 20);
                    } else {
                        playerWalkLeft.drawAnimation(g, (int) x, (int) y - 20);
                    }
                    
                }
            }
            
        } else {
            
            if (getFacing() > 0) {
                
                if (isJumping()) {
                    
                    if (isJumpAttackingRight()) {
                        playerAttackRight.drawAnimation(g, (int) x, (int) y - 20);
                    } else {
                        playerJumpRight.drawAnimation(g, (int) x, (int) y - 20);
                    }
                    
                } else if (!isJumping()) {
                
                    if (isAttackingRight()) {
                        playerAttackRight.drawAnimation(g, (int) x, (int) y - 20); //draw player attack
                    } else { // else if not attacking
                        playerIdleRight.drawAnimation(g, (int) x, (int) y - 20 ); // draw idle animation
                    }
                }
                
            } else if (getFacing() < 0) { //if facing left
                
                if (isJumping()) { // if player jumps
                    
                    if (isJumpAttackingLeft()) { // if player is attacking
                        playerAttackLeft.drawAnimation(g, (int) x, (int) y - 20); //draw air attack animation
                    } else { // else if not attacking
                        playerJumpLeft.drawAnimation(g, (int) x, (int) y - 20); // draw jump animation
                    }
                    
                } else if (!isJumping()) { // else if player didnt jump
                    
                    if (isAttackingLeft()) { //if player is attacking
                        playerAttackLeft.drawAnimation(g, (int) x, (int) y - 20); //draw ground attack animation
                    } else { // else if not attacking
                        playerIdleLeft.drawAnimation(g, (int) x, (int) y - 20); // draw idle animation
                    }
                    
                }
            } 
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) ((int) y + (height / 2)), (int) width / 2, (int) height / 2);
    }
    
    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) y, (int) width / 2, (int) height / 2);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int) x + width - 5), (int) y + 5, (int) 5, (int) height - 10);
    }
    
    
}
