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
        display = new Gui();
    }
}