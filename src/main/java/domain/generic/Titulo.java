package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

public class Titulo implements ValueObject<String> {
    private final String titulo;

    public Titulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String value() {
        return titulo;
    }
}
