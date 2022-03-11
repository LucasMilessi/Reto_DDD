package domain.camión.aggregate;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.CamionEventChange;
import domain.camión.event.CamionCreado;
import domain.camión.event.TrailerAgregado;
import domain.camión.value.TrailerId;
import domain.camión.value.CamionId;
import domain.camión.value.CantidadDeCombustible;
import domain.chofer.ChoferEventChange;
import domain.chofer.value.ChoferId;
import domain.camión.value.CantidadDeKM;
import domain.camión.value.EstadoDeCamion;
import domain.generic.EstadoDeViaje;
import domain.camión.value.Marca;

import java.util.List;

public class Camion extends AggregateEvent<CamionId> {
    protected CantidadDeKM cantidadDeKM;
    protected Marca marca;
    protected EstadoDeViaje estadoDeViaje;
    protected CantidadDeCombustible cantidadDeCombustible;
    protected EstadoDeCamion estadoDeCamion;
    protected TrailerId trailerId;
    protected ChoferId choferId;

    public Camion(CamionId camionId, CantidadDeKM cantidadDeKM, Marca marca, EstadoDeViaje estadoDeViaje, CantidadDeCombustible cantidadDeCombustible, EstadoDeCamion estadoDeCamion) {
        super(camionId);
        appendChange(new CamionCreado(camionId, cantidadDeKM, marca, estadoDeViaje, cantidadDeCombustible, estadoDeCamion)).apply();
    }

    private Camion(CamionId camionId){
        super(camionId);
        subscribe(new CamionEventChange(this));
    }

    public static Camion from(CamionId camionId, List<DomainEvent> eventList){
        Camion camion = new Camion(camionId);
        eventList.forEach(camion::applyEvent);

        return camion;
    }

    public void agregarTrailer(CamionId camionId, TrailerId trailerId){
        appendChange(new TrailerAgregado(camionId, trailerId)).apply();
    }

    /*public List<CamionId> camionesLibres(Camion camion){
    }*/

    public CantidadDeKM cantidadDeKM() {
        return cantidadDeKM;
    }

    public Marca marca() {
        return marca;
    }

    public EstadoDeViaje estadoDeViaje() {
        return estadoDeViaje;
    }

    public CantidadDeCombustible cantidadDeCombustible() {
        return cantidadDeCombustible;
    }

    public EstadoDeCamion estadoDeCamion() {
        return estadoDeCamion;
    }

    public TrailerId trailerId() {
        return trailerId;
    }

    public ChoferId choferId() {
        return choferId;
    }
}
