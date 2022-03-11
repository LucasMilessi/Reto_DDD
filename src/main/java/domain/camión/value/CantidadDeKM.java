package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class CantidadDeKM implements ValueObject<Integer> {
    private final Integer cantidadDeKM;

    public CantidadDeKM(Integer cantidadDeKM) {
        this.cantidadDeKM = cantidadDeKM;
        if(this.cantidadDeKM > 1000000)
            throw new IllegalArgumentException("El camión se paso de los KM admitidos, deben cambiarlo.");
    }

    public Integer getCantidadDeKM() {
        return cantidadDeKM;
    }

    @Override
    public Integer value() {
        return cantidadDeKM;
    }
}
