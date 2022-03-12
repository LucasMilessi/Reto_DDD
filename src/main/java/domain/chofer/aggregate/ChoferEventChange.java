package domain.chofer.aggregate;

import co.com.sofka.domain.generic.EventChange;
import domain.chofer.aggregate.Chofer;
import domain.chofer.event.ChoferCreado;
import domain.chofer.event.DireccionDeChoferActualizada;
import domain.chofer.event.TelefonoDeChoferActualizado;
import domain.generic.EstadoDeViaje;

public class ChoferEventChange extends EventChange {

    public ChoferEventChange(Chofer chofer) {

        apply((ChoferCreado event) -> {
            chofer.nombre = event.getNombre();
            chofer.direccion = event.getDireccion();
            chofer.disponible = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
            chofer.telefono = event.getTelefono();
            chofer.sueldo = event.getSueldo();
        });

        apply((DireccionDeChoferActualizada event) -> {
            chofer.direccion = event.getDireccion();
        });

        apply((TelefonoDeChoferActualizado event) -> {
            chofer.telefono = event.getTelefono();
        });
    }
}
