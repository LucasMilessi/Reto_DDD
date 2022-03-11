package domain.logistico.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Lugar implements ValueObject<String> {
    private final String lugar;

    public Lugar(String lugar) {
        this.lugar = Objects.requireNonNull(lugar);
    }

    public String getLugar() {
        return lugar;
    }

    @Override
    public String value() {
        return lugar;
    }
}
