package domain.chofer.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.chofer.aggregate.Chofer;
import domain.chofer.command.CambiarTelefonoDeChofer;

public class CambiarTelefonoDeChoferUseCase extends UseCase<RequestCommand<CambiarTelefonoDeChofer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoDeChofer> input) {
        var command = input.getCommand();
        var chofer = Chofer.from(command.getChoferId(), retrieveEvents());
        try{
            if(chofer.telefono().value() < 9 && chofer.telefono().value() > 9){
                throw new BusinessException(command.getChoferId().value(), "El numero de telefono debe de tener 9 digitos.");
            }
            chofer.cambiarTelefonoDeChofer(command.getTelefono());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getChoferId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(chofer.getUncommittedChanges()));
    }
}
