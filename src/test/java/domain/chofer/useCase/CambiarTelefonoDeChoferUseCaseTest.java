package domain.chofer.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.chofer.command.CambiarDireccionDeChofer;
import domain.chofer.command.CambiarTelefonoDeChofer;
import domain.chofer.event.ChoferCreado;
import domain.chofer.event.DireccionDeChoferActualizada;
import domain.chofer.event.TelefonoDeChoferActualizado;
import domain.chofer.value.ChoferId;
import domain.chofer.value.Salario;
import domain.generic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CambiarTelefonoDeChoferUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarTelefonoDeCliente(){
        ChoferId choferId = ChoferId.of("xxxx");
        Telefono telefono = new Telefono(598093256547L);

        var command = new CambiarTelefonoDeChofer(choferId, telefono);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarTelefonoDeChoferUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TelefonoDeChoferActualizado)events.get(0);
        Assertions.assertEquals("chofer.telefonodechoferactualizado", event.type);
        Assertions.assertEquals(598093256547L, event.getTelefono().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());

    }

    private List<DomainEvent> events(){
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        EstadoDeViaje estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        Direccion direccion = new Direccion(new Calle("Montevideo"), 960);
        Telefono telefono = new Telefono(598098954474L);
        Salario salario = new Salario(90000);

        return List.of(new ChoferCreado(nombre, edad, estadoDeViaje, direccion, telefono, salario));
    }

}