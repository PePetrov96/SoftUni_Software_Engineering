package magicGame.models.magics;

public class RedMagic extends MagicImpl{

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() >= 1) {
            super.setBulletsCount(super.getBulletsCount() - 1);
            return 1;
        } else {
            return 0;
        }
    }
}