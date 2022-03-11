package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoDeTrailer implements ValueObject<EstadoDeTrailer.Props> {
    private final EstadoRueda estadoRueda;
    private final EstadoDeChasis estadoDeChasis;
    private final EstadoDeEstructura estadoDeEstructura;

    public EstadoDeTrailer(EstadoRueda estadoRueda, EstadoDeChasis estadoDeChasis, EstadoDeEstructura estadoDeEstructura) {
        this.estadoRueda = estadoRueda;
        this.estadoDeChasis = estadoDeChasis;
        this.estadoDeEstructura = estadoDeEstructura;
    }

    @Override
    public Props value() {
        return new Props(){
            @Override
            public EstadoRueda estadoRueda(){
                return estadoRueda;
            }
            @Override
            public EstadoDeChasis estadoDeChasis(){
                return estadoDeChasis;
            }
            @Override
            public EstadoDeEstructura estadoDeEstructura(){
                return estadoDeEstructura;
            }
        };
    }

    public interface Props{
        EstadoRueda estadoRueda();
        EstadoDeChasis estadoDeChasis();
        EstadoDeEstructura estadoDeEstructura();
    }
}
