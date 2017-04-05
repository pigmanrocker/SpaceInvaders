import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by pigmanrocker on 4-4-17.
 */
public class Player implements ScreenItem {

    private BufferedImage image;
    private int xCoord;
    private int yCoord;

    public Player(){
        image = null;

        try{
            image = ImageIO.read(new File(Constants.PLAYER_IMAGE));
        } catch (IOException e){

        }

        xCoord = 540;
        yCoord = 580;
    }

    @Override
    public boolean draw() {
        return true;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public int getXCoord() {
        return xCoord;
    }

    @Override
    public int getYCoord() {
        return yCoord;
    }

    @Override
    public int getWidth() {
        return Constants.PLAYER_WIDTH;
    }

    @Override
    public int getHeight() {
        return Constants.PLAYER_HEIGHT;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }
}
