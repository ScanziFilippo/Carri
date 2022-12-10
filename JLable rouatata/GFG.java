import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class GFG {
    public static BufferedImage rotate(BufferedImage img)
    {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        Graphics2D g2 = newImage.createGraphics();
        g2.rotate(Math.toRadians(90), width / 2, height / 2);
        g2.drawImage(img, null, 0, 0);
        return newImage;
    }
 
    public static void main(String[] args)
    {
        try {
            BufferedImage originalImg = ImageIO.read(new File());//qui va il percorso dell'immagine
            System.out.println("Original Image Dimension: " + originalImg.getWidth() + "x" + originalImg.getHeight());
            BufferedImage SubImg = rotate(originalImg);
            System.out.println("Cropped Image Dimension: "+ SubImg.getWidth() + "x" + SubImg.getHeight());
            File outputfile= new File("D:/test/ImageRotated.jpeg");
            ImageIO.write(SubImg, "jpg", outputfile);
            System.out.println("Image rotated successfully: "+ outputfile.getPath());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
