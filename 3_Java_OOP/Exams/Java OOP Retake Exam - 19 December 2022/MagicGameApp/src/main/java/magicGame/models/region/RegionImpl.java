package magicGame.models.region;

import magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region{
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizardList = magicians.stream()
                .filter(magician -> magician.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());

        List<Magician> blackWidowList = magicians.stream()
                .filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());

        while (!wizardList.isEmpty() && !blackWidowList.isEmpty()) {
            Magician wizard = wizardList.get(0);
            Magician blackWidow = blackWidowList.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());

            if (blackWidow.isAlive()) {
                wizard.takeDamage(blackWidow.getMagic().fire());
                if (!wizard.isAlive()) {
                    wizardList.remove(wizard);
                }
            } else {
                blackWidowList.remove(blackWidow);
            }
        }

        if (wizardList.size() > blackWidowList.size()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
