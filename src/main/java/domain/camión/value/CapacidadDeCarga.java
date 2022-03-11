package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class CapacidadDeCarga implements ValueObject<Double> {
    private final double cargaEnKG;

    public CapacidadDeCarga(double cargaEnKG) {
        this.cargaEnKG = cargaEnKG;
        if(this.cargaEnKG > 38000)
            throw new IllegalArgumentException("Lo maximo tolerable es 38000 Kg de peso, si se pasa se cobra multa");
    }

    public double getCargaEnKG() {
        return cargaEnKG;
    }

    @Override
    public Double value() {
        return cargaEnKG;
    }
}
