package domain.administrador.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.aggregate.Administrativo;
import domain.administrador.command.CambiarTelefonoDeAdministrativo;
import domain.administrador.event.AdministrativoCreado;
import domain.administrador.event.TelefonoDeAdministrativoActualizado;
import domain.administrador.value.AdministrativoId;
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
class CambiarTelefonoDeAdministrativoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarTelefono(){
        AdministrativoId administrativoId = AdministrativoId.of("xxxx");
        Telefono telefono = new Telefono(599091955579L);

        var command = new CambiarTelefonoDeAdministrativo(administrativoId, telefono);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarTelefonoDeAdministrativoUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TelefonoDeAdministrativoActualizado)events.get(0);
        Assertions.assertEquals("administrador.telefonodeadministrativoactualizado", event.type);
        Assertions.assertEquals(599091955579L, event.getTelefono().value());
        Assertions.assertEquals(administrativoId.value(), event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        Direccion direccion = new Direccion(new Calle("18 de julio"),15);
        Telefono telefono = new Telefono(598098954474L);

        return List.of(new AdministrativoCreado(nombre, edad, direccion, telefono));
    }

}