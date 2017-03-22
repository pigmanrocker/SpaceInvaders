import javax.swing.*;
import java.awt.*;

/**
 * Created by pigmanrocker on 19-3-17.
 */
public class Board implements Constants{

    private Gui display;

    //main method. starts the program. just creates an instance of the board class
    public static void main(String [] args){
        new Board();
    }

    public Board(){
        display = new Gui(this);
    }

    public void setMenuState(){
        display.showMenu();
    }

    public void setAboutState(){
        display.showAbout();
    }

    public void setCreditsState(){
        display.showCredits();
    }

    public void setGameState(){
        display.showGame();
    }
}