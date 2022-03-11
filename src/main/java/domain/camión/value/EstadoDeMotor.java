package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoDeMotor implements ValueObject<Integer> {
    private final Integer estadoMotor;

    public EstadoDeMotor(Integer estadoMotor) {
        this.estadoMotor = estadoMotor;
        if(this.estadoMotor < 30)
            throw new IllegalArgumentException("El motor esta demasiado dañado");
    }

    public Integer getEstadoMotor() {
        return estadoMotor;
    }

    @Override
    public Integer value() {
        return estadoMotor;
    }
}
