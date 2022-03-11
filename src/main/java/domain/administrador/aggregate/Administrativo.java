package domain.administrador.aggregate;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.AdministrativoEventChange;
import domain.administrador.entity.HistorialDeContratos;
import domain.administrador.event.AdministrativoCreado;
import domain.administrador.event.ChoferContratado;
import domain.administrador.event.DireccionActualizada;
import domain.administrador.value.AdministrativoId;
import domain.chofer.ChoferEventChange;
import domain.chofer.value.ChoferId;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.Nombre;
import domain.generic.Telefono;

import java.util.List;
import java.util.Set;

public class Administrativo extends AggregateEvent<AdministrativoId> {
    protected Nombre nombre;
    protected Edad edad;
    protected Direccion direccion;
    protected Telefono telefono;
    protected ChoferId choferId;
    protected Set<HistorialDeContratos> historialDeContratos;

    public Administrativo(AdministrativoId administrativoId, Nombre nombre, Edad edad, Direccion direccion, Telefono telefono) {
        super(administrativoId);
        appendChange(new AdministrativoCreado(administrativoId, nombre, edad, direccion,telefono)).apply();
    }

    private Administrativo(AdministrativoId administrativoId){
        super(administrativoId);
        subscribe(new AdministrativoEventChange(this));
    }

    public static Administrativo from(AdministrativoId administrativoId, List<DomainEvent> eventList){
        Administrativo administrativo = new Administrativo(administrativoId);
        eventList.forEach(administrativo::applyEvent);

        return administrativo;
    }

    public void contratarChofer(ChoferId choferId, HistorialDeContratos historialDeContratos){
        appendChange(new ChoferContratado(choferId, historialDeContratos)).apply();
    }

    public void cambiarDireccion(AdministrativoId administrativoId, Direccion direccion){
        appendChange(new DireccionActualizada(administrativoId, direccion)).apply();
    }

    /*public Set<HistorialDeContratos> obtenerContratoDeChoferes(ChoferId choferId, HistorialDeContratos historialDeContratos){
    }*/

    public Nombre nombre() {
        return nombre;
    }

    public Edad edad() {
        return edad;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Telefono telefono() {
        return telefono;
    }
}
