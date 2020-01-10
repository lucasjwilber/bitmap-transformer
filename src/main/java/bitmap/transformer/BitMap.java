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
    private static BufferedImage changeColor( int width, int height ) throws IOException {
        final BufferedImage newImage = bitMapReader("C:\\Users\\lwilb\\codefellows\\java-401d7\\bitmap\\bitmap-transformer\\src\\main\\resources\\mario.bmp");

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
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
    private static void savePNG( final BufferedImage bi, final String path ){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));
            //ImageIO.write(rendImage, "PNG", new File(path));
            //ImageIO.write(rendImage, "jpeg", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedImage img = changeColor( 100, 100 );
        savePNG( img, "C:\\Users\\lwilb\\codefellows\\java-401d7\\bitmap\\bitmap-transformer\\src\\main\\resources\\mario2.bmp");
    }
}