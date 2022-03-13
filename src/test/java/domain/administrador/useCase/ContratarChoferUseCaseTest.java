package domain.administrador.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.administrador.command.ContratarChofer;
import domain.administrador.entity.HistorialDeContratos;
import domain.administrador.event.AdministrativoCreado;
import domain.administrador.event.ChoferContratado;
import domain.administrador.value.AdministrativoId;
import domain.chofer.value.ChoferId;
import domain.generic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ContratarChoferUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void contratarChofer(){
        AdministrativoId administrativoId = AdministrativoId.of("cccc");
        ChoferId choferId = ChoferId.of("xxxx");

        var command = new ContratarChofer(administrativoId, choferId);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new ContratarChoferUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ChoferContratado)events.get(0);
        Assertions.assertEquals("administrador.chofercontratado", event.type);
        Assertions.assertEquals("xxxx", event.getChoferId().value());
        Assertions.assertEquals("cccc", event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        Nombre nombre = new Nombre("Lucas", "Milessi");
        Edad edad = new Edad(23);
        Direccion direccion = new Direccion(new Calle("18 de julio"),15);
        Telefono telefono = new Telefono(598098954474L);

        return List.of(new AdministrativoCreado(nombre, edad, direccion, telefono));
    }

}