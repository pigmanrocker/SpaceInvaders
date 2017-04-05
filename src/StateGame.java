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
    private Timer timer;
    private Timer projectilesUpdate;
    private int times = 0;
    private int playerDirection = Constants.DIRECTION_LEFT;

    public StateGame(Board board){
        this.board = board;
        movementProvider = new MovementProvider(this);
        setup();
    }

    private void setup(){
        gamePanel = new CanvasPanel();
        gamePanel.setBackground(Constants.COLOR_WINDOW_BG);

        //creating aliens
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

        gamePanel.setScreenItems(makeScreenItems());

        timer = new Timer(1000, this);
        timer.start();

        projectilesUpdate = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (Projectile projectile : projectiles) {
                    if (projectile.draw()) {
                        for (Alien alien : aliens) {
                            if (alien.draw()) {
                                if (projectile.getXCoord() > alien.getXCoord()
                                        && projectile.getXCoord() < (alien.getXCoord() + alien.getWidth())
                                        && projectile.getYCoord() > alien.getYCoord()
                                        && projectile.getYCoord() < (alien.getYCoord() + alien.getHeight())) {
                                    projectile.setDraw(false);
                                    alien.damage(projectile.getDamage());
                                } else if (projectile.getYCoord() < 0){
                                    projectile.setDraw(false);
                                }
                            }
                        }
                        projectile.setYCoord(projectile.getYCoord() - 15);
                    }
                    gamePanel.setScreenItems(makeScreenItems());
                }
            }
        });
        projectilesUpdate.start();
    }

    public void gameOver(){
        board.setCurrentState(new StateLost(board));
        timer.stop();
        projectilesUpdate.stop();
        board = null;
        aliens = null;
        projectiles = null;
    }

    public void movePlayer(){
        if (playerDirection ==  Constants.DIRECTION_LEFT){
            if ((player.getXCoord() - 25) < 100){
                playerDirection = Constants.DIRECTION_RIGHT;
            } else {
                player.setXCoord(player.getXCoord() - 25);
            }
        } else if (playerDirection == Constants.DIRECTION_RIGHT){
            if ((player.getXCoord() + 25) > (1180 - player.getWidth())){
                playerDirection = Constants.DIRECTION_LEFT;
            } else {
                player.setXCoord(player.getXCoord() + 25);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Move movement = movementProvider.getMovementCommand(aliens);
        if(movement == null) return;
        movement.moveAliens(aliens);

        movePlayer();

        if(times == 5 || times == 10 || times == 15 || times == 20 || times == 25 || times == 30 || times == 35 || times == 40){
            projectiles.add(projectileFactory.makeProjectile(Constants.NORMAL_PROJECTILE_ID, player.getXCoord() + (player.getWidth() /2) - 10, player.getYCoord() - 17));
        }

        times++;
        gamePanel.setScreenItems(makeScreenItems());
    }

    private ArrayList<ScreenItem> makeScreenItems(){
        ArrayList<ScreenItem> screenItems = new ArrayList<>();

        for (Alien alien : aliens){
            if(alien.draw()){
                screenItems.add(alien);
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

    public class CanvasPanel extends JPanel {

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
