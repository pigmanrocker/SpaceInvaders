import java.awt.*;

/**
 * Created by pigmanrocker on 1-4-17.
 */
public class ToughAlien implements Alien, ScreenItem{

    private int xCoord;
    private int yCoord;
    private int health;
    private Image image;

    public ToughAlien(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.health = Constants.TOUGH_ALIEN_HEALTH;
    }

    @Override
    public int getWidth() {
        return Constants.TOUGH_ALIEN_WIDTH;
    }

    @Override
    public int getHeight() {
        return Constants.TOUGH_ALIEN_HEIGHT;
    }

    @Override
    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    @Override
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
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
    public Image getImage() {
        return image;
    }

    @Override
    public void damage(int damage) {
        health =- damage;
    }

    @Override
    public boolean draw() {
        if (health <= 0) return false;
        return true;
    }
}
