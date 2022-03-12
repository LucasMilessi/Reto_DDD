package domain.logistico.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.Nombre;
import domain.logistico.value.LogisticoId;

public class CrearLogistico extends Command {
    private final LogisticoId logisticoId;
    private final Nombre nombre;
    private final Edad edad;
    private final Direccion direccion;

    public CrearLogistico(LogisticoId logisticoId, Nombre nombre, Edad edad, Direccion direccion) {
        this.logisticoId = logisticoId;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public LogisticoId getLogisticoId() {
        return logisticoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
