package bitmap.transformer;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class BitMap {

    public static BufferedImage createBufferedImageFromBMP(String path) throws IOException {
        File bufferedImageFile = new File(path);
        //turn the given .bmp into a BI file
        return ImageIO.read(bufferedImageFile);
    }

    public static void saveBufferedImageAsBMP( final BufferedImage image, final String path ){
        try {
            System.out.println("Saving new .bmp image...");
            ImageIO.write(image, "bmp", new File(path));
            System.out.println("Successfully saved new .bmp image at " + path);
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public static int colorGetter(String color) {
        switch (color.toLowerCase()) {
            case "white":
                return 16777215;
            case "red":
                return 16711680;
            case "orange":
                return 16753920;
            case "yellow":
                return 16776960;
            case "green":
                return 65280;
            case "blue":
                return 255;
            case "purple":
                return 16711935;
            case "black":
                return 0;
            default:
                return -1;
        }
    }

    //transforms:
    public static BufferedImage swapWhiteWithNewColor(String path, String inputColor) throws IOException {
        BufferedImage newImage = createBufferedImageFromBMP(path);
        System.out.println("Found a .bmp image at " + path);

        int newColor = colorGetter(inputColor);
        if (newColor == -1) {
            System.out.println("The color you gave is not supported, sorry");
            return newImage;
        } else {
            System.out.println("Replacing all whiteish colors with the color " + inputColor + "...");
        }

        for (int x = 0; x < newImage.getWidth(); x++) {
            for (int y = 0; y < newImage.getHeight(); y++) {
                Color thisPixelColor = new Color(newImage.getRGB(x, y));
                if (thisPixelColor.getBlue() > 240 &&
                    thisPixelColor.getRed() > 240 &&
                    thisPixelColor.getGreen() > 240) {
                    newImage.setRGB(x, y, newColor);
                }
            }
        }
        return newImage;
    }

    //this may only work with square images
    public static BufferedImage rotate(String path) throws IOException, ArrayIndexOutOfBoundsException {
        final BufferedImage oldImage = createBufferedImageFromBMP(path);
        System.out.println("Found a .bmp image at " + path);
        System.out.println("Rotating image clockwise...");

        BufferedImage newImage = createBufferedImageFromBMP(path);
        for (int x = 0; x < oldImage.getWidth(); x++) {
            for (int y = 0; y < oldImage.getHeight(); y++) {
                int thisPixelColor = oldImage.getRGB(x, y);
                newImage.setRGB(y, oldImage.getHeight() - 1 - x, thisPixelColor);
            }
        }
        return newImage;
    }

    public static BufferedImage mirror(String path) throws IOException {
        final BufferedImage image = createBufferedImageFromBMP(path);
        System.out.println("Found a .bmp image at " + path);
        System.out.println("Mirroring image...");

        for (int x = 0; x < image.getWidth() / 2; x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int thisPixelColor = image.getRGB(x, y);
                int oppositePixelColor = image.getRGB(image.getWidth() - x - 1, y);
                image.setRGB(x, y, oppositePixelColor);
                image.setRGB(image.getWidth() - x - 1, y, thisPixelColor);
            }
        }
        return image;
    }


    public static void main(String[] args) {
        System.out.println("hi");
    }
}