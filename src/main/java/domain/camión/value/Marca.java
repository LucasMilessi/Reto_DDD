package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Marca implements ValueObject<String> {
    private final String marca;

    public Marca(String marca) {
        this.marca = Objects.requireNonNull(marca);
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String value() {
        return marca;
    }
}
