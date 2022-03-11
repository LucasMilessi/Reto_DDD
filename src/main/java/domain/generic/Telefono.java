package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Telefono implements ValueObject<Integer> {
    private final Integer telefono;

    public Telefono(int telefono) {
        this.telefono = telefono;
        if(this.telefono < 9 && this.telefono > 9)
            throw new IllegalArgumentException("El telefono debe de tener 9 digitos.");
    }

    public Integer getTelefono() {
        return telefono;
    }

    @Override
    public Integer value() {
        return telefono;
    }
}
