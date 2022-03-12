package domain.logistico.command;

import co.com.sofka.domain.generic.Command;
import domain.camión.value.CamionId;
import domain.chofer.value.ChoferId;
import domain.logistico.value.LogisticoId;
import domain.logistico.value.ViajeId;

public class asignarViajeCamionChofer extends Command {
    private final LogisticoId logisticoId;
    private final ViajeId viajeId;
    private final ChoferId choferId;
    private final CamionId camionId;

    public asignarViajeCamionChofer(LogisticoId logisticoId, ViajeId viajeId, ChoferId choferId, CamionId camionId) {
        this.logisticoId = logisticoId;
        this.viajeId = viajeId;
        this.choferId = choferId;
        this.camionId = camionId;
    }

    public LogisticoId getLogisticoId() {
        return logisticoId;
    }

    public ViajeId getViajeId() {
        return viajeId;
    }

    public ChoferId getChoferId() {
        return choferId;
    }

    public CamionId getCamionId() {
        return camionId;
    }
}
