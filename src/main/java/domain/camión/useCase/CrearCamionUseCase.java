package domain.camión.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.camión.aggregate.Camion;
import domain.camión.command.CrearCamion;

public class CrearCamionUseCase extends UseCase<RequestCommand<CrearCamion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCamion> input) {
        var command = input.getCommand();
        var camion = new Camion(command.getCamionId(), command.getCantidadDeKM(), command.getMarca(),
                command.getEstadoDeViaje(), command.getCantidadDeCombustible(), command.getEstadoDeCamion());
        emit().onResponse(new ResponseEvents(camion.getUncommittedChanges()));
    }
}
