package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoDeViaje implements ValueObject<EstadoDeViaje.Fase> {
    private final Fase valor;

    public EstadoDeViaje(Fase valor){
        this.valor = valor;
    }

    @Override
    public Fase value() {
        return valor;
    }

    public enum Fase{
        LIBRE, EN_VIAJE
    }
}
