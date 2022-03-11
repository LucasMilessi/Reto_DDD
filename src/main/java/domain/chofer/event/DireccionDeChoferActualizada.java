package domain.chofer.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.chofer.value.ChoferId;
import domain.generic.Direccion;

public class DireccionDeChoferActualizada extends DomainEvent {
    private final ChoferId choferId;
    private final Direccion direccion;

    public DireccionDeChoferActualizada(ChoferId choferId, Direccion direccion) {
        super("chofer.direcciondechoferactualizada");
        this.choferId = choferId;
        this.direccion = direccion;
    }
}
