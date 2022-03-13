package domain.logistico.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.generic.EstadoDeViaje;
import domain.logistico.aggregate.Logistico;
import domain.logistico.command.AsignarViajeCamionChofer;

public class AsignarViajeCamionChoferUseCase extends UseCase<RequestCommand<AsignarViajeCamionChofer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarViajeCamionChofer> input) {
        var command = input.getCommand();
        var logistico = Logistico.from(command.getLogisticoId(), retrieveEvents());
        try {
            logistico.asignarViajeCamionChofer(command.getViajeId(), command.getChoferId(), command.getCamionId());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getLogisticoId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(logistico.getUncommittedChanges()));
    }
}
