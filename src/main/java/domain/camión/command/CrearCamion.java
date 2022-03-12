package domain.camión.command;

import co.com.sofka.domain.generic.Command;
import domain.camión.value.*;
import domain.generic.EstadoDeViaje;

public class CrearCamion extends Command {
    private final CamionId camionId;
    private final CantidadDeKM cantidadDeKM;
    private final Marca marca;
    private final EstadoDeViaje estadoDeViaje;
    private final CantidadDeCombustible cantidadDeCombustible;
    private final EstadoDeCamion estadoDeCamion;

    public CrearCamion(CamionId camionId, CantidadDeKM cantidadDeKM, Marca marca, EstadoDeViaje estadoDeViaje, CantidadDeCombustible cantidadDeCombustible, EstadoDeCamion estadoDeCamion) {
        this.camionId = camionId;
        this.cantidadDeKM = cantidadDeKM;
        this.marca = marca;
        this.estadoDeViaje = estadoDeViaje;
        this.cantidadDeCombustible = cantidadDeCombustible;
        this.estadoDeCamion = estadoDeCamion;
    }

    public CamionId getCamionId() {
        return camionId;
    }

    public CantidadDeKM getCantidadDeKM() {
        return cantidadDeKM;
    }

    public Marca getMarca() {
        return marca;
    }

    public EstadoDeViaje getEstadoDeViaje() {
        return estadoDeViaje;
    }

    public CantidadDeCombustible getCantidadDeCombustible() {
        return cantidadDeCombustible;
    }

    public EstadoDeCamion getEstadoDeCamion() {
        return estadoDeCamion;
    }
}
