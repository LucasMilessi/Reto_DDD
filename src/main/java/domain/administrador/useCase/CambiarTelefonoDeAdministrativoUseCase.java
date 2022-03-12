package domain.administrador.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.administrador.aggregate.Administrativo;
import domain.administrador.command.CambiarTelefonoDeAdministrativo;

public class CambiarTelefonoDeAdministrativoUseCase extends UseCase<RequestCommand<CambiarTelefonoDeAdministrativo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoDeAdministrativo> input) {
        var command = input.getCommand();
        var administrativo = Administrativo.from(command.getAdministrativoId(), retrieveEvents());
        try {
            administrativo.cambiarTelefonoDeAdministrativo(command.getTelefono());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getAdministrativoId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(administrativo.getUncommittedChanges()));
    }
}
