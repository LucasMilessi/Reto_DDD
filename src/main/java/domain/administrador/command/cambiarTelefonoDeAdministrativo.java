package domain.administrador.command;

import co.com.sofka.domain.generic.Command;
import domain.administrador.value.AdministrativoId;
import domain.generic.Telefono;

public class cambiarTelefonoDeAdministrativo extends Command {
    private final AdministrativoId administrativoId;
    private final Telefono telefono;

    public cambiarTelefonoDeAdministrativo(AdministrativoId administrativoId, Telefono telefono) {
        this.administrativoId = administrativoId;
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public AdministrativoId getAdministrativoId() {
        return administrativoId;
    }
}
