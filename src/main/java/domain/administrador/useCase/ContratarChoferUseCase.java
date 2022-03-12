package domain.administrador.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.administrador.aggregate.Administrativo;
import domain.administrador.command.ContratarChofer;

public class ContratarChoferUseCase extends UseCase<RequestCommand<ContratarChofer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ContratarChofer> input) {
        var command = input.getCommand();
        var administrativo = Administrativo.from(command.getAdministrativoId(), retrieveEvents());
        //Regla de negocio
        if(administrativo.HistorialDeContratos().size() > 20)
            throw new BusinessException(command.getAdministrativoId().value(),
                    "Por el momento no se puede contratar mas de 20 choferes");
        try {
            administrativo.contratarChofer(command.getChoferId(), command.getHistorialDeContratos());
        }catch (IllegalArgumentException e){
            throw new BusinessException(command.getAdministrativoId().value(), e.getMessage());
        }
        emit().onResponse(new ResponseEvents(administrativo.getUncommittedChanges()));

    }
}
