package domain.camión.aggregate;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.event.CamionCreado;
import domain.camión.event.TrailerAgregado;
import domain.camión.value.*;
import domain.chofer.value.ChoferId;
import domain.generic.EstadoDeViaje;
import org.jetbrains.annotations.NotNull;

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
        appendChange(new CamionCreado(cantidadDeKM, marca, estadoDeViaje, cantidadDeCombustible, estadoDeCamion)).apply();
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

    public void agregarTrailer(TrailerId trailerId){
        appendChange(new TrailerAgregado(trailerId)).apply();
    }

    public boolean camionAsignado(){
        return estadoDeViaje.value().equals(EstadoDeViaje.Fase.EN_VIAJE);
    }

    public CantidadDeCombustible cantidadDeCombustible(@NotNull Camion camion){
        return camion.cantidadDeCombustible();
    }

    public CantidadDeKM cantidadDeKM(Camion camion){
        return camion.cantidadDeKM;
    }

    public EstadoDeViaje.Fase obtenerEstadoViajeDelCamion(Camion camion){
        if(camion.estadoDeCamion.value().equals(EstadoDeViaje.Fase.LIBRE)){
            return EstadoDeViaje.Fase.LIBRE;
        }
        return EstadoDeViaje.Fase.EN_VIAJE;
    }

    public EstadoDeCamion obtenerEstadoDelCamion(Camion camion){
        return camion.estadoDeCamion;
    }

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
