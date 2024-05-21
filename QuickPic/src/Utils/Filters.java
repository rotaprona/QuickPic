/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;



/**
 *
 * @author Alessandro_Cofone
 */
public class Filters {
    
    public static Image applicaFiltroBiancoENero(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        
        PixelReader pixelReader = image.getPixelReader();
        WritableImage imageInBiancoENero = new WritableImage(width, height);
        PixelWriter pixelWriter = imageInBiancoENero.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);
                double avg = (color.getRed() + color.getGreen() + color.getBlue()) / 3.0;
                Color bwColor = Color.rgb((int) (255 * avg), (int) (255 * avg), (int) (255 * avg));
                pixelWriter.setColor(x, y, bwColor);
            }
        }

        return imageInBiancoENero;
    }
    
    public static Image applyVividFilter(Image inputImage) {
        int width = (int) inputImage.getWidth();
        int height = (int) inputImage.getHeight();

        WritableImage outputImage = new WritableImage(width, height);

        PixelReader pixelReader = inputImage.getPixelReader();
        PixelWriter pixelWriter = outputImage.getPixelWriter();

        // Fattore di intensità del filtro Vivido
        double intensityFactor = 1.5;

        // Applica il filtro Vivido
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);

                // Applica il filtro aumentando l'intensità dei colori
                double red = Math.min(1.0, color.getRed() * intensityFactor);
                double green = Math.min(1.0, color.getGreen() * intensityFactor);
                double blue = Math.min(1.0, color.getBlue() * intensityFactor);

                pixelWriter.setColor(x, y, Color.color(red, green, blue));
            }
        }

        return outputImage;
    }
    
    public static Image applyLoFiFilter(Image inputImage) {
        int width = (int) inputImage.getWidth();
        int height = (int) inputImage.getHeight();

        WritableImage outputImage = new WritableImage(width, height);

        PixelReader pixelReader = inputImage.getPixelReader();
        PixelWriter pixelWriter = outputImage.getPixelWriter();

        // Applica il filtro Lo-Fi
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);

                // Modifica i valori dei canali dei colori per ottenere un effetto Lo-Fi
                double red = (color.getRed() * 0.393) + (color.getGreen() * 0.769) + (color.getBlue() * 0.189);
                double green = (color.getRed() * 0.349) + (color.getGreen() * 0.686) + (color.getBlue() * 0.168);
                double blue = (color.getRed() * 0.272) + (color.getGreen() * 0.534) + (color.getBlue() * 0.131);

                // Limita i valori per assicurarti che siano compresi tra 0 e 1
                red = Math.min(1.0, Math.max(0.0, red));
                green = Math.min(1.0, Math.max(0.0, green));
                blue = Math.min(1.0, Math.max(0.0, blue));

                pixelWriter.setColor(x, y, Color.color(red, green, blue));
            }
        }

        return outputImage;
    }
    
    public static  Image applyAmaroFilter(Image inputImage) {
        int width = (int) inputImage.getWidth();
        int height = (int) inputImage.getHeight();

        WritableImage outputImage = new WritableImage(width, height);

        PixelReader pixelReader = inputImage.getPixelReader();
        PixelWriter pixelWriter = outputImage.getPixelWriter();

        // Applica il filtro Amaro
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = pixelReader.getColor(x, y);

                // Modifica i valori dei canali dei colori per ottenere un effetto Amaro
                double red = (color.getRed() * 0.9) + (color.getGreen() * 0.1) + (color.getBlue() * 0.1);
                double green = (color.getRed() * 0.1) + (color.getGreen() * 0.9) + (color.getBlue() * 0.1);
                double blue = (color.getRed() * 0.1) + (color.getGreen() * 0.1) + (color.getBlue() * 0.9);

                // Limita i valori per assicurarti che siano compresi tra 0 e 1
                red = Math.min(1.0, Math.max(0.0, red));
                green = Math.min(1.0, Math.max(0.0, green));
                blue = Math.min(1.0, Math.max(0.0, blue));

                pixelWriter.setColor(x, y, Color.color(red, green, blue));
            }
        }

        return outputImage;
    }
}
