package domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Date;

public class FechaHora implements ValueObject<LocalDate> {
    private final LocalDate fecha;

    public FechaHora(LocalDate fecha) {
        this.fecha = fecha;//TODO: validar fechas, si se permite en el pasado, fechas en el futuro...
    }

    public FechaHora() {
        this(LocalDate.now());
    }

    @Override
    public LocalDate value() {
        return fecha;
    }
}
