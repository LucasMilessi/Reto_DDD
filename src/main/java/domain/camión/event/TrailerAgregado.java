package domain.camión.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.value.CamionId;
import domain.camión.value.TrailerId;

public class TrailerAgregado extends DomainEvent {
    private final CamionId camionId;
    private final TrailerId trailerId;

    public TrailerAgregado(CamionId camionId, TrailerId trailerId) {
        super("camion.traileragregado");
        this.camionId = camionId;
        this.trailerId = trailerId;
    }

    public CamionId getCamionId() {
        return camionId;
    }

    public TrailerId getTrailerId() {
        return trailerId;
    }
}
