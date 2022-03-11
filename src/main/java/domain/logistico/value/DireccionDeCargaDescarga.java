package domain.logistico.value;

import co.com.sofka.domain.generic.ValueObject;

public class DireccionDeCargaDescarga implements ValueObject<DireccionDeCargaDescarga.Props> {
    private final Ruta ruta;
    private final Lugar lugar;

    public DireccionDeCargaDescarga(Ruta ruta, Lugar lugar) {
        this.ruta = ruta;
        this.lugar = lugar;
    }

    @Override
    public Props value() {
        return new Props(){
            @Override
            public Ruta ruta(){
                return ruta;
            }
            @Override
            public Lugar lugar(){
                return lugar;
            }
        };
    }

    public interface Props{
        Ruta ruta();
        Lugar lugar();
    }
}
