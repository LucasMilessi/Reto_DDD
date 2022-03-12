package domain.logistico.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.generic.EstadoDeViaje;
import domain.logistico.aggregate.Logistico;
import domain.logistico.command.asignarViajeCamionChofer;

public class asignarViajeCamionChoferUseCase extends UseCase<RequestCommand<asignarViajeCamionChofer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<asignarViajeCamionChofer> input) {
        var command = input.getCommand();
        var logistico = Logistico.from(command.getLogisticoId(), retrieveEvents());
        try {
            if(logistico.choferId().equals(EstadoDeViaje.Fase.EN_VIAJE)){
                throw new BusinessException(command.getChoferId().value(), "El chofer se encuentra en un viaje, " +
                        "no se le pueden asignar viajes por el momento.");
            }else if (logistico.camionId().equals(EstadoDeViaje.Fase.EN_VIAJE)){
                throw new BusinessException(command.getCamionId().value(), "El camion esta realizando un viaje, " +
                        "no se puede asignar otro viaje.");
            }
            logistico.asignarViajeCamionChofer(command.getViajeId(), command.getChoferId(), command.getCamionId());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getLogisticoId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(logistico.getUncommittedChanges()));
    }
}
