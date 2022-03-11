package domain.logistico.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ruta implements ValueObject<String> {
    private final String ruta;

    public Ruta(String ruta) {
        this.ruta = Objects.requireNonNull(ruta);
    }

    public String getRuta() {
        return ruta;
    }

    @Override
    public String value() {
        return ruta;
    }
}
