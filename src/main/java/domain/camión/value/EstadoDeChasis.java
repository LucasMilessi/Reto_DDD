package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoDeChasis implements ValueObject<Integer> {
    private final Integer chasis;

    public EstadoDeChasis(Integer chasis) {
        this.chasis = chasis;
        if(this.chasis < 30)
            throw new IllegalArgumentException("El chasis esta muy dañado.");
    }

    public Integer getChasis() {
        return chasis;
    }

    @Override
    public Integer value() {
        return chasis;
    }
}
