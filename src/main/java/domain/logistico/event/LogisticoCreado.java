package domain.logistico.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.Nombre;

public class LogisticoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Edad edad;
    private final Direccion direccion;

    public LogisticoCreado(Nombre nombre, Edad edad, Direccion direccion) {
        super("logistico.logisticocreado");
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

}
