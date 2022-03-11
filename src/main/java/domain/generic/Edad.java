package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Edad implements ValueObject<Integer> {
    private final Integer edad;

    public Edad(Integer edad) {
        this.edad = edad;
        if(this.edad < 21)
            throw new IllegalArgumentException("Debes de tener 21 años como minimo");
    }

    public Integer getEdad() {
        return edad;
    }

    @Override
    public Integer value() {
        return edad;
    }
}
