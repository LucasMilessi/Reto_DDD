package domain.chofer.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.chofer.aggregate.Chofer;
import domain.chofer.command.CambiarDireccionDeChofer;

public class CambiarDireccionDeChoferUseCase extends UseCase<RequestCommand<CambiarDireccionDeChofer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDireccionDeChofer> input) {
        var command = input.getCommand();
        var chofer = Chofer.from(command.getChoferId(), retrieveEvents());
        try{
            if(chofer.direccion().value() == null){
                throw new BusinessException(command.getChoferId().value(), "La dirección no puede estar bacía");
            }
            chofer.cambiarDireccionDeChofer(command.getDireccion());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getChoferId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(chofer.getUncommittedChanges()));
    }
}
