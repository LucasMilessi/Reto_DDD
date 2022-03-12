package domain.chofer.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.chofer.value.ChoferId;
import domain.generic.Telefono;

public class TelefonoDeChoferActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoDeChoferActualizado(Telefono telefono) {
        super("chofer.telefonodechoferactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
