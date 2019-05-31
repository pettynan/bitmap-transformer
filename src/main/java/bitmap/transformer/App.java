/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws Exception {
        String fileInput = "./image.png";

        greyScale(fileInput);

        pixelize(fileInput);

        invertColor(fileInput);

    }

    public static void greyScale(String fileInput) throws Exception {
        String fileOutput = "output_greyScale.png";

        BufferedImage image = ImageIO.read(new File(fileInput));


        Bitmap inputImage = new Bitmap(image.getHeight(), image.getWidth(), fileInput);


        for (int i = 0 ; i < inputImage.height ; i++) {
            for (int j = 0 ; j < inputImage.width ; j++) {

                int p = image.getRGB(j,i);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                int avg = (r + b + g );

                p = (a<<24) | (avg<<16) | (avg<<8) | avg;

                image.setRGB(j, i, p);
            }
        }

        System.out.println("Iterated through entire photo");

        try{
            ImageIO.write(image, "png", new File(fileOutput));
        } catch(IOException e){
            System.out.println(e);
        }
    }


    public static void pixelize(String fileInput) throws Exception {
        String fileOutput = "output_pixelize.png";

        BufferedImage image = ImageIO.read(new File(fileInput));


        Bitmap inputImage = new Bitmap(image.getHeight(), image.getWidth(), fileInput);


        for (int i = 0 ; i < inputImage.height ; i++) {
            for (int j = 0 ; j < inputImage.width ; j++) {

                int p = image.getRGB(j,i);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                r = (int) (Math.random() * r);
                g = (int) (Math.random() * g);
                b = (int) (Math.random() * b);

                p = (a<<24) | (r<<16) | (g<<8) | b;

                image.setRGB(j, i, p);
            }
        }

        System.out.println("Iterated through entire photo");

        try{
            ImageIO.write(image, "png", new File(fileOutput));
        } catch(IOException e){
            System.out.println(e);
        }
    }

    public static void invertColor(String fileInput) throws Exception {
        String fileOutput = "output_invertColor.png";

        BufferedImage image = ImageIO.read(new File(fileInput));


        Bitmap inputImage = new Bitmap(image.getHeight(), image.getWidth(), fileInput);


        for (int i = 0 ; i < inputImage.height ; i++) {
            for (int j = 0 ; j < inputImage.width ; j++) {

                int p = image.getRGB(j,i);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                p = (a<<24) | (r<<16) | (g<<8) | b;

                image.setRGB(j, i, p);
            }
        }

        System.out.println("Iterated through entire photo");

        try{
            ImageIO.write(image, "png", new File(fileOutput));
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
