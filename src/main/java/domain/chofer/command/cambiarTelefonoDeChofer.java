package domain.chofer.command;

import co.com.sofka.domain.generic.Command;
import domain.chofer.value.ChoferId;
import domain.generic.Telefono;

public class cambiarTelefonoDeChofer extends Command {
    private final ChoferId choferId;
    private final Telefono telefono;

    public cambiarTelefonoDeChofer(ChoferId choferId, Telefono telefono) {
        this.choferId = choferId;
        this.telefono = telefono;
    }

    public ChoferId getChoferId() {
        return choferId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
