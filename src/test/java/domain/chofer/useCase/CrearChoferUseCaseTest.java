package domain.chofer.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.chofer.command.CrearChofer;
import domain.chofer.event.ChoferCreado;
import domain.chofer.value.ChoferId;
import domain.chofer.value.Salario;
import domain.generic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearChoferUseCaseTest {

    @Test
    void crearChofer(){
        ChoferId choferId = ChoferId.of("xxxx");
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        EstadoDeViaje estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        Direccion direccion = new Direccion(new Calle("Montevideo"), 960);
        Telefono telefono = new Telefono(598098954474L);
        Salario salario = new Salario(90000);

        var command = new CrearChofer(choferId, nombre, edad, estadoDeViaje, direccion, telefono, salario);
        var useCase = new CrearChoferUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ChoferCreado)events.get(0);
        Assertions.assertEquals("chofer.chofercreado", event.type);
        Assertions.assertEquals("Lucas", event.getNombre().value().nombre());
        Assertions.assertEquals("Milessi", event.getNombre().value().apellido());
        Assertions.assertEquals(23, event.getEdad().value());
        Assertions.assertEquals("Montevideo", event.getDireccion().value().calle().value());
        Assertions.assertEquals(960, event.getDireccion().value().numero());
        Assertions.assertEquals(598098954474L, event.getTelefono().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }

}