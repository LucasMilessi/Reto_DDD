package domain.administrador.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.value.AdministrativoId;
import domain.generic.Direccion;

public class DireccionActualizada extends DomainEvent {
    private final AdministrativoId administrativoId;
    private final Direccion direccion;

    public DireccionActualizada(AdministrativoId administrativoId, Direccion direccion) {
        super("administrador.DireccionActualizada");
        this.administrativoId = administrativoId;
        this.direccion = direccion;
    }

    public AdministrativoId getAdministrativoId() {
        return administrativoId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
