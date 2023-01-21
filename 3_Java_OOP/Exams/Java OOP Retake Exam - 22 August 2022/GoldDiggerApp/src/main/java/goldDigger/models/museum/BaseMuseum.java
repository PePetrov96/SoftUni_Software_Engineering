package goldDigger.models.museum;

import java.util.ArrayList;
import java.util.Collection;

public class BaseMuseum implements Museum{
    private final Collection<String> exhibits;

    public BaseMuseum() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }
}