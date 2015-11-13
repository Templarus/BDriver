package bdriver;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.javaocr.awt.*;
import net.sourceforge.javaocr.ocr.PixelImage;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.CharacterRange;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.OCRScanner;

public class BDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphicsDevice gd;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        gd = gs[0];
        //        for (int j = 0; j < gs.length; j++) {
//             gd= gs[j];
//            GraphicsConfiguration[] gc = gd.getConfigurations();
//        }

        Robot r;
        try {
            r = new Robot(gd);

            Rectangle rect = new Rectangle(780, 400, 375, 25);
            BufferedImage im = r.createScreenCapture(rect);
            Character c = 'a';//new Character('a');
            CharacterRange[] cr = new CharacterRange[3];

            cr[0] = new CharacterRange(65);
            cr[1] = new CharacterRange(87);
            cr[2] = new CharacterRange(83);
            cr[3] = new CharacterRange(68);

            OCRScanner ocr = new OCRScanner();
            System.out.println("Scan=" + ocr.scan(im, 100, 100, 200, 200, cr));

        } catch (AWTException ex) {
            Logger.getLogger(BDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
