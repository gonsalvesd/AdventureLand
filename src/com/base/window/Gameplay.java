    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.window;

import com.base.framework.BushId;
import com.base.framework.KeyInput;
import com.base.framework.LevelId;
import com.base.framework.MushroomId;
import com.base.framework.ObjectId;
import com.base.framework.StoneId;
import com.base.framework.Texture;
import com.base.framework.ConstructId;
import com.base.framework.TreeId;
import com.base.objects.Bush;
import com.base.objects.CommandLine;
import com.base.objects.Crate;
import com.base.objects.Mushroom;
import com.base.objects.Player;
import com.base.objects.Stone;
import com.base.objects.Construct;
import com.base.objects.Tree;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dayne
 */
public class Gameplay extends Canvas implements Runnable {
    private KeyInput input;
    private CommandLine commandLine;
    private Construct construct;
    public Gameplay() throws IOException {
    }
    
    private void init() throws IOException {
        WIDTH = getWidth();
        HEIGHT = getHeight();
        
        PixelImageLoader loader = new PixelImageLoader();
        texture = new Texture();
        level = loader.loadImage("level_one.png");
        clouds = loader.loadImage("clouds.png");
        handler = new Handler();
        camera = new Camera();
        hpW = 200;
        mpW = 200;
        expW = 200;
        scene = Scene.MENU;
        loadImageLevel(level);
        commandLine = new CommandLine(0,100);
        construct = new Construct(0, 0, ObjectId.Construct, ConstructId.Null);
        input = new KeyInput(handler);
        addKeyListener(input);
    }
    
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        try {
            this.requestFocus();
            init();
            long lastTime = System.nanoTime();
            double tickAmount = 60.0;
            double ns = 1000000000 / tickAmount;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int updates = 0;
            int frames = 0;
            while (running) {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta >= 1) {
                    tick();
                    updates++;
                    delta--;
                }
                render();
                frames++;
                
                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("FPS: " + frames + " TICKS: " + updates);
                    frames = 0;
                    updates = 0;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void tick() {
        handler.tick();
        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ObjectId.Player) {
                camera.tick(handler.object.get(i));
                commandLine.tick();
            }
        }
        if (input.isDroppingHp()) {
            hpW--;
        } else {
            hpW++;
        }
        if (hpW > 200) {
            hpW = 200;
        } else if (hpW < 0) {
            hpW = 0;
        }
        if (input.isDroppingMp()) {
            mpW--;
        } else {
            mpW++;
        }
        if (mpW > 200) {
            mpW = 200;
        } else if (mpW < 0) {
            mpW = 0;
        }
        if (input.isDroppingExp()) {
            expW--;
        } else {
            expW++;
        }
        if (expW > 200) {
            expW = 200;
        } else if (expW < 0) {
            expW = 0;
        }
        
    }
    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;
        
        int playerPanelShift = 20;
        int playerPanelWidth = 200;
        int adminPanelShift = 505;
        ///////////////////////////////////
        //           Drawings            //
        
        //g.setColor(new Color(25, 207, 207));
        g.setColor(new Color(68, 75, 255));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g2.translate(camera.getX(), camera.getY());
        
        for (int xx = 0; xx < clouds.getWidth() * 55; xx+= clouds.getWidth()){
            g.drawImage(clouds, xx*20, 140, this);
        }
        handler.render(g);
        commandLine.render(g);
        construct.render(g);
        g.setColor(Color.WHITE);
        //adminPanel
        g.drawRect((int)-camera.getX()+adminPanelShift, (int)-camera.getY()+20, 300, 100);
        //command line
        g.drawRect((int)-camera.getX()+adminPanelShift, (int)-camera.getY()+100, 300, 20);
        
        //hpPanel
        g.setColor(Color.RED);
        g.fillRect((int)-camera.getX()+playerPanelShift, (int) -camera.getY()+20, playerPanelWidth, 20);
        //manaPanel
        g.fillRect((int)-camera.getX()+playerPanelShift, (int) -camera.getY()+40, playerPanelWidth, 20);
        //expPanel
        g.fillRect((int)-camera.getX()+playerPanelShift, (int) -camera.getY()+60, playerPanelWidth, 10);
        
        //hpPanelOutline
        g.setColor(Color.WHITE);
        g.drawRect((int)-camera.getX()+playerPanelShift-1, (int) -camera.getY()+playerPanelShift-1, playerPanelWidth + 1, 20);
        //manaPanelOutline
        g.drawRect((int)-camera.getX()+playerPanelShift-1, (int) -camera.getY()+playerPanelShift*2-1, playerPanelWidth + 1, 20);
        //expPanelOutline
        g.drawRect((int)-camera.getX()+playerPanelShift-1, (int) -camera.getY()+playerPanelShift*3-1, playerPanelWidth + 1, 11);
        
        //hp
        g.setColor(Color.GREEN);
        g.fillRect((int)-camera.getX()+playerPanelShift, (int) -camera.getY()+20, hpW , 19);
        //mana
        g.setColor(Color.BLUE);
        g.fillRect((int)-camera.getX()+playerPanelShift, (int) -camera.getY()+40, mpW, 19);
        //exp
        g.setColor(Color.ORANGE);
        g.fillRect((int)-camera.getX()+playerPanelShift, (int) -camera.getY()+60, expW, 10);
        //player panel texts 
        g.setColor(Color.WHITE);
        g.drawString("HP:" + hpW + "/" + playerPanelWidth, (int) - camera.getX() + playerPanelShift + 20, (int) -(camera.getY()-35));
        g.drawString("MP:" + mpW + "/" + playerPanelWidth, (int) - camera.getX() + playerPanelShift + 20, (int) -(camera.getY()-55));
        g.drawString("EXP:" + expW + "/" + playerPanelWidth, (int) - camera.getX() + playerPanelShift + 20, (int) -(camera.getY()-69));
        g2.translate(-camera.getX(), -camera.getY());
        
        
        //                               //
        ///////////////////////////////////
        g.dispose();
        bs.show();
    }
    private void loadImageLevel(BufferedImage level) {
        int imgWidth = level.getWidth();   
        int imgHeight = level.getHeight();        
        
        //back loop
        for (int xx = 0; xx < imgWidth; xx++) {
            for (int yy = 0; yy < imgHeight; yy++) {
                int pixel = level.getRGB(xx,yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (red == 255 && green == 155 && blue == 55) handler.addObject(new Tree(xx*32, yy*32, ObjectId.Tree, TreeId.Stump));
                else if (red == 200 && green == 100 && blue == 0) handler.addObject(new Tree(xx*32, yy*32, ObjectId.Tree, TreeId.Green));
                else if (red == 200 && green == 100 && blue == 20) handler.addObject(new Tree(xx*32, yy*32, ObjectId.Tree, TreeId.LightGreen));
                
                else if (red == 155 && green == 0 && blue == 155) handler.addObject(new Stone(xx*32, yy*32, ObjectId.Stone, StoneId.HugeStone));
               
                else if (red == 75 && green == 25 && blue == 45) handler.addObject(new Crate(xx*32, yy*32, ObjectId.Crate, LevelId.One));
                else if (red == 75 && green == 45 && blue == 25) handler.addObject(new Crate(xx*32, yy*32, ObjectId.Crate, LevelId.Two));
                else if (red == 45 && green == 75 && blue == 25) handler.addObject(new Crate(xx*32, yy*32, ObjectId.Crate, LevelId.Three));
                else if (red == 45 && green == 75 && blue == 75) handler.addObject(new Crate(xx*32, yy*32, ObjectId.Crate, LevelId.Left));
                
                else if (red == 255 && green == 0 && blue == 1) handler.addObject(new Construct(xx*32, yy*32, ObjectId.Construct, ConstructId.SmallFloatingIsland));
                else if (red == 255 && green == 0 && blue == 2) handler.addObject(new Construct(xx*32, yy*32, ObjectId.Construct, ConstructId.MediumFloatingIsland));
                else if (red == 255 && green == 0 && blue == 3) handler.addObject(new Construct(xx*32, yy*32, ObjectId.Construct, ConstructId.LargeFloatingIsland));
                
                else if (red == 255 && green == 0 && blue == 4) handler.addObject(new Construct(xx*32, yy*32, ObjectId.Construct, ConstructId.Platform));
                else if (red == 255 && green == 0 && blue == 5) 
                    
                    handler.addObject(new Construct(xx*32, yy*32, ObjectId.Construct, ConstructId.MediumPlatform));
                
            }
            
        }
        for (int xx = 0; xx < imgWidth; xx++) {
            for (int yy = 0; yy < imgHeight; yy++) {
                int pixel = level.getRGB(xx,yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (red == 200 && green == 200 && blue == 200) handler.addObject(new Bush(xx*32, yy*32, ObjectId.Bush, BushId.BigGreenBush));
                else if (red == 150 && green == 150 && blue == 150) handler.addObject(new Bush(xx*32, yy*32, ObjectId.Bush, BushId.BigPaleBush));
                else if (red == 100 && green == 100 && blue == 100) handler.addObject(new Bush(xx*32, yy*32, ObjectId.Bush, BushId.SmallGreenBush));
                else if (red == 50 && green == 50 && blue == 50) handler.addObject(new Bush(xx*32, yy*32, ObjectId.Bush, BushId.SmallPaleBush));
                else if (red == 245 && green == 145 && blue == 45) handler.addObject(new Mushroom(xx*32, yy*32, ObjectId.Mushroom, MushroomId.Pink));
                else if (red == 225 && green == 125 && blue == 25) handler.addObject(new Mushroom(xx*32, yy*32, ObjectId.Mushroom, MushroomId.Red));
            }
            
        }
        
        for (int xx = 0; xx < imgWidth; xx++) {
            for (int yy = 0; yy < imgHeight; yy++) {
                int pixel = level.getRGB(xx,yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if (red == 0 && green == 0 && blue == 255) handler.addObject(new Player(xx*bits[4], yy*bits[4], 0, handler, ObjectId.Player));
               
            }
            
        }
    }
    
    public static Texture getInstance() {
        return texture;
    }
    public static int WIDTH, HEIGHT;
    private int hpW;
    private int mpW;
    private int expW;
    private boolean running;
    private Thread thread;
    private enum Scene {MENU, GAMEPLAY, GAMEOVER, OPTIONS, HELP}
    private Scene scene;
    private Handler handler;
    private Camera camera;
    private BufferedImage level;
    private BufferedImage clouds;
    private static Texture texture;
    private final int[] bits = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
}
