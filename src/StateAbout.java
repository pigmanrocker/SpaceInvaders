import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pigmanrocker on 23-3-17.
 */
public class StateAbout implements State, Strings, Constants, ActionListener {

    private JPanel aboutPanel;
    private Board board;

    public StateAbout(Board board) {
        this.board = board;

        aboutPanel = new JPanel();
        aboutPanel.setBackground(Constants.COLOR_WINDOW_BG);
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.PAGE_AXIS));

        //About text label
        JLabel header = new JLabel();
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setMaximumSize(Constants.HEADER_SIZE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Constants.COLOR_WHITE);
        header.setText(Strings.ABOUT_HEADER);
        header.setFont(Constants.FONT_HEADER);
        header.setVisible(true);
        aboutPanel.add(header);

        //margin
        aboutPanel.add(Box.createRigidArea(Constants.HEADER_PADDING));

        //Text
        JLabel aboutText = new JLabel();
        aboutText.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutText.setMaximumSize(Constants.ABOUT_TEXT_BOX);
        aboutText.setHorizontalAlignment(SwingConstants.CENTER);
        aboutText.setForeground(Constants.COLOR_WHITE);
        aboutText.setText(Strings.ABOUT_TEXT);
        aboutText.setFont(Constants.FONT_TEXT);
        aboutText.setVisible(true);
        aboutPanel.add(aboutText);

        //Margin between buttons
        aboutPanel.add(Box.createRigidArea(Constants.RETURN_BUTTON_PADDING));

        //Return to main menu button
        JButton returnButton = new JButton();
        returnButton.setActionCommand(Strings.ACTION_RETURN);
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.setMaximumSize(Constants.BUTTON_RETURN_SIZE);
        returnButton.setBackground(Constants.COLOR_BUTTON_BG);
        returnButton.setForeground(Constants.COLOR_WHITE);
        returnButton.setText(Strings.BUTTON_RETURN);
        returnButton.setFont(Constants.FONT_BUTTON);
        returnButton.setVisible(true);
        aboutPanel.add(returnButton);

        returnButton.addActionListener(this);
    }

    public JPanel getMainPanel(){
        return aboutPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case Strings.ACTION_RETURN:
                board.setCurrentState(new StateMenu(board));
                break;
            default:
                break;
        }
    }
}
