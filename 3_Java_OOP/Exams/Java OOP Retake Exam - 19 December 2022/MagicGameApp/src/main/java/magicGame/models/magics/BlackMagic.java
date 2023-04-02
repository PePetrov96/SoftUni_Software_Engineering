package magicGame.models.magics;

public class BlackMagic extends MagicImpl{
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() >= 10) {
            super.setBulletsCount(super.getBulletsCount() - 10);
            return 10;
        } else {
            return 0;
        }
    }
}