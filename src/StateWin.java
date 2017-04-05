import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pigmanrocker on 23-3-17.
 */
public class StateWin implements State, ActionListener {
    private JPanel winPanel;
    private Board board;

    public StateWin(Board board){
        this.board = board;

        winPanel = new JPanel();
        winPanel.setBackground(Constants.COLOR_WINDOW_BG);
        winPanel.setLayout(new BoxLayout(winPanel, BoxLayout.PAGE_AXIS));

        JLabel header = new JLabel();
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setMaximumSize(Constants.HEADER_SIZE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Constants.COLOR_WHITE);
        header.setText(Strings.WIN_HEADER);
        header.setFont(Constants.FONT_HEADER);
        header.setVisible(true);
        winPanel.add(header);

        winPanel.add(Box.createRigidArea(Constants.HEADER_PADDING));

        JLabel developers = new JLabel();
        developers.setAlignmentX(Component.CENTER_ALIGNMENT);
        developers.setMaximumSize(Constants.SUB_HEADER_SIZE);
        developers.setHorizontalAlignment(SwingConstants.CENTER);
        developers.setForeground(Constants.COLOR_WHITE);
        developers.setText(Strings.WIN_SUB_HEADER);
        developers.setFont(Constants.FONT_SUB_HEADER);
        developers.setVisible(true);
        winPanel.add(developers);

        JLabel developer1 = new JLabel();
        developer1.setAlignmentX(Component.CENTER_ALIGNMENT);
        developer1.setMaximumSize(Constants.CREDIT_TEXT_SIZE);
        developer1.setHorizontalAlignment(SwingConstants.CENTER);
        developer1.setForeground(Constants.COLOR_WHITE);
        developer1.setText(Strings.DEVELOPER1);
        developer1.setFont(Constants.FONT_TEXT);
        developer1.setVisible(true);
        winPanel.add(developer1);

        JLabel developer2 = new JLabel();
        developer2.setAlignmentX(Component.CENTER_ALIGNMENT);
        developer2.setMaximumSize(Constants.CREDIT_TEXT_SIZE);
        developer2.setHorizontalAlignment(SwingConstants.CENTER);
        developer2.setForeground(Constants.COLOR_WHITE);
        developer2.setText(Strings.DEVELOPER2);
        developer2.setFont(Constants.FONT_TEXT);
        developer2.setVisible(true);
        winPanel.add(developer2);

        winPanel.add(Box.createRigidArea(Constants.CREDIT_BUTTON_PADDING));

        JButton returnButton = new JButton();
        returnButton.setActionCommand(Strings.ACTION_RETURN);
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.setMaximumSize(Constants.BUTTON_RETURN_SIZE);
        returnButton.setBackground(Constants.COLOR_BUTTON_BG);
        returnButton.setForeground(Constants.COLOR_WHITE);
        returnButton.setText(Strings.BUTTON_RETURN);
        returnButton.setFont(Constants.FONT_BUTTON);
        returnButton.setVisible(true);
        winPanel.add(returnButton);

        returnButton.addActionListener(this);
    }

    public JPanel getMainPanel(){
        return winPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case Strings.ACTION_RETURN:
                board.setCurrentState(new StateMenu(board));
        }
    }
}
