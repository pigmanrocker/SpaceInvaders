import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by pigmanrocker on 1-4-17.
 */
public class Alien implements ScreenItem {

    private int xCoord;
    private int yCoord;
    private int health;
    private BufferedImage image;
    private Toughness toughness;

    public Alien(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        setHealth();
        setImage();
    }

    public Alien(int xCoord, int yCoord, Toughness toughness){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.toughness = toughness;
        setHealth();
        setImage();
    }

    @Override
    public int getWidth() {
        return Constants.NORMAL_ALIEN_WIDTH;
    }

    @Override
    public int getHeight() {
        return Constants.NORMAL_ALIEN_HEIGHT;
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
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public boolean draw() {
        return (health > 0);
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void damage(int damage) {
        health =- damage;
    }

    private void setHealth(){
        if (toughness != null){
            health = toughness.setHealth();
        } else {
            health = Constants.NORMAL_ALIEN_HEALTH;
        }
    }

    private void setImage(){
        if (toughness != null){
            image = toughness.setImage();
        } else {
            try{
                image = ImageIO.read(new File(Constants.NORMAL_ALIEN_IMAGE));
            } catch (IOException e){

            }
        }
    }
}
