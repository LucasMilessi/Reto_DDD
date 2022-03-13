package domain.camión.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.administrador.command.CrearAdministrativo;
import domain.administrador.event.AdministrativoCreado;
import domain.administrador.useCase.CrearAdministrativoUseCase;
import domain.administrador.value.AdministrativoId;
import domain.camión.command.CrearCamion;
import domain.camión.event.CamionCreado;
import domain.camión.value.*;
import domain.generic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCamionUseCaseTest {

    @Test
    void crearCamion(){
        //arrange
        CamionId camionId = CamionId.of("xxxx");
        CantidadDeKM cantidadDeKM = new CantidadDeKM(15236);
        Marca marca = new Marca("Scania");
        EstadoDeViaje estadoDeViaje = new EstadoDeViaje(EstadoDeViaje.Fase.LIBRE);
        CantidadDeCombustible cantidadDeCombustible = new CantidadDeCombustible(50);
        EstadoDeCamion estadoDeCamion = new EstadoDeCamion(new EstadoRueda(100),
                new EstadoDeChasis(100), new EstadoDeMotor(100));

        var command = new CrearCamion(camionId, cantidadDeKM, marca, estadoDeViaje, cantidadDeCombustible, estadoDeCamion);
        var useCase = new CrearCamionUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CamionCreado)events.get(0);
        Assertions.assertEquals("camion.camioncreado", event.type);
        Assertions.assertEquals(15236, event.getCantidadDeKM().value());
        Assertions.assertEquals("Scania", event.getMarca().value());
        Assertions.assertEquals(EstadoDeViaje.Fase.LIBRE, event.getEstadoDeViaje().value());
        Assertions.assertEquals(50, event.getCantidadDeCombustible().value());
        Assertions.assertEquals(100, event.getEstadoDeCamion().value().estadoRueda().value());
        Assertions.assertEquals(100, event.getEstadoDeCamion().value().estadoDeChasis().value());
        Assertions.assertEquals(100, event.getEstadoDeCamion().value().estadoDeMotor().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }

}