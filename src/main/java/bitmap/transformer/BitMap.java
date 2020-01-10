package bitmap.transformer;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
public class BitMap {

    public static BufferedImage bitMapReader(String path) throws IOException {
        File bmpFile = new File(path);
        BufferedImage bmpImage = ImageIO.read(bmpFile);
        return bmpImage;
    }


    public static BufferedImage changeColor(String path) throws IOException {
        final BufferedImage newImage = bitMapReader(path);

        for (int x = 0; x < 100; x++){
            for (int y = 0; y < 100; y++){
                Color thisPixelColor = new Color(newImage.getRGB(x, y));
                if (thisPixelColor.getRed() == 255 &&
                        thisPixelColor.getGreen() == 255 &&
                        thisPixelColor.getBlue() == 255) {
                    newImage.setRGB(x, y, 0);
                }
            }
        }
        return newImage;
    }


    public static void saveFile( final BufferedImage bi, final String path ){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        System.out.println("hi");
    }
}