package domain.administrador.entity;

import co.com.sofka.domain.generic.Entity;
import domain.administrador.value.HistorialContratosId;
import domain.generic.Descripcion;
import domain.generic.FechaHora;
import domain.generic.Nombre;
import domain.generic.Titulo;

public class HistorialDeContratos extends Entity<HistorialContratosId> {
    private Nombre nombre;
    private Titulo titulo;
    private Descripcion descripcion;
    private FechaHora fecha;


    public HistorialDeContratos(HistorialContratosId historialContratosId, Nombre nombre, Titulo titulo, Descripcion descripcion, FechaHora fecha) {
        super(historialContratosId);
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Titulo titulo() {
        return titulo;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public FechaHora fecha() {
        return fecha;
    }
}
