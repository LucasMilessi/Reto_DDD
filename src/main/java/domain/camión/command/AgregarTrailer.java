package domain.camión.command;

import co.com.sofka.domain.generic.Command;
import domain.camión.value.CamionId;
import domain.camión.value.TrailerId;

public class AgregarTrailer extends Command {
    private final CamionId camionId;
    private final TrailerId trailerId;

    public AgregarTrailer(CamionId camionId, TrailerId trailerId) {
        this.camionId = camionId;
        this.trailerId = trailerId;
    }

    public TrailerId getTrailerId() {
        return trailerId;
    }

    public CamionId getCamionId() {
        return camionId;
    }
}
