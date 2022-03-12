package domain.administrador.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.value.AdministrativoId;
import domain.generic.Direccion;

public class DireccionDeAdministrativoActualizada extends DomainEvent {
    private final Direccion direccion;

    public DireccionDeAdministrativoActualizada(Direccion direccion) {
        super("administrador.DireccionActualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
