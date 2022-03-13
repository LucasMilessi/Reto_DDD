package domain.chofer.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.chofer.command.CambiarDireccionDeChofer;
import domain.chofer.event.ChoferCreado;
import domain.chofer.event.DireccionDeChoferActualizada;
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

@ExtendWith(MockitoExtension.class)
class CambiarDireccionDeChoferUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarDireccionDeChofer(){

        ChoferId choferId = ChoferId.of("xxxx");
        Direccion direccion = new Direccion(new Calle("Leandro Gomez"), 1070);

        var command = new CambiarDireccionDeChofer(choferId, direccion);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarDireccionDeChoferUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DireccionDeChoferActualizada)events.get(0);
        Assertions.assertEquals("chofer.direcciondechoferactualizada", event.type);
        Assertions.assertEquals("Leandro Gomez", event.getDireccion().value().calle().value());
        Assertions.assertEquals(1070, event.getDireccion().value().numero());
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