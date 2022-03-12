package domain.chofer.command;

import co.com.sofka.domain.generic.Command;
import domain.chofer.value.ChoferId;
import domain.generic.Direccion;

public class cambiarDireccionDeChofer extends Command {
    private final ChoferId choferId;
    private final Direccion direccion;

    public cambiarDireccionDeChofer(ChoferId choferId, Direccion direccion) {
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
