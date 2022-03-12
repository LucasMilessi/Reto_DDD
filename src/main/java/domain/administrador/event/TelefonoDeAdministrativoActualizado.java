package domain.administrador.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.value.AdministrativoId;
import domain.generic.Telefono;

public class TelefonoDeAdministrativoActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoDeAdministrativoActualizado(Telefono telefono) {
        super("administrador.telefonodeadministrativoactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
