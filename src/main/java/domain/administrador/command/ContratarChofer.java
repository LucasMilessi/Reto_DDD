package domain.administrador.command;

import co.com.sofka.domain.generic.Command;
import domain.administrador.entity.HistorialDeContratos;
import domain.administrador.value.AdministrativoId;
import domain.chofer.value.ChoferId;

public class ContratarChofer extends Command {
    private final AdministrativoId administrativoId;
    private final ChoferId choferId;
    private final HistorialDeContratos historialDeContratos;


    public ContratarChofer(AdministrativoId administrativoId, ChoferId choferId, HistorialDeContratos historialDeContratos) {
        this.administrativoId = administrativoId;
        this.choferId = choferId;
        this.historialDeContratos = historialDeContratos;
    }

    public AdministrativoId getAdministrativoId() {
        return administrativoId;
    }

    public ChoferId getChoferId() {
        return choferId;
    }

    public HistorialDeContratos getHistorialDeContratos() {
        return historialDeContratos;
    }
}
