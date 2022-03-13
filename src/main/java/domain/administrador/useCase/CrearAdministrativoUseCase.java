package domain.administrador.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.administrador.aggregate.Administrativo;
import domain.administrador.command.CrearAdministrativo;

public class CrearAdministrativoUseCase extends UseCase<RequestCommand<CrearAdministrativo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAdministrativo> input) {
        var command = input.getCommand();
        var administrativo = new Administrativo(command.getAdministrativoId(),command.getNombre(),command.getEdad(),
                                    command.getDireccion(),command.getTelefono());

        emit().onResponse(new ResponseEvents(administrativo.getUncommittedChanges()));
    }

}
