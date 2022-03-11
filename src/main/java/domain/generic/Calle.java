package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Calle implements ValueObject<String> {
    private final String calle;

    public Calle(String calle) {
        this.calle = calle;
    }

    public String getCalle() {
        return calle;
    }

    @Override
    public String value() {
        return calle;
    }
}
