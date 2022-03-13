package domain.logistico.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.generic.Calle;
import domain.generic.Direccion;
import domain.generic.Edad;
import domain.generic.Nombre;
import domain.logistico.command.CrearLogistico;
import domain.logistico.event.LogisticoCreado;
import domain.logistico.value.LogisticoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class CrearLogisticoUseCaseTest {

    @Test
    void crearLogistico(){
        LogisticoId logisticoId = LogisticoId.of("xxxx");
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        Direccion direccion = new Direccion(new Calle("florida"), 12);

        var command = new CrearLogistico(logisticoId, nombre, edad,direccion);
        var useCase = new CrearLogisticoUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (LogisticoCreado)events.get(0);
        Assertions.assertEquals("logistico.logisticocreado", event.type);
        Assertions.assertEquals("Lucas", event.getNombre().value().nombre());
        Assertions.assertEquals("Milessi", event.getNombre().value().apellido());
        Assertions.assertEquals(23, event.getEdad().value());
        Assertions.assertEquals("florida", event.getDireccion().value().calle().value());
        Assertions.assertEquals(12, event.getDireccion().value().numero());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }

}