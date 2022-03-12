package domain.administrador.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.administrador.aggregate.Administrativo;
import domain.administrador.command.CambiarDireccionDeAdministrativo;

public class CambiarDireccionDeAdministrativoUseCase extends UseCase<RequestCommand<CambiarDireccionDeAdministrativo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDireccionDeAdministrativo> input) {
        var command = input.getCommand();
        var administrativo = Administrativo.from(command.getAdministrativoId(), retrieveEvents());
        try{
            administrativo.cambiarDireccionDeAdministrativo(command.getDireccion());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getAdministrativoId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(administrativo.getUncommittedChanges()));
    }
}
