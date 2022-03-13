package domain.chofer.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.chofer.aggregate.Chofer;
import domain.chofer.event.DireccionDeChoferActualizada;
import domain.chofer.value.ChoferId;

import java.util.List;

public class NotificarCambioDeDireccionDelChofer extends UseCase<TriggeredEvent<DireccionDeChoferActualizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DireccionDeChoferActualizada> input) {
        var event = input.getDomainEvent();
        var service = getService(SMSChoferService.class).orElseThrow();

        var events = repository().getEventsBy("chofer",event.aggregateRootId());
        var chofer = Chofer.from(ChoferId.of(event.aggregateRootId()), events);

        var esOK = service.enviarMensajeAlChofer(
                chofer.identity(),
                String.format("Se cambio la direccion del chofer"));

        if(esOK){
            emit().onResponse(new ResponseEvents(List.of()));
        }
        throw new BusinessException(event.aggregateRootId(), "El mensaje no pudo ser enviado");

    }
}
