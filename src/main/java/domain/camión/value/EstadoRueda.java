package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoRueda implements ValueObject<Integer> {
    private final Integer ruedas;

    public EstadoRueda(Integer ruedas) {
        this.ruedas = ruedas;
        if(this.ruedas < 30)
            throw new IllegalArgumentException("Se deben de cambiar las ruedas.");
    }

    public Integer getRuedas() {
        return ruedas;
    }

    @Override
    public Integer value() {
        return ruedas;
    }
}
