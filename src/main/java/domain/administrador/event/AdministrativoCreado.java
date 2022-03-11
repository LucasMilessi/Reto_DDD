package domain.administrador.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.value.AdministrativoId;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.Nombre;
import domain.generic.Telefono;

public class AdministrativoCreado extends DomainEvent {
    private final AdministrativoId administrativoId;
    private final Nombre nombre;
    private final Edad edad;
    private final Direccion direccion;
    private final Telefono telefono;

    public AdministrativoCreado(AdministrativoId administrativoId, Nombre nombre, Edad edad, Direccion direccion, Telefono telefono) {
        super("administrador.administrativocreado");
        this.administrativoId = administrativoId;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public AdministrativoId getAdministrativoId() {
        return administrativoId;
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

    public Telefono getTelefono() {
        return telefono;
    }
}
