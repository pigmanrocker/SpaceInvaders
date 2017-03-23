import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pigmanrocker on 22-3-17.
 * This class handles the graphical user interface. it passes the clicks of the buttons through to the Board class.
 */
public class Gui implements Constants, Strings, ActionListener {

    private Board board;

    private JFrame jFrame;
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JPanel aboutPanel;
    private JPanel creditsPanel;

    /**
     * Setting up the base window for the application
     * @param board passing a reference to the Board class to allow the passing of click events
     */
    public Gui(Board board){
        this.board = board;

        jFrame = new JFrame(Strings.WINDOW_TITLE);
        jFrame.setPreferredSize(Constants.SCREEN_SIZE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setBackground(Constants.COLOR_WINDOW_BG);
        jFrame.getContentPane().setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
        jFrame.pack();
        jFrame.setVisible(true);

        showMenu();
    }

    /**
     * Setting up and displaying the menu screen
     */
    public void showMenu(){
        cleanScreen();

        menuPanel = new JPanel();
        menuPanel.setBackground(Constants.COLOR_WINDOW_BG);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));

        jFrame.getContentPane().add(menuPanel);

        //Main menu text label
        JLabel header = new JLabel();
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setMaximumSize(Constants.HEADER_SIZE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Constants.COLOR_WHITE);
        header.setText(Strings.MENU_HEADER);
        header.setFont(Constants.FONT_HEADER);
        header.setVisible(true);
        menuPanel.add(header);

        //Margin between header and start button
        menuPanel.add(Box.createRigidArea(Constants.HEADER_PADDING));

        //Start game button
        JButton startButton = new JButton();
        startButton.setActionCommand(Strings.MENU_BUTTON_START);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMaximumSize(Constants.BUTTON_SIZE);
        startButton.setBackground(Constants.COLOR_BUTTON_BG);
        startButton.setForeground(Constants.COLOR_WHITE);
        startButton.setText(Strings.MENU_BUTTON_START);
        startButton.setFont(Constants.FONT_BUTTON);
        startButton.setVisible(true);
        menuPanel.add(startButton);

        //Margin between buttons
        menuPanel.add(Box.createRigidArea(Constants.BUTTON_PADDING));

        //About button
        JButton aboutButton = new JButton();
        aboutButton.setActionCommand(Strings.MENU_BUTTON_ABOUT);
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setMaximumSize(Constants.BUTTON_SIZE);
        aboutButton.setBackground(Constants.COLOR_BUTTON_BG);
        aboutButton.setForeground(Constants.COLOR_WHITE);
        aboutButton.setText(Strings.MENU_BUTTON_ABOUT);
        aboutButton.setFont(Constants.FONT_BUTTON);
        aboutButton.setVisible(true);
        menuPanel.add(aboutButton);

        //Margin between buttons
        menuPanel.add(Box.createRigidArea(Constants.BUTTON_PADDING));

        //Credits button
        JButton creditsButton = new JButton();
        creditsButton.setActionCommand(Strings.MENU_BUTTON_CREDITS);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.setMaximumSize(Constants.BUTTON_SIZE);
        creditsButton.setBackground(Constants.COLOR_BUTTON_BG);
        creditsButton.setForeground(Constants.COLOR_WHITE);
        creditsButton.setText(Strings.MENU_BUTTON_CREDITS);
        creditsButton.setFont(Constants.FONT_BUTTON);
        creditsButton.setVisible(true);
        menuPanel.add(creditsButton);

        startButton.addActionListener(this);
        aboutButton.addActionListener(this);
        creditsButton.addActionListener(this);

        jFrame.pack();
    }

    /**
     * Setting up and displaying the about screen
     */
    public void showAbout(){
        cleanScreen();

        jFrame.pack();
    }

    /**
     * Setting up and displaying the credits screen
     */
    public void showCredits(){
        cleanScreen();

        jFrame.pack();
    }

    /**
     * Setting up the base game canvas
     */
    public void showGame(){
        cleanScreen();

        jFrame.pack();
    }

    /**
     * Cleaning the screen of all elements
     */
    private void cleanScreen(){
        jFrame.getContentPane().removeAll();
        jFrame.repaint();
    }

    /**
     * Handles the click events on the buttons
     * @param actionEvent Reference to the event. Uses the same string as is displayed on the button to identify it.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case Strings.MENU_BUTTON_START:
                board.setGameState();
                break;
            case Strings.MENU_BUTTON_ABOUT:
                board.setAboutState();
                break;
            case Strings.MENU_BUTTON_CREDITS:
                board.setCreditsState();
                break;
            default:
                break;
        }
    }
}
