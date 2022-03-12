package domain.administrador.command;

import co.com.sofka.domain.generic.Command;
import domain.administrador.entity.HistorialDeContratos;
import domain.administrador.value.AdministrativoId;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.Nombre;
import domain.generic.Telefono;

import java.util.Set;

public class CrearAdministrativo extends Command {
    private final AdministrativoId administrativoId;
    private final Nombre nombre;
    private final Edad edad;
    private final Direccion direccion;
    private final Telefono telefono;
    private final Set<HistorialDeContratos> historialDeContratos;

    public CrearAdministrativo(AdministrativoId administrativoId, Nombre nombre, Edad edad, Direccion direccion, Telefono telefono, Set<HistorialDeContratos> historialDeContratos) {
        this.administrativoId = administrativoId;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.historialDeContratos = historialDeContratos;
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

    public Set<HistorialDeContratos> getHistorialDeContratos() {
        return historialDeContratos;
    }
}
