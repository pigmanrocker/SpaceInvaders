import java.awt.image.BufferedImage;

/**
 * Created by pigmanrocker on 28-3-17.
 */
public interface ScreenItem {
    BufferedImage getImage();
    int getXCoord();
    int getYCoord();
    int getHeight();
    int getWidth();
    boolean draw();
}
