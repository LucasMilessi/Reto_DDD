package domain.logistico.entity;

import co.com.sofka.domain.generic.Entity;
import domain.generic.Descripcion;
import domain.logistico.value.DireccionDeCargaDescarga;
import domain.generic.EstadoDeViaje;
import domain.logistico.value.ViajeId;

public class Viaje extends Entity<ViajeId> {
    private Descripcion descripcion;
    private DireccionDeCargaDescarga direccionDeCarga;
    private DireccionDeCargaDescarga direccionDescarga;
    private EstadoDeViaje estadoDeViaje;

    public Viaje(ViajeId entityId, Descripcion descripcion, DireccionDeCargaDescarga direccionDeCarga, DireccionDeCargaDescarga direccionDescarga, EstadoDeViaje estadoDeViaje) {
        super(entityId);
        this.descripcion = descripcion;
        this.direccionDeCarga = direccionDeCarga;
        this.direccionDescarga = direccionDescarga;
        this.estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
    }

    public void enViaje(){
        this.estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.EN_VIAJE);
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public DireccionDeCargaDescarga direccionDeCarga() {
        return direccionDeCarga;
    }

    public DireccionDeCargaDescarga direccionDescarga() {
        return direccionDescarga;
    }

    public EstadoDeViaje estadoDeViaje() {
        return estadoDeViaje;
    }
}
