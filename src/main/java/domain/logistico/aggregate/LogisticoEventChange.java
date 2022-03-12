package domain.logistico.aggregate;

import co.com.sofka.domain.generic.EventChange;
import domain.generic.EstadoDeViaje;
import domain.logistico.aggregate.Logistico;
import domain.logistico.event.LogisticoCreado;
import domain.logistico.event.ViajeCamionAsignadoAlChofer;

public class LogisticoEventChange extends EventChange {

    public LogisticoEventChange(Logistico logistico) {

        apply((LogisticoCreado event) -> {
            logistico.nombre = event.getNombre();
            logistico.edad = event.getEdad();
            logistico.direccion = event.getDireccion();
        });

        apply((ViajeCamionAsignadoAlChofer event) -> {
            if(logistico.choferId.equals(EstadoDeViaje.Fase.EN_VIAJE)){
                throw new IllegalArgumentException("El chofer esta en viaje, por lo tanto no se le puede asignar el viaje");
            }else if(logistico.camionId.equals(EstadoDeViaje.Fase.EN_VIAJE)){
                throw new IllegalArgumentException("El camion esta en viaje, por lo tanto no se le puede asignar al chofer");
            }
            logistico.viajeId = event.getViajeId();
            logistico.camionId = event.getCamionId();
            logistico.choferId = event.getChoferId();
        });
    }
}
