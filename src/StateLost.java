import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pigmanrocker on 23-3-17.
 */
public class StateLost implements State, ActionListener {
    private JPanel lostPanel;
    private Board board;

    public StateLost(Board board) {
        this.board = board;

        lostPanel = new JPanel();
        lostPanel.setBackground(Constants.COLOR_WINDOW_BG);
        lostPanel.setLayout(new BoxLayout(lostPanel, BoxLayout.PAGE_AXIS));

        //Lost text label
        JLabel header = new JLabel();
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setMaximumSize(Constants.HEADER_SIZE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Constants.COLOR_WHITE);
        header.setText(Strings.LOST_HEADER);
        header.setFont(Constants.FONT_HEADER);
        header.setVisible(true);
        lostPanel.add(header);

        //Margin between button
        lostPanel.add(Box.createRigidArea(Constants.LOST_BUTTON_PADDING));

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
        lostPanel.add(returnButton);

        returnButton.addActionListener(this);
    }

    public JPanel getMainPanel(){
        return lostPanel;
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
