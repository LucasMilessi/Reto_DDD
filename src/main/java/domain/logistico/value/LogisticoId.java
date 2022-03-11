package domain.logistico.value;

import co.com.sofka.domain.generic.Identity;

public class LogisticoId extends Identity {

    private LogisticoId(String valor){
        super(valor);
    }

    public LogisticoId(){}

    public static LogisticoId of(String valor){
        return new LogisticoId(valor);
    }
}
