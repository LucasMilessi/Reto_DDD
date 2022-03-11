package domain.camión.value;

import co.com.sofka.domain.generic.Identity;

public class TrailerId extends Identity {
    private TrailerId(String valor){
        super(valor);
    }

    public TrailerId(){}

    public static TrailerId of(String valor){
        return new TrailerId(valor);
    }

}
