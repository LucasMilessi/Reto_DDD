package domain.chofer.command;

import co.com.sofka.domain.generic.Command;
import domain.chofer.value.ChoferId;
import domain.generic.Direccion;

public class CambiarDireccionDeChofer extends Command {
    private final ChoferId choferId;
    private final Direccion direccion;

    public CambiarDireccionDeChofer(ChoferId choferId, Direccion direccion) {
        this.choferId = choferId;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public ChoferId getChoferId() {
        return choferId;
    }
}
