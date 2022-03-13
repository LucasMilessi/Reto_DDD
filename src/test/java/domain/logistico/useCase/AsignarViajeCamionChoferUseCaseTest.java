package domain.logistico.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.camión.event.CamionCreado;
import domain.camión.value.*;
import domain.chofer.event.ChoferCreado;
import domain.chofer.value.ChoferId;
import domain.chofer.value.Salario;
import domain.generic.*;
import domain.logistico.command.AsignarViajeCamionChofer;
import domain.logistico.event.LogisticoCreado;
import domain.logistico.event.ViajeCamionAsignadoAlChofer;
import domain.logistico.value.LogisticoId;
import domain.logistico.value.ViajeId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AsignarViajeCamionChoferUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void asignarViajeCamionChoferUseCaseTest(){
        //arrange
        LogisticoId logisticoId = LogisticoId.of("cccc");
        ViajeId viajeId = ViajeId.of("aaaa");
        ChoferId choferId = ChoferId.of("vvvv");
        CamionId camionId = CamionId.of("xxxx");


        var command = new AsignarViajeCamionChofer(logisticoId,viajeId,choferId,camionId);
        Mockito.when(repository.getEventsBy(null)).thenReturn(logistico());
        Mockito.when(repository.getEventsBy(null)).thenReturn(camion());
        Mockito.when(repository.getEventsBy(null)).thenReturn(chofer());

        var useCase = new AsignarViajeCamionChoferUseCase();
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ViajeCamionAsignadoAlChofer)events.get(0);
        Assertions.assertEquals("logistico.viajecamionasignadoalchofer", event.type);
        Assertions.assertEquals("aaaa",event.getViajeId().value());
        Assertions.assertEquals("vvvv",event.getChoferId().value());
        Assertions.assertEquals("xxxx",event.getCamionId().value());
        Assertions.assertEquals("cccc",event.aggregateRootId());
    }

    private List<DomainEvent> logistico(){
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        Direccion direccion = new Direccion(new Calle("florida"), 12);

        return List.of(new LogisticoCreado(nombre, edad, direccion));
    }

    private List<DomainEvent> camion(){
        CantidadDeKM cantidadDeKM = new CantidadDeKM(15236);
        Marca marca = new Marca("Scania");
        EstadoDeViaje estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        CantidadDeCombustible cantidadDeCombustible = new CantidadDeCombustible(50);
        EstadoDeCamion estadoDeCamion = new EstadoDeCamion(new EstadoRueda(100),
                new EstadoDeChasis(100), new EstadoDeMotor(100));

        return List.of(new CamionCreado(cantidadDeKM,marca,estadoDeViaje,cantidadDeCombustible,estadoDeCamion));
    }

    private List<DomainEvent> chofer(){
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        EstadoDeViaje estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        Direccion direccion = new Direccion(new Calle("Montevideo"), 960);
        Telefono telefono = new Telefono(598098954474L);
        Salario salario = new Salario(90000);

        return List.of(new ChoferCreado(nombre, edad, estadoDeViaje, direccion, telefono, salario));
    }



}