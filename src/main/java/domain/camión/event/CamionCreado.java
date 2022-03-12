package domain.camión.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.value.*;
import domain.generic.EstadoDeViaje;

public class CamionCreado extends DomainEvent {
    private final CantidadDeKM cantidadDeKM;
    private final Marca marca;
    private final EstadoDeViaje estadoDeViaje;
    private final CantidadDeCombustible cantidadDeCombustible;
    private final EstadoDeCamion estadoDeCamion;

    public CamionCreado(CantidadDeKM cantidadDeKM, Marca marca, EstadoDeViaje estadoDeViaje, CantidadDeCombustible cantidadDeCombustible, EstadoDeCamion estadoDeCamion) {
        super("camion.camioncreado");
        this.cantidadDeKM = cantidadDeKM;
        this.marca = marca;
        this.estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        this.cantidadDeCombustible = cantidadDeCombustible;
        this.estadoDeCamion = estadoDeCamion;
    }

    public CantidadDeKM getCantidadDeKM() {
        return cantidadDeKM;
    }

    public Marca getMarca() {
        return marca;
    }

    public EstadoDeViaje getEstadoDeViaje() {
        return estadoDeViaje;
    }

    public CantidadDeCombustible getCantidadDeCombustible() {
        return cantidadDeCombustible;
    }

    public EstadoDeCamion getEstadoDeCamion() {
        return estadoDeCamion;
    }
}
