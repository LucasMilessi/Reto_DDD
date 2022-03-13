package domain.chofer.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
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
class NotificarCambioDeDireccionDelChoferTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private SMSChoferService servicio;

    @Test
    void enviarMensajeChofer() {

        var evento = new DireccionDeChoferActualizada(new Direccion(new Calle("florida"), 1070));

        evento.setAggregateRootId("xxxx");

        var useCase = new NotificarCambioDeDireccionDelChofer();
        Mockito.when(repository.getEventsBy("chofer","xxxx")).thenReturn(historico());
        Mockito.when(servicio.enviarMensajeAlChofer(Mockito.any(ChoferId.class), Mockito.anyString())).thenReturn(true);

        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(servicio));

        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new TriggeredEvent<>(evento)).isPresent();
        Assertions.assertTrue(isPresent);
    }

    @Test
    void errorDeEnvioDeMensaje() {

        var evento = new DireccionDeChoferActualizada(new Direccion(new Calle("florida"), 1070));

        evento.setAggregateRootId("xxxx");

        var useCase = new NotificarCambioDeDireccionDelChofer();
        Mockito.when(repository.getEventsBy("chofer","xxxx")).thenReturn(historico());
        Mockito.when(servicio.enviarMensajeAlChofer(Mockito.any(ChoferId.class), Mockito.anyString())).thenReturn(false);

        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(servicio));

        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor("xxxx")
                    .syncExecutor(useCase, new TriggeredEvent<>(evento));
        }).getMessage();

        Assertions.assertEquals("El mensaje no pudo ser enviado", mensaje);
    }

    private List<DomainEvent> historico() {
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        EstadoDeViaje estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        Direccion direccion = new Direccion(new Calle("Montevideo"), 960);
        Telefono telefono = new Telefono(598098954474L);
        Salario salario = new Salario(90000);

        return List.of(new ChoferCreado(nombre, edad, estadoDeViaje, direccion, telefono, salario));
    }

}