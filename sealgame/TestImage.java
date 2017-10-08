package sealgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TestImage extends Component {

    private BufferedImage img;

    public TestImage(){
        img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < img.getWidth(); x++){
            for (int y = 0; y < img.getHeight(); y++){

                int a = 255;
                int r = (int)(Math.random() * 255);
                int g = (int)(Math.random() * 255);
                int b = (int)(Math.random() * 255);

                int argb = (a << 24) | (r << 16) | (g << 8) | b;

                img.setRGB(x, y, argb);
            }
        }
    }

    public void paint(Graphics g){
        Rectangle rect = g.getClipBounds();
        g.drawImage(img, 0, 0, rect.width, rect.height,
                0, 0, img.getWidth(), img.getHeight(), null);
    }

    @Override
    public Dimension getPreferredSize() {
        if (img == null){
            return new Dimension(100, 100);
        } else {
            return new Dimension(img.getWidth(), img.getHeight());
        }
    }
}
