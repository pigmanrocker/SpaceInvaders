import java.util.ArrayList;

/**
 * Created by pigmanrocker on 5-4-17.
 */
public class MovementProvider {

    private int direction;
    private int previousDirection;
    private MoveDown moveDown = new MoveDown();
    private MoveLeft moveLeft = new MoveLeft();
    private MoveRight moveRight = new MoveRight();
    private StateGame stateGame;

    public MovementProvider(StateGame stateGame){
        this.stateGame = stateGame;
        direction = Constants.DIRECTION_LEFT;
    }

    public Move getMovementCommand(ArrayList<Alien> aliens){
        if(direction == Constants.DIRECTION_LEFT){
            boolean wallHit = false;

            for (Alien alien : aliens){
                if((alien.getXCoord() - Constants.ALIEN_MOVEMENT_MODIFIER) < 100){
                    wallHit = true;
                }
            }

            if(wallHit){
                direction = Constants.DIRECTION_DOWN;
                previousDirection = Constants.DIRECTION_LEFT;
                return moveDown;
            } else {
                return moveLeft;
            }

        } else if(direction == Constants.DIRECTION_RIGHT){
            boolean wallHit = false;

            for (Alien alien : aliens){
                if((alien.getXCoord() + Constants.ALIEN_MOVEMENT_MODIFIER + Constants.NORMAL_ALIEN_WIDTH) > 1180){
                    wallHit = true;
                }
            }

            if(wallHit){
                direction = Constants.DIRECTION_DOWN;
                previousDirection = Constants.DIRECTION_RIGHT;
                return moveDown;
            } else {
                return moveRight;
            }

        } else if(direction == Constants.DIRECTION_DOWN){
            boolean gameOver = false;
            for (Alien alien : aliens){
                if((alien.getYCoord() + Constants.ALIEN_MOVEMENT_MODIFIER) > 550){
                    gameOver = true;
                }
            }

            if (gameOver){
                stateGame.gameOver();
            } else {
                if (previousDirection == Constants.DIRECTION_RIGHT){
                    direction = Constants.DIRECTION_LEFT;
                    previousDirection = Constants.DIRECTION_DOWN;
                } else if(previousDirection == Constants.DIRECTION_LEFT){
                    direction = Constants.DIRECTION_RIGHT;
                    previousDirection = Constants.DIRECTION_DOWN;
                }

                return moveDown;
            }
        }
        return null;
    }
}
