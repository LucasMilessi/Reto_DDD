package domain.camión.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.camión.aggregate.Camion;
import domain.camión.command.AgregarTrailer;

public class AgregarTrailerUseCase extends UseCase<RequestCommand<AgregarTrailer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTrailer> input) {
        var command = input.getCommand();
        var camion = Camion.from(command.getCamionId(), retrieveEvents());
        try{
            camion.agregarTrailer(command.getTrailerId());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getCamionId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(camion.getUncommittedChanges()));

    }
}
