package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Direccion implements ValueObject<Direccion.Props> {
    private final Calle calle1;
    private final Calle calle2;
    private final Integer numero;

    public Direccion(Calle calle1, Calle calle2, Integer numero) {
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.numero = numero;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Calle calle1(){
                return calle1;
            }
            @Override
            public Calle calle2(){
                return calle2;
            }
            @Override
            public Integer numero(){
                return numero;
            }
        };
    }

    public interface Props{
        Calle calle1();
        Calle calle2();
        Integer numero();
    }
}
