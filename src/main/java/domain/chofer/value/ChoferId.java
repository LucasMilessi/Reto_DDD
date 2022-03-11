package domain.chofer.value;

import co.com.sofka.domain.generic.Identity;

public class ChoferId extends Identity {

    private ChoferId(String valor){
        super(valor);
    }

    public ChoferId(){}

    public static ChoferId of(String valor){
        return new ChoferId(valor);
    }
}
