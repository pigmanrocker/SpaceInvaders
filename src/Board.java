import javax.swing.*;
import java.awt.*;

/**
 * Created by pigmanrocker on 19-3-17.
 */
public class Board {

    private JFrame jFrame;

    //main method. starts the program. just creates an instant of the board class
    public static void main(String [] args){
        new Board();
    }

    public Board(){
        jFrame = new JFrame("Space Invaders");

        jFrame.setPreferredSize(new Dimension(1280, 720));
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setBackground(new Color(40, 40, 40));
        jFrame.getContentPane().setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
        jFrame.pack();
        jFrame.setVisible(true);

        showMainMenu();
    }

    public void showMainMenu(){

        //Main menu text label
        Label header = new Label();
        header.setText("Welcome to Space Invaders!");
        header.setAlignment(Label.CENTER);
        header.setMaximumSize(new Dimension(1280, 150));
        header.setForeground(new Color(255, 255, 255));
        header.setFont(new Font("Sans", Font.BOLD, 60));
        header.setVisible(true);
        jFrame.getContentPane().add(header);

        //Margin between header and start button
        jFrame.getContentPane().add(Box.createRigidArea(new Dimension(0, 100)));

        //Start game button
        Button startButton = new Button();
        startButton.setBackground(new Color(60, 60, 60));
        startButton.setLabel("Start");
        startButton.setMaximumSize(new Dimension(150, 75));
        startButton.setForeground(new Color(255, 255, 255));
        startButton.setFont(new Font("Sans", Font.BOLD, 20));
        startButton.setVisible(true);
        jFrame.getContentPane().add(startButton);

        //Margin between buttons
        jFrame.getContentPane().add(Box.createRigidArea(new Dimension(0, 30)));

        //About button
        Button aboutButton = new Button();
        aboutButton.setBackground(new Color(60, 60, 60));
        aboutButton.setLabel("About");
        aboutButton.setMaximumSize(new Dimension(150, 75));
        aboutButton.setForeground(new Color(255, 255, 255));
        aboutButton.setFont(new Font("Sans", Font.BOLD, 20));
        aboutButton.setVisible(true);
        jFrame.getContentPane().add(aboutButton);

        //Margin between buttons
        jFrame.getContentPane().add(Box.createRigidArea(new Dimension(0, 30)));

        //Credits button
        Button creditsButton = new Button();
        creditsButton.setBackground(new Color(60, 60, 60));
        creditsButton.setLabel("Credits");
        creditsButton.setMaximumSize(new Dimension(150, 75));
        creditsButton.setForeground(new Color(255, 255, 255));
        creditsButton.setFont(new Font("Sans", Font.BOLD, 20));
        creditsButton.setVisible(true);
        jFrame.getContentPane().add(creditsButton);
    }
}