package co.edu.uco.burstcar.solicitante.aplicacion.mapeador;

import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;

public class MapeadorGenericoAplicacion<A, D> implements MapeadorAplicacion<A, D> {

    protected ModelMapper modelMapper;
    private final Class<A> dtoClase;
    private final Class<D> dominioClase;

    public MapeadorGenericoAplicacion() {
        this.modelMapper = new ModelMapper();
        this.dtoClase = (Class<A>)
                ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.dominioClase = (Class<D>)
                ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public D aDominio(A dto) {
        return modelMapper.map(dto, dominioClase);
    }
}
