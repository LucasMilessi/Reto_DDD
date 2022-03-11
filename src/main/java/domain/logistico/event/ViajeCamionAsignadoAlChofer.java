package domain.logistico.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.value.CamionId;
import domain.chofer.value.ChoferId;
import domain.logistico.value.ViajeId;

public class ViajeCamionAsignadoAlChofer extends DomainEvent {
    private final ViajeId viajeId;
    private final ChoferId choferId;
    private final CamionId camionId;

    public ViajeCamionAsignadoAlChofer(ViajeId viajeId, ChoferId choferId, CamionId camionId) {
        super("logistico.viajecamionasignadoalchofer");
        this.viajeId = viajeId;
        this.choferId = choferId;
        this.camionId = camionId;
    }
}
