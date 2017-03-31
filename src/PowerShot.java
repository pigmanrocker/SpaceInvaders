import java.awt.*;

/**
 * Created by pigmanrocker on 31-3-17.
 */
public class PowerShot implements Constants, ScreenItem, Projectile {

    private int xCoord;
    private int yCoord;
    private Image image;

    public PowerShot(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
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
        return Constants.POWER_PROJECTILE_DAMAGE;
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
    public Image getImage() {
        return image;
    }

    @Override
    public int getHeight() {
        return Constants.POWER_PROJECTILE_HEIGHT;
    }

    @Override
    public int getWidth() {
        return Constants.POWER_PROJECTILE_WIDTH;
    }
}
