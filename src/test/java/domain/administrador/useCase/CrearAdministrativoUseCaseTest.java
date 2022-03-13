package domain.administrador.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.administrador.command.CrearAdministrativo;
import domain.administrador.event.AdministrativoCreado;
import domain.administrador.value.AdministrativoId;
import domain.generic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearAdministrativoUseCaseTest {

    @Test
    void crearAdministrativo(){
        //arrange
        AdministrativoId administrativoId = AdministrativoId.of("xxxx");
        Nombre nombre = new Nombre("Lucas","Milessi");
        Edad edad = new Edad(23);
        Direccion direccion = new Direccion(new Calle("florida"), 12);
        Telefono telefono = new Telefono(598098954474L);

        var command = new CrearAdministrativo(administrativoId, nombre, edad, direccion, telefono);
        var useCase = new CrearAdministrativoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (AdministrativoCreado)events.get(0);
        Assertions.assertEquals("administrador.administrativocreado", event.type);
        Assertions.assertEquals("Lucas", event.getNombre().value().nombre());
        Assertions.assertEquals("Milessi", event.getNombre().value().apellido());
        Assertions.assertEquals(23, event.getEdad().value());
        Assertions.assertEquals("florida", event.getDireccion().value().calle().value());
        Assertions.assertEquals(12, event.getDireccion().value().numero());
        Assertions.assertEquals(598098954474L, event.getTelefono().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }
}