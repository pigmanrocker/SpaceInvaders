import java.util.ArrayList;

/**
 * Created by pigmanrocker on 5-4-17.
 */
public class MoveDown implements Move {

    @Override
    public void moveAliens(ArrayList<Alien> aliens) {
        for (Alien alien : aliens){
            alien.setYCoord(alien.getYCoord() + Constants.ALIEN_MOVEMENT_MODIFIER);
        }
    }
}
