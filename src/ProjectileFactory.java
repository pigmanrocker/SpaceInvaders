/**
 * Created by pigmanrocker on 31-3-17.
 */
public class ProjectileFactory {

    public ProjectileFactory(){

    }

    public Projectile makeProjectile(int type, int xCoord, int yCoord){
        switch (type){
            case Constants.NORMAL_PROJECTILE_ID:
                return new NormalShot(xCoord, yCoord);
            case Constants.POWER_PROJECTILE_ID:
                return new PowerShot(xCoord, yCoord);
            case Constants.ALIEN_BOMB_ID:
                return new AlienBomb(xCoord, yCoord);
            default:
                return null;
        }
    }
}
