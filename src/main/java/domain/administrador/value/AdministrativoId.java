package domain.administrador.value;

import co.com.sofka.domain.generic.Identity;

public class AdministrativoId extends Identity {

    private AdministrativoId(String valor){
        super(valor);
    }

    public AdministrativoId(){}

    public static AdministrativoId of(String valor){
        return new AdministrativoId(valor);
    }
}
