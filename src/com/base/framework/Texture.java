/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.framework;

import com.base.window.PixelImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author dayne
 */
public class Texture {
    SpriteSheet bs, ps;
    private BufferedImage block_sheet = null;
    public BufferedImage crate;
    
    public BufferedImage[] floating_platform = new BufferedImage[3];
    public BufferedImage[] platform_top = new BufferedImage[3];
    public BufferedImage[] platform_mid = new BufferedImage[3];
    public BufferedImage[] platform_bot = new BufferedImage[3];
    public BufferedImage[] platform_left_ledge = new BufferedImage[2];
    public BufferedImage[] platform_right_ledge = new BufferedImage[2];
    public BufferedImage[] platform_ocean = new BufferedImage[2];
    public BufferedImage[] platform_floating_island = new BufferedImage[3];
    public BufferedImage[] constructs = new BufferedImage[5];
    
    public BufferedImage[] trees = new BufferedImage[3];
    public BufferedImage[] bushes = new BufferedImage[4];
    public BufferedImage[] stones = new BufferedImage[1];
    public BufferedImage[] mushrooms = new BufferedImage[2];
    
    public BufferedImage[] player_right = new BufferedImage[10];
    public BufferedImage[] player_left = new BufferedImage[10];
    
    public BufferedImage[] player_idle_right = new BufferedImage[10];
    public BufferedImage[] player_idle_left = new BufferedImage[10];
    
    public BufferedImage[] player_jump_right = new BufferedImage[10];
    public BufferedImage[] player_jump_left = new BufferedImage[10];
    
    public BufferedImage[] player_attack_right = new BufferedImage[10];
    public BufferedImage[] player_attack_left = new BufferedImage[10];
    
    public BufferedImage[] player_jumpAttack_left = new BufferedImage[10];
    public BufferedImage[] player_jumpAttack_right = new BufferedImage[10];
    
    public BufferedImage player_start_stand;
    public BufferedImage player_start_jump;
    
    public BufferedImage[] blocks = new BufferedImage[3];
    public BufferedImage[] background = new BufferedImage[3];
    
    PixelImageLoader loader = new PixelImageLoader();
    
    public Texture() {
        
        block_sheet = loader.loadImage("block_sheet.png");
        crate = loader.loadImage("environment_objects\\crate.png");
        bs = new SpriteSheet(block_sheet);
        blockTextures();        
        backgroundTextures();
        playerTextures();
        treeTextures();
        bushTextures();
        rockTextures();
        mushroomTextures();
        platformTextures();
        constructedTextures();
    }
    
    private void constructedTextures() {
        constructs[0] = loader.loadImage("construct\\floating_island_1.png");
        constructs[1] = loader.loadImage("construct\\floating_island_2.png");
        constructs[2] = loader.loadImage("construct\\floating_island_3.png");
        constructs[3] = loader.loadImage("construct\\long_floor.png");
        constructs[4] = loader.loadImage("construct\\mountain.png");
    }
    private void platformTextures() {
        
        floating_platform[0] = loader.loadImage("tiles\\floating_top_1.png");
        floating_platform[1] = loader.loadImage("tiles\\floating_top_2.png");
        floating_platform[2] = loader.loadImage("tiles\\floating_top_3.png");
        
        platform_top[0] = loader.loadImage("tiles\\top_1.png");
        platform_top[1] = loader.loadImage("tiles\\top_2.png");
        platform_top[2] = loader.loadImage("tiles\\top_3.png");
        
        platform_mid[0] = loader.loadImage("tiles\\top_soil_1.png");
        platform_mid[1] = loader.loadImage("tiles\\top_soil_2.png");
        platform_mid[2] = loader.loadImage("tiles\\top_soil_3.png");
        
        platform_bot[0] = loader.loadImage("tiles\\bottom_soil_1.png");
        platform_bot[1] = loader.loadImage("tiles\\bottom_soil_2.png");
        platform_bot[2] = loader.loadImage("tiles\\bottom_soil_3.png");
        
        platform_left_ledge[0] = loader.loadImage("tiles\\left_ledge.png");
        platform_left_ledge[1] = loader.loadImage("tiles\\left_ledge_ext.png");
        
        platform_right_ledge[0] = loader.loadImage("tiles\\right_ledge.png");
        platform_right_ledge[1] = loader.loadImage("tiles\\right_ledge_ext.png");
        
        platform_ocean[0] = loader.loadImage("tiles\\ocean_top.png");
        platform_ocean[1] = loader.loadImage("tiles\\ocean_floor.png");
        
        platform_floating_island[0] = loader.loadImage("tiles\\floating_top_1.png");
        platform_floating_island[1] = loader.loadImage("tiles\\floating_top_2.png");
        platform_floating_island[2] = loader.loadImage("tiles\\floating_top_3.png");
    }
    
    private void mushroomTextures() {
        mushrooms[0] = loader.loadImage("environment_objects\\mushroom_1.png");
        mushrooms[1] = loader.loadImage("environment_objects\\mushroom_2.png");
    }
    private void rockTextures() {
        stones[0] = loader.loadImage("environment_objects\\stone_1.png");
    }
    
