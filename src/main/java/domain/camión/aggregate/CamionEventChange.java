package domain.camión.aggregate;

import co.com.sofka.domain.generic.EventChange;
import domain.camión.aggregate.Camion;
import domain.camión.event.CamionCreado;
import domain.camión.event.TrailerAgregado;
import domain.generic.EstadoDeViaje;

public class CamionEventChange extends EventChange {

    public CamionEventChange(Camion camion) {

        apply((CamionCreado event) -> {
            camion.cantidadDeKM = event.getCantidadDeKM();
            camion.marca = event.getMarca();
            camion.estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
            camion.cantidadDeCombustible = event.getCantidadDeCombustible();
            camion.estadoDeCamion = event.getEstadoDeCamion();
        });

        apply((TrailerAgregado event) -> {
            camion.trailerId = event.getTrailerId();
        });
    }
}
