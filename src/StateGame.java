import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by pigmanrocker on 23-3-17.
 */
public class StateGame implements State, ActionListener {

    private Board board;
    private CanvasPanel gamePanel;
    private ProjectileFactory projectileFactory = new ProjectileFactory();
    private MovementProvider movementProvider;
    private Player player = new Player();
    private ArrayList<Alien> aliens = new ArrayList<>();
    private ArrayList<Projectile> projectiles = new ArrayList<>();

    public StateGame(Board board){
        this.board = board;
        movementProvider = new MovementProvider(this);
        setup();
    }

    private void setup(){
        gamePanel = new CanvasPanel();
        gamePanel.setBackground(Constants.COLOR_WINDOW_BG);

        int yCoord = 25;

        for (int row = 0; row <= Constants.ALIEN_ROWS; row++) {
            int xCoord = 222;

            for (int column = 0; column <= Constants.ALIEN_COLUMNS; column++) {
                if(row == 0 || row == 1){
                    aliens.add(new Alien(xCoord, yCoord, new Toughness()));
                } else {
                    aliens.add(new Alien(xCoord, yCoord));
                }

                xCoord += 28 + Constants.NORMAL_ALIEN_WIDTH;
            }

            yCoord += 5 + Constants.NORMAL_ALIEN_HEIGHT;
        }

        projectiles.add(projectileFactory.makeProjectile(Constants.NORMAL_PROJECTILE_ID, 100,100));

        gamePanel.setScreenItems(makeScreenItems());

        Timer timer = new Timer(1000, this);
        timer.start();
    }

    public void gameOver(){
        board.setCurrentState(new StateLost());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Move movement = movementProvider.getMovementCommand(aliens);
        if(movement == null) return;
        movement.moveAliens(aliens);
        gamePanel.setScreenItems(makeScreenItems());
    }

    private ArrayList<ScreenItem> makeScreenItems(){
        ArrayList<ScreenItem> screenItems = new ArrayList<>();

        for (Alien alien : aliens){
            if(alien.draw()){
                screenItems.add((ScreenItem) alien);
            }
        }

        for (Projectile projectile : projectiles){
            if (projectile.draw()){
                screenItems.add((ScreenItem) projectile);
            }
        }

        screenItems.add(player);

        return screenItems;
    }

    public JPanel getMainPanel(){
        return gamePanel;
    }

    public class CanvasPanel extends JPanel implements Strings, Constants{

        private ArrayList<ScreenItem> screenItems;

        public CanvasPanel(){
            setPreferredSize(Constants.SCREEN_SIZE);
        }

        public void setScreenItems(ArrayList<ScreenItem> screenItems){
            this.screenItems = screenItems;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            if (screenItems != null){
                for (ScreenItem screenItem : screenItems){
                    graphics.drawImage(screenItem.getImage(), screenItem.getXCoord(), screenItem.getYCoord(), screenItem.getWidth(), screenItem.getHeight(), this);
                }
            }
        }
    }
}
