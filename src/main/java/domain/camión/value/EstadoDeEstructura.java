package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoDeEstructura implements ValueObject<Integer> {
    private final Integer estructura;

    public EstadoDeEstructura(Integer estructura) {
        this.estructura = estructura;
        if(this.estructura > 30)
            throw new IllegalArgumentException("La estructura esta muy dañada.");
    }

    public Integer getEstructura() {
        return estructura;
    }

    @Override
    public Integer value() {
        return estructura;
    }
}
