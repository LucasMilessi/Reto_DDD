package domain.camión.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.value.CamionId;
import domain.camión.value.TrailerId;

public class TrailerAgregado extends DomainEvent {
    private final TrailerId trailerId;

    public TrailerAgregado(TrailerId trailerId) {
        super("camion.traileragregado");
        this.trailerId = trailerId;
    }

    public TrailerId getTrailerId() {
        return trailerId;
    }
}
