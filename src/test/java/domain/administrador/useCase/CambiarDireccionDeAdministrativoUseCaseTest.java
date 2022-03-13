package domain.administrador.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.aggregate.Administrativo;
import domain.administrador.command.CambiarDireccionDeAdministrativo;
import domain.administrador.event.AdministrativoCreado;
import domain.administrador.event.DireccionDeAdministrativoActualizada;
import domain.administrador.value.AdministrativoId;
import domain.generic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CambiarDireccionDeAdministrativoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarDireccionDeAdministrativo(){
        AdministrativoId administrativoId = AdministrativoId.of("xxxx");
        Direccion direccion = new Direccion(new Calle("florida"), 14);

        var command = new CambiarDireccionDeAdministrativo(administrativoId, direccion);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarDireccionDeAdministrativoUseCase();
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DireccionDeAdministrativoActualizada)events.get(0);
        Assertions.assertEquals("administrador.DireccionActualizada", event.type);
        Assertions.assertEquals("florida", event.getDireccion().value().calle().value());
        Assertions.assertEquals(14, event.getDireccion().value().numero());
        Assertions.assertEquals("xxxx",event.aggregateRootId());

    }

    private List<DomainEvent> events() {
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        Direccion direccion = new Direccion(new Calle("18 de julio"),15);
        Telefono telefono = new Telefono(598098954474L);

        return List.of(new AdministrativoCreado(nombre, edad, direccion, telefono));
    }
}