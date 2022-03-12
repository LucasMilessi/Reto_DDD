package domain.administrador.aggregate;

import co.com.sofka.domain.generic.EventChange;
import domain.administrador.aggregate.Administrativo;
import domain.administrador.event.AdministrativoCreado;
import domain.administrador.event.ChoferContratado;
import domain.administrador.event.DireccionDeAdministrativoActualizada;
import domain.administrador.event.TelefonoDeAdministrativoActualizado;

import java.util.HashSet;

public class AdministrativoEventChange extends EventChange {

    public AdministrativoEventChange(Administrativo administrativo) {

        apply((AdministrativoCreado event) -> {
            administrativo.nombre = event.getNombre();
            administrativo.edad = event.getEdad();
            administrativo.direccion = event.getDireccion();
            administrativo.telefono = event.getTelefono();
            administrativo.historialDeContratos = new HashSet<>();
        });

        apply((ChoferContratado event) -> {
            administrativo.choferId = event.getChoferId();
            administrativo.historialDeContratos = new HashSet<>(0);
        });

        apply((DireccionDeAdministrativoActualizada event) -> {
            administrativo.direccion = event.getDireccion();
        });

        apply((TelefonoDeAdministrativoActualizado event) -> {
            administrativo.telefono = event.getTelefono();
        });
    }
}
