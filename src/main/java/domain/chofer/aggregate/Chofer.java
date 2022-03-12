package domain.chofer.aggregate;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.chofer.event.ChoferCreado;
import domain.chofer.event.DireccionDeChoferActualizada;
import domain.chofer.event.TelefonoDeChoferActualizado;
import domain.chofer.value.ChoferId;
import domain.chofer.entity.HistorialDeViajes;
import domain.chofer.value.HistorialDeViajesId;
import domain.chofer.value.Salario;
import domain.generic.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Chofer extends AggregateEvent<ChoferId> {
    protected Nombre nombre;
    protected Edad edad;
    protected EstadoDeViaje disponible;
    protected Direccion direccion;
    protected Telefono telefono;
    protected Salario sueldo;
    protected Set<HistorialDeViajes> viajesRealizados;

    public Chofer(ChoferId choferId, Nombre nombre, Edad edad, EstadoDeViaje disponible, Direccion direccion, Telefono telefono, Salario sueldo) {
        super(choferId);
        appendChange(new ChoferCreado(nombre, edad, disponible, direccion, telefono, sueldo)).apply();
    }

    private Chofer(ChoferId choferId){
        super(choferId);
        subscribe(new ChoferEventChange(this));
    }

    public static Chofer from(ChoferId choferId, List<DomainEvent> eventList){
        Chofer chofer = new Chofer(choferId);
        eventList.forEach(chofer::applyEvent);

        return chofer;
    }

    public void cambiarDireccionDeChofer(Direccion direccion){
        appendChange(new DireccionDeChoferActualizada(direccion)).apply();
    }

    public void cambiarTelefonoDeChofer(Telefono telefono){
        appendChange(new TelefonoDeChoferActualizado(telefono)).apply();
    }

    public Optional<HistorialDeViajes> obtenerHistorialDeViajeId(HistorialDeViajesId historialDeViajesId){
        return viajesRealizados
                .stream()
                .filter(viajesRealizados1 -> viajesRealizados1.identity().equals(historialDeViajesId))
                .findFirst();
    }

    public boolean viajeAsignado(){
        return disponible.value().equals(EstadoDeViaje.Fase.EN_VIAJE);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Edad edad() {
        return edad;
    }

    public EstadoDeViaje disponible() {
        return disponible;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Salario sueldo() {
        return sueldo;
    }

    public Set<HistorialDeViajes> viajesRealizados() {
        return viajesRealizados;
    }
}
