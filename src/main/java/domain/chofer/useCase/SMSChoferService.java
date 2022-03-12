package domain.chofer.useCase;

import domain.chofer.value.ChoferId;

public interface SMSChoferService {
    boolean enviarMensajeAlChofer(ChoferId choferId, String mensaje);
}
