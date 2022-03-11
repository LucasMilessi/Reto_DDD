package domain.chofer.value;

import co.com.sofka.domain.generic.ValueObject;

public class Salario implements ValueObject<Double> {
    private final double sueldo;

    public Salario(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public Double value() {
        return sueldo;
    }
}
