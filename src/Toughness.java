import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by pigmanrocker on 4-4-17.
 */
public class Toughness {
    public Toughness(){

    }

    public int setHealth(){
        return Constants.TOUGH_ALIEN_HEALTH;
    }

    public BufferedImage setImage(){
        BufferedImage image = null;

        try{
            image = ImageIO.read(new File(Constants.TOUGH_ALIEN_IMAGE));
        } catch (IOException e){

        }

        return image;
    }
}
