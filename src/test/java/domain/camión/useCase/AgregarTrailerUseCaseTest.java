package domain.camión.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.command.AgregarTrailer;
import domain.camión.event.CamionCreado;
import domain.camión.event.TrailerAgregado;
import domain.camión.value.*;
import domain.generic.EstadoDeViaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarTrailerUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarTrailer(){
        CamionId camionId = CamionId.of("xxxx");
        TrailerId trailerId = TrailerId.of("cccc");

        var command = new AgregarTrailer(camionId, trailerId);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new AgregarTrailerUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TrailerAgregado)events.get(0);
        Assertions.assertEquals("camion.traileragregado", event.type);
        Assertions.assertEquals("cccc", event.getTrailerId().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }

    private List<DomainEvent> events(){
        CantidadDeKM cantidadDeKM = new CantidadDeKM(15000);
        Marca marca = new Marca("Scania");
        EstadoDeViaje estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        CantidadDeCombustible cantidadDeCombustible = new CantidadDeCombustible(50);
        EstadoDeCamion estadoDeCamion = new EstadoDeCamion(new EstadoRueda(100),new EstadoDeChasis(100),new EstadoDeMotor(100));

        return List.of(new CamionCreado(cantidadDeKM,marca,estadoDeViaje,cantidadDeCombustible,estadoDeCamion));
    }


}