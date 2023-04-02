package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.MagicRepositoryImpl;
import magicGame.repositories.MagicianRepositoryImpl;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        switch (type) {
            case "RedMagic":
                    this.magics.addMagic(new RedMagic(name, bulletsCount));
                break;
            case "BlackMagic":
                    this.magics.addMagic(new BlackMagic(name, bulletsCount));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = magics.findByName(magicName);

        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }

        switch (type) {
            case "Wizard":
                    this.magicians.addMagician(new Wizard(username, health, protection, magic));
                break;
            case "BlackWidow":
                    this.magicians.addMagician(new BlackWidow(username,health, protection, magic));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return this.region.start(this.magicians.getData().stream()
                .filter(Magician::isAlive)
                .collect(Collectors.toList()));
    }

    @Override
    public String report() {
        StringBuilder out = new StringBuilder();

        List<Magician> sortedMagicians = this.magicians.getData().stream()
                .sorted(Comparator.comparingInt(Magician::getHealth)
                        .thenComparing(Magician::getUsername))
                .collect(Collectors.toList());

        sortedMagicians.forEach(magician -> out.append(magician.toString()));

        return out.toString().trim();
    }
}