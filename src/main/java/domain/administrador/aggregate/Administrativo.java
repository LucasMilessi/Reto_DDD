package domain.administrador.aggregate;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.entity.HistorialDeContratos;
import domain.administrador.event.AdministrativoCreado;
import domain.administrador.event.ChoferContratado;
import domain.administrador.event.DireccionDeAdministrativoActualizada;
import domain.administrador.event.TelefonoDeAdministrativoActualizado;
import domain.administrador.value.AdministrativoId;
import domain.chofer.value.ChoferId;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.Nombre;
import domain.generic.Telefono;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Administrativo extends AggregateEvent<AdministrativoId> {
    protected Nombre nombre;
    protected Edad edad;
    protected Direccion direccion;
    protected Telefono telefono;
    protected ChoferId choferId;
    protected Set<HistorialDeContratos> historialDeContratos;

    public Administrativo(AdministrativoId administrativoId, Nombre nombre, Edad edad, Direccion direccion, Telefono telefono, Set<HistorialDeContratos> historialDeContratos) {
        super(administrativoId);
        appendChange(new AdministrativoCreado(nombre, edad, direccion,telefono, historialDeContratos)).apply();
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

    public void cambiarDireccionDeAdministrativo(Direccion direccion){
        appendChange(new DireccionDeAdministrativoActualizada(direccion)).apply();
    }

    public void cambiarTelefonoDeAdministrativo(Telefono telefono){
        appendChange(new TelefonoDeAdministrativoActualizado(telefono)).apply();
    }

    public Optional<HistorialDeContratos> obtenerContratoDeChoferId(ChoferId choferId){
        return historialDeContratos
                .stream()
                .filter(historialDeContratos1 -> historialDeContratos1.identity().equals(choferId))
                .findFirst();
    }

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

    public ChoferId choferId() {
        return choferId;
    }

    public Set<HistorialDeContratos> HistorialDeContratos() {
        return historialDeContratos;
    }
}
