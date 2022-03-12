package domain.logistico.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.logistico.aggregate.Logistico;
import domain.logistico.command.CrearLogistico;

public class CrearLogisticoUseCase extends UseCase<RequestCommand<CrearLogistico>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearLogistico> input) {
        var command = input.getCommand();
        var logistico = new Logistico(command.getLogisticoId(), command.getNombre(),
                command.getEdad(), command.getDireccion());
        emit().onResponse(new ResponseEvents(logistico.getUncommittedChanges()));
    }
}
