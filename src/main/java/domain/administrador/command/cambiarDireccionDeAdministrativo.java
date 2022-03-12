package domain.administrador.command;

import co.com.sofka.domain.generic.Command;
import domain.administrador.value.AdministrativoId;
import domain.generic.Direccion;

public class cambiarDireccionDeAdministrativo extends Command {
    private final AdministrativoId administrativoId;
    private final Direccion direccion;

    public cambiarDireccionDeAdministrativo(AdministrativoId administrativoId, Direccion direccion) {
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
