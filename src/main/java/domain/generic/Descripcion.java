package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;

    public Descripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String value() {
        return descripcion;
    }
}
