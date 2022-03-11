package domain.administrador.value;

import co.com.sofka.domain.generic.Identity;

public class HistorialContratosId extends Identity {

    private HistorialContratosId(String valor){
        super(valor);
    }

    public HistorialContratosId(){}

    public static HistorialContratosId of(String valor){
        return new HistorialContratosId(valor);
    }
}
