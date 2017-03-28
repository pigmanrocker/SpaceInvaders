import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Created by pigmanrocker on 23-3-17.
 */
public class StateGame implements State, Strings, Constants {

    private Board board;
    private CanvasPanel gamePanel;

    public StateGame(Board board){
        this.board = board;

        gamePanel = new CanvasPanel();
        gamePanel.setBackground(Constants.COLOR_WINDOW_BG);
    }

    public void setScreenItems(ArrayList<ScreenItem> newScreenItems){
        gamePanel.setScreenItems(newScreenItems);
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
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            graphics.setColor(Constants.COLOR_WHITE);

            if (screenItems != null){
                for (ScreenItem screenItem : screenItems){
                    graphics.drawImage(screenItem.getImage(), screenItem.getXCoord(), screenItem.getYCoord(), screenItem.getWidth(), screenItem.getHeight(), null);
                }
            }
        }
    }
}
