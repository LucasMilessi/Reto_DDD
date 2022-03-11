package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class CantidadDeCombustible implements ValueObject<Integer> {
    private final Integer cantidadDeCombustible;

    public CantidadDeCombustible(Integer cantidadDeCombustible) {
        this.cantidadDeCombustible = cantidadDeCombustible;
    }

    public Integer getCantidadDeCombustible() {
        return cantidadDeCombustible;
    }

    @Override
    public Integer value() {
        return cantidadDeCombustible;
    }
}
