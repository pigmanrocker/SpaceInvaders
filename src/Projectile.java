/**
 * Created by pigmanrocker on 28-3-17.
 */
public interface Projectile {
    int getDamage();
    void setXCoord(int xCoord);
    void setYCoord(int yCoord);
    void setDraw(boolean draw);
    boolean draw();
}
