package domain.chofer.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.chofer.value.ChoferId;
import domain.generic.Direccion;

public class DireccionDeChoferActualizada extends DomainEvent {
    private final Direccion direccion;

    public DireccionDeChoferActualizada(Direccion direccion) {
        super("chofer.direcciondechoferactualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
