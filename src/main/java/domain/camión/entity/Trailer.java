package domain.camión.entity;

import co.com.sofka.domain.generic.Entity;
import domain.camión.value.TrailerId;
import domain.camión.value.CapacidadDeCarga;
import domain.camión.value.EstadoDeTrailer;

public class Trailer extends Entity<TrailerId> {
    private CapacidadDeCarga capacidadDeCarga;
    private EstadoDeTrailer estadoDeTrailer;

    public Trailer(TrailerId entityId, CapacidadDeCarga capacidadDeCarga, EstadoDeTrailer estadoDeTrailer) {
        super(entityId);
        this.capacidadDeCarga = capacidadDeCarga;
        this.estadoDeTrailer = estadoDeTrailer;
    }

    public CapacidadDeCarga capacidadDeCarga() {
        return capacidadDeCarga;
    }

    public EstadoDeTrailer estadoDeTrailer() {
        return estadoDeTrailer;
    }
}
