package domain.camión.value;

import co.com.sofka.domain.generic.Identity;

public class CamionId extends Identity {

    private CamionId(String valor){
        super(valor);
    }

    public CamionId(){}

    public static CamionId of(String valor){
        return new CamionId(valor);
    }
}
