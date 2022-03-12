package domain.chofer.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.chofer.aggregate.Chofer;
import domain.chofer.command.CrearChofer;
import domain.chofer.value.ChoferId;

public class CrearChoferUseCase extends UseCase<RequestCommand<CrearChofer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearChofer> input) {
        var command = input.getCommand();
        var chofer = new Chofer(command.getChoferId(), command.getNombre(), command.getEdad(),
                command.getDisponible(), command.getDireccion(), command.getTelefono(), command.getSueldo());

        emit().onResponse(new ResponseEvents(chofer.getUncommittedChanges()));
    }
}
