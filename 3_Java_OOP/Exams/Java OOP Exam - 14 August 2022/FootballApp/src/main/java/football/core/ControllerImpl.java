package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        switch (fieldType) {
            case "ArtificialTurf": fields.add(new ArtificialTurf(fieldName));
                break;
            case "NaturalGrass": fields.add(new NaturalGrass(fieldName));
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        switch (type) {
            case "Powdered": supplement.add(new Powdered());
                break;
            case "Liquid": supplement.add(new Liquid());
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement1 = supplement.findByType(supplementType);

        if (supplement1 == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        supplement.remove(supplement1);

        fields.stream()
                .filter(field -> field.getName().equals(fieldName))
                .forEach(field -> field.addSupplement(supplement1));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        Field field = fields.stream()
                .filter(field1 -> field1.getName().equals(fieldName))
                .findFirst()
                .orElse(null);

        switch (playerType) {
            case "Men": player = new Men(playerName, nationality, strength);
                break;
            case "Women": player = new Women(playerName, nationality, strength);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        assert field != null;

        if ((playerType.equals("Men") && field.getClass().getSimpleName().equals("ArtificialTurf")) ||
                (playerType.equals("Women") && field.getClass().getSimpleName().equals("NaturalGrass"))) {
            return String.format(ConstantMessages.FIELD_NOT_SUITABLE);
        }

        field.addPlayer(player);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.stream()
                .filter(field1 -> field1.getName().equals(fieldName))
                .findFirst()
                .orElse(null);

        assert field != null;
        int count = field.getPlayers().size();
        field.drag();

        return String.format(ConstantMessages.PLAYER_DRAG, count);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.stream()
                .filter(field1 -> field1.getName().equals(fieldName))
                .findFirst()
                .orElse(null);

        assert field != null;

        int totalStrength = field.getPlayers().stream()
                .mapToInt(Player::getStrength)
                .sum();

        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, totalStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder rs = new StringBuilder();

        fields.forEach(field -> rs
                .append(field.getInfo())
                .append(System.lineSeparator()));

        return rs.toString().trim();
    }
}
