/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.window;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author dayne
 */
public class PixelImageLoader {
    
    private BufferedImage image;
    
    public BufferedImage loadImage(String path) {
        try {
            image = ImageIO.read(new File(path));
            
            return image;
        } catch (IOException ex) {
            Logger.getLogger(PixelImageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
