package bdriver;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.GrayFilter;
import net.sourceforge.javaocr.awt.*;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.CharacterRange;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.OCRScanner;

public class BDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BDriver bd = new BDriver();
    }

    public BDriver() {
        GraphicsDevice gd;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        gd = gs[0];
        //        for (int j = 0; j < gs.length; j++) {
//             gd= gs[j];
//            GraphicsConfiguration[] gc = gd.getConfigurations();
//        }

        Robot r;
        try
        {
            r = new Robot(gd);

            Rectangle rect = new Rectangle(780, 400, 375, 25);
            BufferedImage im = r.createScreenCapture(rect);
            File f = new File("D:\\JAVA\\javaprojects\\BDriver\\buttonsfullscreen1.JPG");
//            File f2 = new File("D:\\JAVA\\javaprojects\\BDriver\\buttonsfullscreen1GS.JPG");
//            File f3 = new File("D:\\JAVA\\javaprojects\\BDriver\\test.JPG");
//
//            CharacterRange[] cr = new CharacterRange[4];
//
//            cr[0] = new CharacterRange(65);
//            cr[1] = new CharacterRange(87);
//            cr[2] = new CharacterRange(83);
//            cr[3] = new CharacterRange(68);
//
//            OCRScanner ocr = new OCRScanner();
//            System.out.println("file data heigh=" + ImageIO.read(f).getHeight() + "  width=" + ImageIO.read(f).getWidth());
//            Image image = ImageIO.read(f);
//            ImageFilter filter = new GrayFilter(true, 25);
//            ImageProducer producer = new FilteredImageSource(image.getSource(), filter);
//            Image grayimage = Toolkit.getDefaultToolkit().createImage(producer);
//
//            ImageIO.write(getRenderedImage(grayimage), "PNG", f2);
//            if (f.canRead())
//            {
//
//                System.out.println("Scan=" + ocr.scan(ImageIO.read(f), 780, 400, 375, 25, cr));
//                //    System.out.println("Scan=" + ocr.scan(ImageIO.read(f3), 10, 10, 375, 325, cr));
//                System.out.println("Scan=" + ocr.scan(getRenderedImage(grayimage), 780, 400, 375, 25, cr));
//
//            }
//            // System.out.println("Scan=" + ocr.scan(im, 0, 0, 375, 25, cr));
            //String s = ocr2.recognize("D:\\JAVA\\javaprojects\\BDriver\\buttonsfullscreen1.JPG", -1, 780, 400, 375, 25, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
            

        } catch (AWTException ex)
        {
            Logger.getLogger(BDriver.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex)
//        {
            Logger.getLogger(BDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedImage getRenderedImage(Image in) {

        int w = in.getWidth(null);
        int h = in.getHeight(null);
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage out = new BufferedImage(w, h, type);
        Graphics2D g2 = out.createGraphics();
        g2.drawImage(in, 0, 0, null);
        g2.dispose();
        return out;
    }
}
