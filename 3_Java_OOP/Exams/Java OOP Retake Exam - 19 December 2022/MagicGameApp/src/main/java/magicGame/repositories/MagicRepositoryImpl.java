package magicGame.repositories;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;
import magicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return Collections.unmodifiableCollection(this.data);
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        this.data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return this.data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return this.data.stream()
                .filter(magic -> magic.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
