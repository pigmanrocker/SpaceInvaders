import java.awt.*;

/**
 * Created by pigmanrocker on 22-3-17.
 */
interface Constants {

    //Dimensions
    Dimension SCREEN_SIZE = new Dimension(1280, 720);
    Dimension HEADER_SIZE = new Dimension(1280, 150);
    Dimension SUB_HEADER_SIZE = new Dimension(500, 50);
    Dimension CREDIT_TEXT_SIZE = new Dimension(200, 30);
    Dimension BUTTON_SIZE = new Dimension(150, 75);
    Dimension BUTTON_RETURN_SIZE = new Dimension(300,75);

    Dimension HEADER_PADDING = new Dimension(0, 10);
    Dimension HEADER_BUTTON_PADDING = new Dimension(0, 100);
    Dimension BUTTON_PADDING = new Dimension(0, 30);
    Dimension RETURN_BUTTON_PADDING = new Dimension(0,150);
    Dimension CREDIT_BUTTON_PADDING = new Dimension(0, 350);

    Dimension ABOUT_TEXT_BOX = new Dimension(1100,100);

    //Colors
    Color COLOR_WHITE = new Color(255, 255, 255);
    Color COLOR_BUTTON_BG = new Color(60, 60, 60);
    Color COLOR_WINDOW_BG = new Color(40, 40, 40);

    //Images

    //Fonts
    Font FONT_HEADER = new Font("sans", Font.BOLD, 60);
    Font FONT_BUTTON = new Font("sans", Font.BOLD, 20);
    Font FONT_TEXT = new Font("sans", Font.PLAIN, 16);
    Font FONT_SUB_HEADER = new Font("sans", Font.ITALIC, 30);

    //Projectiles
    int NORMAL_PROJECTILE_ID = 1;
    int NORMAL_PROJECTILE_DAMAGE = 1;
    int NORMAL_PROJECTILE_WIDTH = 20;
    int NORMAL_PROJECTILE_HEIGHT = 30;
    String NORMAL_PROJECTILE_IMAGE = "";
    int ALIEN_BOMB_ID = 3;
    int ALIEN_BOMB_DAMAGE = 1;
    int ALIEN_BOMB_WIDTH = 20;
    int ALIEN_BOMB_HEIGHT = 20;
    String ALIEN_BOMB_IMAGE = "";
    int POWER_PROJECTILE_ID = 2;
    int POWER_PROJECTILE_DAMAGE = 2;
    int POWER_PROJECTILE_WIDTH = 20;
    int POWER_PROJECTILE_HEIGHT = 30;
    String POWER_PROJECTILE_IMAGE ="";

    //Aliens
    int NORMAL_ALIEN_WIDTH = 50;
    int NORMAL_ALIEN_HEIGHT = 50;
    int NORMAL_ALIEN_HEALTH = 1;
    String NORMAL_ALIEN_IMAGE = "";
    int TOUGH_ALIEN_WIDTH = 50;
    int TOUGH_ALIEN_HEIGHT = 50;
    int TOUGH_ALIEN_HEALTH = 2;
    String TOUGH_ALIEN_IMAGE = "";
}
