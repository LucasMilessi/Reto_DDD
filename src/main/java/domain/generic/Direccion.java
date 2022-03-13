package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Direccion implements ValueObject<Direccion.Props> {
    private final Calle calle;
    private final Integer numero;

    public Direccion(Calle calle, Integer numero) {
        this.calle = calle;
        this.numero = numero;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Calle calle(){
                return calle;
            }
            @Override
            public Integer numero(){
                return numero;
            }
        };
    }

    public interface Props{
        Calle calle();
        Integer numero();
    }
}
