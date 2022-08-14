/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author dayne
 */
public abstract class GameObject {
    protected float x, y;
    protected ObjectId id;
    protected float vX, vY; //velosity
    protected int facing;
    protected boolean dropping = false;
    protected boolean jumping = false;
    protected boolean attackingLeft = false;
    protected boolean attackingRight = false;
    protected boolean jumpAttackingLeft = false;
    protected boolean jumpAttackingRight = false;
    protected AttackState as;

    public GameObject(float x, float y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public void setX(float x) {
        this.x = x;
    }
    public void setVX(float vX) {
        this.vX = vX;
    }
    public void setY(float y) {
        this.y = y;
    }

    public void setVY(float vY) {
        this.vY = vY;
    }
    
    public float getX() {
        return x;
    }
    public float getVX() {
        return vX;
    }
    public float getY() {
        return y;
    }
    public float getVY() {
        return vY;
    }
    
    public void setDropping(boolean dropping) {
        this.dropping = dropping;
    }
    
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
    
    public void setAttackingRight(boolean attackingRight) {
        this.attackingRight = attackingRight;
    }
    
    public void setAttackingLeft(boolean attackingLeft) {
        this.attackingLeft = attackingLeft;
    }
    
    public void setJumpAttackingRight(boolean jumpAttackingRight) {
        this.jumpAttackingRight = jumpAttackingRight;
    }
    
    public void setJumpAttackingLeft(boolean jumpAttackingLeft) {
        this.jumpAttackingLeft = jumpAttackingLeft;
    }
    
    public void setAttackState(AttackState as) {
        this.as = as;
    }
    
    public boolean isDropping() {
        return dropping;
    }
    
    public boolean isJumping() {
        return jumping;
    }
    
    public boolean isAttackingRight() {
        return attackingRight;
    }
    
    public boolean isAttackingLeft() {
        return attackingLeft;
    }
    
    public boolean isJumpAttackingRight() {
        return jumpAttackingRight;
    }
    
    public boolean isJumpAttackingLeft() {
        return jumpAttackingLeft;
    }
    
    public ObjectId getId() {
        return id;
    }
    
    public void setFacing(int facing) {
        this.facing = facing;
    }
    
    public int getFacing() {
        return facing;
    }
    
    public AttackState getAttackState() {
        return as;
    }
}
