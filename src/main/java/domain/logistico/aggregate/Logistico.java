package domain.logistico.aggregate;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.value.CamionId;
import domain.chofer.value.ChoferId;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.EstadoDeViaje;
import domain.generic.Nombre;
import domain.logistico.entity.Viaje;
import domain.logistico.event.LogisticoCreado;
import domain.logistico.event.ViajeCamionAsignadoAlChofer;
import domain.logistico.value.LogisticoId;
import domain.logistico.value.ViajeId;

import java.util.List;
import java.util.Set;

public class Logistico extends AggregateEvent<LogisticoId> {
    protected Nombre nombre;
    protected Edad edad;
    protected Direccion direccion;
    protected ChoferId choferId;
    protected CamionId camionId;
    protected ViajeId viajeId;
    protected Set<Viaje> viaje;

    public Logistico(LogisticoId logisticoId, Nombre nombre, Edad edad, Direccion direccion) {
        super(logisticoId);
        appendChange(new LogisticoCreado(nombre, edad, direccion)).apply();
    }

    private Logistico(LogisticoId logisticoId){
        super(logisticoId);
        subscribe(new LogisticoEventChange(this));
    }

    public static Logistico from(LogisticoId logisticoId, List<DomainEvent> eventList){
        Logistico logistico = new Logistico(logisticoId);
        eventList.forEach(logistico::applyEvent);

        return logistico;
    }
    
    public void asignarViajeCamionChofer(ViajeId viajeId, ChoferId choferId, CamionId camionId){
        appendChange(new ViajeCamionAsignadoAlChofer(viajeId, choferId, camionId)).apply();
    }

    public List<ViajeId> viajesDisponibles(){
        return (List<ViajeId>) viaje
                .stream()
                .filter(viaje1 -> viaje1.estadoDeViaje().equals(EstadoDeViaje.Fase.LIBRE));
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

    public ChoferId choferId() {
        return choferId;
    }

    public CamionId camionId() {
        return camionId;
    }

    public ViajeId viajeId() {
        return viajeId;
    }
}
