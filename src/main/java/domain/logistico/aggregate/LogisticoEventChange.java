package domain.logistico.aggregate;

import co.com.sofka.domain.generic.EventChange;
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
            logistico.viajeId = event.getViajeId();
            logistico.camionId = event.getCamionId();
            logistico.choferId = event.getChoferId();
        });
    }
}
