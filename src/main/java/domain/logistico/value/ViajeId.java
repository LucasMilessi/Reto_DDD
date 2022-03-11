package domain.logistico.value;

import co.com.sofka.domain.generic.Identity;

public class ViajeId extends Identity {

    private ViajeId(String valor){
        super(valor);
    }

    public ViajeId(){}

    public static ViajeId of(String valor){
        return new ViajeId(valor);
    }
}
