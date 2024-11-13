import java.util.Scanner;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Image.PixelFormat;

public class ImageTransform {

    public static Image lighten(Image srcImage) {
        // TODO: Task 1

float [] lighten=srcImage.toFloatArray(PixelFormat.RGB);
for(int i=0;i<lighten.length;i++){
lighten[i]*=1.5;
}
return new Image((int)srcImage.getWidth(),(int)srcImage.getHeight(),lighten,PixelFormat.RGB);


    }


    public static Image greenShift(Image srcImage) {
        // Convert the image to a float array in RGB format
        float[] greenShift = srcImage.toFloatArray(PixelFormat.RGB);
    
        // Iterate through each pixel, adjusting only the green channel
        for (int i = 0; i < greenShift.length; i += 3) {
            // greenShift[i] is red, greenShift[i+1] is green, greenShift[i+2] is blue
            greenShift[i + 1] = Math.min(greenShift[i+1] + 0.25f, 1.0f); // Shift green and clamp to max 1.0
        }
    
        // Create and return the new image with the modified pixel data
        return new Image((int) srcImage.getWidth(), (int) srcImage.getHeight(), greenShift, PixelFormat.RGB);
    }


    public static Image invert(Image srcImage) {
        // TODO: Task 3

        throw new UnsupportedOperationException("Method not yet defined");
    }

    public static void main(String[] args) {
        Image srcImage = new Image("mscs-shield.png");
    
        Scanner scan = new Scanner(System.in);
        System.out.println("How would you like to transform your image?");
        System.out.println("1. Lighten");
        System.out.println("2. Green Shift");
        System.out.println("3. Invert");

        System.out.print("> ");
        int choice = scan.nextInt();

        Image transformed = switch(choice) {
            default -> srcImage; // If no matching choice, display original image
            case 1 -> lighten(srcImage);
            case 2 -> greenShift(srcImage);
            case 3 -> invert(srcImage);
        };

        CanvasWindow canvas = new CanvasWindow("img", 500, 500);
        canvas.add(transformed);
        transformed.setCenter(canvas.getCenter());

        scan.close();
    }
    
}
