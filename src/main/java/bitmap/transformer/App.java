/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {

        String input = args[0];
        String output = args[1];
        String method = args[2];
        BufferedImage img;

        switch (method) {
            case "flipBlackAndWhite":
                img = BitMap.flipBlackAndWhite(input);
                BitMap.saveBufferedImageAsBMP(img, output);
                break;
            case "rotate":
                img = BitMap.rotate(input);
                BitMap.saveBufferedImageAsBMP(img, output);
                break;
            case "mirror":
                img = BitMap.mirror(input);
                BitMap.saveBufferedImageAsBMP(img, output);
            default:
                System.out.println("The method provided is not supported");
        }
    }
}
