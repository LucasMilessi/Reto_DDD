package domain.chofer.command;

import co.com.sofka.domain.generic.Command;
import domain.chofer.value.ChoferId;
import domain.chofer.value.Salario;
import domain.generic.*;

public class CrearChofer extends Command {
    private final ChoferId choferId;
    private final Nombre nombre;
    private final Edad edad;
    private final EstadoDeViaje disponible;
    private final Direccion direccion;
    private final Telefono telefono;
    private final Salario sueldo;

    public CrearChofer(ChoferId choferId, Edad edad, Nombre nombre, EstadoDeViaje disponible, Direccion direccion, Telefono telefono, Salario sueldo) {
        this.choferId = choferId;
        this.nombre = nombre;
        this.edad = edad;
        this.disponible = disponible;
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

    public Edad getEdad() {
        return edad;
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
