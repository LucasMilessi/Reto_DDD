package domain.camión.value;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoDeCamion implements ValueObject<EstadoDeCamion.Props> {
    private final EstadoRueda estadoRueda;
    private final EstadoDeChasis estadoDeChasis;
    private final EstadoDeMotor estadoDeMotor;

    public EstadoDeCamion(EstadoRueda estadoRueda, EstadoDeChasis estadoDeChasis, EstadoDeMotor estadoDeMotor) {
        this.estadoRueda = estadoRueda;
        this.estadoDeChasis = estadoDeChasis;
        this.estadoDeMotor = estadoDeMotor;
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
            public EstadoDeMotor estadoDeMotor(){
                return estadoDeMotor;
            }
        };
    }

    public interface Props{
        EstadoRueda estadoRueda();
        EstadoDeChasis estadoDeChasis();
        EstadoDeMotor estadoDeMotor();
    }
}
