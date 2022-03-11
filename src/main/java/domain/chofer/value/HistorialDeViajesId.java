package domain.chofer.value;

import co.com.sofka.domain.generic.Identity;
import domain.administrador.value.HistorialContratosId;

public class HistorialDeViajesId extends Identity {

    private HistorialDeViajesId(String valor){
        super(valor);
    }

    public HistorialDeViajesId(){}

    public static HistorialDeViajesId of(String valor){
        return new HistorialDeViajesId(valor);
    }
}
