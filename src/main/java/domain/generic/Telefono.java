package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Telefono implements ValueObject<Long> {
    private final Long telefono;

    public Telefono(Long telefono) {
        this.telefono = telefono;
        if(this.telefono < 12 && this.telefono > 12)
            throw new IllegalArgumentException("El telefono debe de tener 7 digitos.");
    }

    public Long getTelefono() {
        return telefono;
    }

    @Override
    public Long value() {
        return telefono;
    }
}
