package domain.chofer.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.chofer.value.ChoferId;
import domain.chofer.value.Salario;
import domain.generic.*;

public class ChoferCreado extends DomainEvent {
    private final ChoferId choferId;
    private final Nombre nombre;
    private final EstadoDeViaje disponible;
    private final Direccion direccion;
    private final Telefono telefono;
    private final Salario sueldo;

    public ChoferCreado(ChoferId choferId, Nombre nombre, EstadoDeViaje disponible, Direccion direccion, Telefono telefono, Salario sueldo) {
        super("chofer.chofercreado");
        this.choferId = choferId;
        this.nombre = nombre;
        this.disponible = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        this.direccion = direccion;
        this.telefono = telefono;
        this.sueldo = sueldo;
    }

    public ChoferId getChoferId() {
        return choferId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public EstadoDeViaje getDisponible() {
        return disponible;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Salario getSueldo() {
        return sueldo;
    }
}
