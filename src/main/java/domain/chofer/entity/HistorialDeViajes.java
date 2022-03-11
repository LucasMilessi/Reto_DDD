package domain.chofer.entity;

import co.com.sofka.domain.generic.Entity;
import domain.chofer.value.HistorialDeViajesId;
import domain.generic.Descripcion;
import domain.generic.FechaHora;
import domain.generic.Titulo;

public class HistorialDeViajes extends Entity<HistorialDeViajesId> {
    private Titulo titulo;
    private Descripcion descripcion;
    private FechaHora fechaHora;

    public HistorialDeViajes(HistorialDeViajesId entityId, Titulo titulo, Descripcion descripcion, FechaHora fechaHora) {
        super(entityId);
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
    }

    public Titulo titulo() {
        return titulo;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public FechaHora fechaHora() {
        return fechaHora;
    }
}