    private void treeTextures() {
        trees[0] = loader.loadImage("environment_objects\\tree_1.png");
        trees[1] = loader.loadImage("environment_objects\\tree_2.png");
        trees[2] = loader.loadImage("environment_objects\\tree_3.png");
        
        
    }
    
    private void bushTextures() {
        bushes[0] = loader.loadImage("environment_objects\\bush_1.png");
        bushes[1] = loader.loadImage("environment_objects\\bush_2.png");
        bushes[2] = loader.loadImage("environment_objects\\bush_3.png");
        bushes[3] = loader.loadImage("environment_objects\\bush_4.png");
    }
    private void backgroundTextures() {
        background[0] = loader.loadImage("clouds.png");
    }
    
    private void playerTextures() {
        //idle right
        player_idle_right[0] = loader.loadImage("player_png\\Idle_right_a.png");
        player_idle_right[1] = loader.loadImage("player_png\\Idle_right_b.png");
        player_idle_right[2] = loader.loadImage("player_png\\Idle_right_c.png");
        player_idle_right[3] = loader.loadImage("player_png\\Idle_right_d.png");
        player_idle_right[4] = loader.loadImage("player_png\\Idle_right_e.png");
        player_idle_right[5] = loader.loadImage("player_png\\Idle_right_f.png");
        player_idle_right[6] = loader.loadImage("player_png\\Idle_right_g.png");
        player_idle_right[7] = loader.loadImage("player_png\\Idle_right_h.png");
        player_idle_right[8] = loader.loadImage("player_png\\Idle_right_i.png");
        player_idle_right[9] = loader.loadImage("player_png\\Idle_right_j.png");
        
        //idle left
        player_idle_left[0] = loader.loadImage("player_png\\Idle_left_a.png");
        player_idle_left[1] = loader.loadImage("player_png\\Idle_left_b.png");
        player_idle_left[2] = loader.loadImage("player_png\\Idle_left_c.png");
        player_idle_left[3] = loader.loadImage("player_png\\Idle_left_d.png");
        player_idle_left[4] = loader.loadImage("player_png\\Idle_left_e.png");
        player_idle_left[5] = loader.loadImage("player_png\\Idle_left_f.png");
        player_idle_left[6] = loader.loadImage("player_png\\Idle_left_g.png");
        player_idle_left[7] = loader.loadImage("player_png\\Idle_left_h.png");
        player_idle_left[8] = loader.loadImage("player_png\\Idle_left_i.png");
        player_idle_left[9] = loader.loadImage("player_png\\Idle_left_j.png");
        
        //walk right
        player_right[0] = loader.loadImage("player_png\\Walk_right_a.png");
        player_right[1] = loader.loadImage("player_png\\Walk_right_b.png");
        player_right[2] = loader.loadImage("player_png\\Walk_right_c.png");
        player_right[3] = loader.loadImage("player_png\\Walk_right_d.png");
        player_right[4] = loader.loadImage("player_png\\Walk_right_e.png");
        player_right[5] = loader.loadImage("player_png\\Walk_right_f.png");
        player_right[6] = loader.loadImage("player_png\\Walk_right_g.png");
        player_right[7] = loader.loadImage("player_png\\Walk_right_h.png");
        player_right[8] = loader.loadImage("player_png\\Walk_right_i.png");
        player_right[9] = loader.loadImage("player_png\\Walk_right_j.png");
        
        //walk left
        player_left[0] = loader.loadImage("player_png\\Walk_left_a.png");
        player_left[1] = loader.loadImage("player_png\\Walk_left_b.png");
        player_left[2] = loader.loadImage("player_png\\Walk_left_c.png");
        player_left[3] = loader.loadImage("player_png\\Walk_left_d.png");
        player_left[4] = loader.loadImage("player_png\\Walk_left_e.png");
        player_left[5] = loader.loadImage("player_png\\Walk_left_f.png");
        player_left[6] = loader.loadImage("player_png\\Walk_left_g.png");
        player_left[7] = loader.loadImage("player_png\\Walk_left_h.png");
        player_left[8] = loader.loadImage("player_png\\Walk_left_i.png");
        player_left[9] = loader.loadImage("player_png\\Walk_left_j.png");
        
        //attack right
        player_attack_right[0] = loader.loadImage("player_png\\Attack_right_a.png");
        player_attack_right[1] = loader.loadImage("player_png\\Attack_right_b.png");
        player_attack_right[2] = loader.loadImage("player_png\\Attack_right_c.png");
        player_attack_right[3] = loader.loadImage("player_png\\Attack_right_d.png");
        player_attack_right[4] = loader.loadImage("player_png\\Attack_right_e.png");
        player_attack_right[5] = loader.loadImage("player_png\\Attack_right_f.png");
        player_attack_right[6] = loader.loadImage("player_png\\Attack_right_g.png");
        player_attack_right[7] = loader.loadImage("player_png\\Attack_right_h.png");
        player_attack_right[8] = loader.loadImage("player_png\\Attack_right_i.png");
        player_attack_right[9] = loader.loadImage("player_png\\Attack_right_j.png");
        
        //attack left
        player_attack_left[0] = loader.loadImage("player_png\\Attack_left_a.png");
        player_attack_left[1] = loader.loadImage("player_png\\Attack_left_b.png");
        player_attack_left[2] = loader.loadImage("player_png\\Attack_left_c.png");
        player_attack_left[3] = loader.loadImage("player_png\\Attack_left_d.png");
        player_attack_left[4] = loader.loadImage("player_png\\Attack_left_e.png");
        player_attack_left[5] = loader.loadImage("player_png\\Attack_left_f.png");
        player_attack_left[6] = loader.loadImage("player_png\\Attack_left_g.png");
        player_attack_left[7] = loader.loadImage("player_png\\Attack_left_h.png");
        player_attack_left[8] = loader.loadImage("player_png\\Attack_left_i.png");
        player_attack_left[9] = loader.loadImage("player_png\\Attack_left_j.png");
        
        //jump attack right
        player_jumpAttack_right[0] = loader.loadImage("player_png\\JumpAttack_right_a.png");
        player_jumpAttack_right[1] = loader.loadImage("player_png\\JumpAttack_right_b.png");
        player_jumpAttack_right[2] = loader.loadImage("player_png\\JumpAttack_right_c.png");
        player_jumpAttack_right[3] = loader.loadImage("player_png\\JumpAttack_right_d.png");
        player_jumpAttack_right[4] = loader.loadImage("player_png\\JumpAttack_right_e.png");
        player_jumpAttack_right[5] = loader.loadImage("player_png\\JumpAttack_right_f.png");
        player_jumpAttack_right[6] = loader.loadImage("player_png\\JumpAttack_right_g.png");
        player_jumpAttack_right[7] = loader.loadImage("player_png\\JumpAttack_right_h.png");
        player_jumpAttack_right[8] = loader.loadImage("player_png\\JumpAttack_right_i.png");
        player_jumpAttack_right[9] = loader.loadImage("player_png\\JumpAttack_right_j.png");
        
        //jump attack left
        player_jumpAttack_left[0] = loader.loadImage("player_png\\JumpAttack_left_a.png");
        player_jumpAttack_left[1] = loader.loadImage("player_png\\JumpAttack_left_b.png");
        player_jumpAttack_left[2] = loader.loadImage("player_png\\JumpAttack_left_c.png");
        player_jumpAttack_left[3] = loader.loadImage("player_png\\JumpAttack_left_d.png");
        player_jumpAttack_left[4] = loader.loadImage("player_png\\JumpAttack_left_e.png");
        player_jumpAttack_left[5] = loader.loadImage("player_png\\JumpAttack_left_f.png");
        player_jumpAttack_left[6] = loader.loadImage("player_png\\JumpAttack_left_g.png");
        player_jumpAttack_left[7] = loader.loadImage("player_png\\JumpAttack_left_h.png");
        player_jumpAttack_left[8] = loader.loadImage("player_png\\JumpAttack_left_i.png");
        player_jumpAttack_left[9] = loader.loadImage("player_png\\JumpAttack_left_j.png");

        //jump right
        player_jump_right[0] = loader.loadImage("player_png\\Jump_right_a.png");
        player_jump_right[1] = loader.loadImage("player_png\\Jump_right_b.png");
        player_jump_right[2] = loader.loadImage("player_png\\Jump_right_c.png");
        player_jump_right[3] = loader.loadImage("player_png\\Jump_right_d.png");
        player_jump_right[4] = loader.loadImage("player_png\\Jump_right_e.png");
        player_jump_right[5] = loader.loadImage("player_png\\Jump_right_f.png");
        player_jump_right[6] = loader.loadImage("player_png\\Jump_right_g.png");
        player_jump_right[7] = loader.loadImage("player_png\\Jump_right_h.png");
        player_jump_right[8] = loader.loadImage("player_png\\Jump_right_i.png");
        player_jump_right[9] = loader.loadImage("player_png\\Jump_right_j.png");
        
        //jump left
        player_jump_left[0] = loader.loadImage("player_png\\Jump_left_a.png");
        player_jump_left[1] = loader.loadImage("player_png\\Jump_left_b.png");
        player_jump_left[2] = loader.loadImage("player_png\\Jump_left_c.png");
        player_jump_left[3] = loader.loadImage("player_png\\Jump_left_d.png");
        player_jump_left[4] = loader.loadImage("player_png\\Jump_left_e.png");
        player_jump_left[5] = loader.loadImage("player_png\\Jump_left_f.png");
        player_jump_left[6] = loader.loadImage("player_png\\Jump_left_g.png");
        player_jump_left[7] = loader.loadImage("player_png\\Jump_left_h.png");
        player_jump_left[8] = loader.loadImage("player_png\\Jump_left_i.png");
        player_jump_left[9] = loader.loadImage("player_png\\Jump_left_j.png");
    }
    
    
    private void blockTextures() {
        blocks[0] = bs.grabImage(1, 1, 32, 32);
        blocks[1] = bs.grabImage(1, 2, 32, 32);
        blocks[2] = bs.grabImage(1, 3, 32, 32);
    }
}