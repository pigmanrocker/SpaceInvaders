import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by pigmanrocker on 31-3-17.
 */
public class NormalShot implements Constants, ScreenItem, Projectile {

    private int xCoord;
    private int yCoord;
    private BufferedImage image;
    private boolean draw = true;

    public NormalShot(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;

        try{
            image = ImageIO.read(new File(Constants.NORMAL_PROJECTILE_IMAGE));
        } catch (IOException e){

        }
    }

    @Override
    public boolean draw() {
        return draw;
    }

    @Override
    public void setDraw(boolean draw) {
        this.draw = draw;
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
    public int getDamage() {
        return Constants.NORMAL_PROJECTILE_DAMAGE;
    }

    @Override
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    @Override
    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public int getHeight() {
        return Constants.NORMAL_PROJECTILE_HEIGHT;
    }

    @Override
    public int getWidth() {
        return Constants.NORMAL_PROJECTILE_WIDTH;
    }
}
