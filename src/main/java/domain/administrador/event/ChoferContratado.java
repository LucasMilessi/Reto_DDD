package domain.administrador.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.entity.HistorialDeContratos;
import domain.chofer.aggregate.Chofer;
import domain.chofer.value.ChoferId;

import java.util.HashSet;
import java.util.Set;

public class ChoferContratado extends DomainEvent {
    private final ChoferId choferId;

    public ChoferContratado(ChoferId choferId) {
        super("administrador.chofercontratado");
        this.choferId = choferId;
    }

    public ChoferId getChoferId() {
        return choferId;
    }

}
