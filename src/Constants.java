import java.awt.*;

/**
 * Created by pigmanrocker on 22-3-17.
 */
interface Constants {

    //Dimensions
    Dimension SCREEN_SIZE = new Dimension(1280, 720);
    Dimension HEADER_SIZE = new Dimension(1280, 150);
    Dimension BUTTON_SIZE = new Dimension(150, 75);
    Dimension BUTTON_RETURN_SIZE = new Dimension(300,75);

    Dimension HEADER_PADDING = new Dimension(0, 100);
    Dimension BUTTON_PADDING = new Dimension(0, 30);
    Dimension RETURN_BUTTON_PADDING = new Dimension(0,150);

    Dimension ABOUT_TEXT_BOX = new Dimension(1100,100);

    //Colors
    Color COLOR_WHITE = new Color(255, 255, 255);
    Color COLOR_BUTTON_BG = new Color(60, 60, 60);
    Color COLOR_WINDOW_BG = new Color(40, 40, 40);

    //Images

    //Fonts
    Font FONT_HEADER = new Font("sans", Font.BOLD, 60);
    Font FONT_BUTTON = new Font("Sans", Font.BOLD, 20);
    Font FONT_TEXT = new Font("Sans", Font.PLAIN, 16);
}
