package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.repositorio;

import co.edu.uco.burstcar.solicitante.dominio.modelo.IdentificacionSolicitante;
import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.entidad.EntidadIdentificacionSolicitante;
import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.repositorio.jpa.RepositorioIdentificacionSolicitanteJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioIdentificacionSolicitanteImpl implements co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioIdentificacionSolicitante {

    private final RepositorioIdentificacionSolicitanteJpa repositorioIdentificacionSolicitanteJpa;

    public RepositorioIdentificacionSolicitanteImpl(RepositorioIdentificacionSolicitanteJpa repositorioIdentificacionSolicitanteJpa) {
        this.repositorioIdentificacionSolicitanteJpa = repositorioIdentificacionSolicitanteJpa;
    }


    @Override
    public IdentificacionSolicitante asociarTipoIdentificacionSolicitante(String codigo) {
        EntidadIdentificacionSolicitante entidadIdentificacionSolicitante =
                this.repositorioIdentificacionSolicitanteJpa.findByCodigo(codigo);
        if(entidadIdentificacionSolicitante == null){
            return null;
        }
        return IdentificacionSolicitante.nuevaIdentificacionSolicitanteConIdentificador(
                entidadIdentificacionSolicitante.getIdentificador(), entidadIdentificacionSolicitante.getNombre(),
                entidadIdentificacionSolicitante.getIdentificacionCategoriaId());
    }
}
