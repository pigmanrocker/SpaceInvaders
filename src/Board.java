import javax.swing.*;
import java.awt.*;

/**
 * Created by pigmanrocker on 19-3-17.
 */
public class Board implements Constants, Strings{

    private JFrame jFrame;
    private State currentState;

    //main method. starts the program. just creates an instance of the board class
    public static void main(String [] args){
        new Board();
    }

    public Board(){
        jFrame = new JFrame(Strings.WINDOW_TITLE);
        jFrame.setPreferredSize(Constants.SCREEN_SIZE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);

        setCurrentState(new StateMenu(this));
    }

    public void setCurrentState(State newState){
        jFrame.getContentPane().removeAll();
        jFrame.repaint();

        currentState = newState;
        jFrame.getContentPane().add(currentState.getMainPanel());
        jFrame.getContentPane().setBackground(Constants.COLOR_WINDOW_BG);
        jFrame.pack();
    }
}