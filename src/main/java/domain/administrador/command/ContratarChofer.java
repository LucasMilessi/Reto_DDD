package domain.administrador.command;

import co.com.sofka.domain.generic.Command;
import domain.administrador.entity.HistorialDeContratos;
import domain.administrador.value.AdministrativoId;
import domain.chofer.value.ChoferId;

public class ContratarChofer extends Command {
    private final AdministrativoId administrativoId;
    private final ChoferId choferId;


    public ContratarChofer(AdministrativoId administrativoId, ChoferId choferId) {
        this.administrativoId = administrativoId;
        this.choferId = choferId;
    }

    public AdministrativoId getAdministrativoId() {
        return administrativoId;
    }

    public ChoferId getChoferId() {
        return choferId;
    }
}
