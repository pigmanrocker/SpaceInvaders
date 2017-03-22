import javax.swing.*;
import java.awt.*;

/**
 * Created by pigmanrocker on 22-3-17.
 */
public class Gui implements Constants, Strings {

    private JFrame jFrame;

    public Gui(){
        jFrame = new JFrame(Strings.WINDOW_TITLE);

        jFrame.setPreferredSize(Constants.SCREEN_SIZE);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setBackground(Constants.COLOR_MENU_BG);
        jFrame.getContentPane().setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
        jFrame.pack();
        jFrame.setVisible(true);

        showMainMenu();
    }

    public void showMainMenu(){

        //Main menu text label
        Label header = new Label();
        header.setText(Strings.MENU_HEADER);
        header.setAlignment(Label.CENTER);
        header.setMaximumSize(Constants.HEADER_SIZE);
        header.setForeground(Constants.COLOR_WHITE);
        header.setFont(Constants.FONT_HEADER);
        header.setVisible(true);
        jFrame.getContentPane().add(header);

        //Margin between header and start button
        jFrame.getContentPane().add(Box.createRigidArea(Constants.HEADER_PADDING));

        //Start game button
        Button startButton = new Button();
        startButton.setBackground(Constants.COLOR_BUTTON_BG);
        startButton.setLabel(Strings.MENU_BUTTON_START);
        startButton.setMaximumSize(Constants.BUTTON_SIZE);
        startButton.setForeground(Constants.COLOR_WHITE);
        startButton.setFont(Constants.FONT_BUTTON);
        startButton.setVisible(true);
        jFrame.getContentPane().add(startButton);

        //Margin between buttons
        jFrame.getContentPane().add(Box.createRigidArea(Constants.BUTTON_PADDING));

        //About button
        Button aboutButton = new Button();
        aboutButton.setBackground(Constants.COLOR_BUTTON_BG);
        aboutButton.setLabel(Strings.MENU_BUTTON_ABOUT);
        aboutButton.setMaximumSize(Constants.BUTTON_SIZE);
        aboutButton.setForeground(Constants.COLOR_WHITE);
        aboutButton.setFont(Constants.FONT_BUTTON);
        aboutButton.setVisible(true);
        jFrame.getContentPane().add(aboutButton);

        //Margin between buttons
        jFrame.getContentPane().add(Box.createRigidArea(Constants.BUTTON_PADDING));

        //Credits button
        Button creditsButton = new Button();
        creditsButton.setBackground(Constants.COLOR_BUTTON_BG);
        creditsButton.setLabel(Strings.MENU_BUTTON_CREDITS);
        creditsButton.setMaximumSize(Constants.BUTTON_SIZE);
        creditsButton.setForeground(Constants.COLOR_WHITE);
        creditsButton.setFont(Constants.FONT_BUTTON);
        creditsButton.setVisible(true);
        jFrame.getContentPane().add(creditsButton);
    }

    public void showAbout(){

    }
}
