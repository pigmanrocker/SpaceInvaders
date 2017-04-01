/**
 * Created by pigmanrocker on 1-4-17.
 */
public class AlienFactory {

    public AlienFactory(){

    }

    public Alien makeAlien(int type, int xCoord, int yCoord){
        switch (type){
            case Constants.NORMAL_ALIEN_ID:
                return new NormalAlien(xCoord, yCoord);
            case Constants.TOUGH_ALIEN_ID:
                return new ToughAlien(xCoord, yCoord);
            default:
                return null;
        }
    }
}
