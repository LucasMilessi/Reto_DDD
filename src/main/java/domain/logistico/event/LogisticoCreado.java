package domain.logistico.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.value.CamionId;
import domain.chofer.value.ChoferId;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.Nombre;
import domain.logistico.entity.Viaje;
import domain.logistico.value.LogisticoId;

import java.util.Set;

public class LogisticoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Edad edad;
    private final Direccion direccion;
    private final LogisticoId logisticoId;

    public LogisticoCreado(LogisticoId logisticoId, Nombre nombre, Edad edad, Direccion direccion) {
        super("logistico.logisticocreado");
        this.logisticoId = logisticoId;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
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

    public LogisticoId getLogisticoId() {
        return logisticoId;
    }
}
