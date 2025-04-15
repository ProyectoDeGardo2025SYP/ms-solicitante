package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.repositorio;

import co.edu.uco.burstcar.solicitante.dominio.modelo.IdentificacionSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;
import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.entidad.EntidadIdentificacionSolicitante;
import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.repositorio.jpa.RepositorioIdentificacionSolicitanteJpa;
import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.entidad.EntidadSolicitante;
import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.repositorio.jpa.RepositorioSolicitanteJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSolicitante implements co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioSolicitante {

    private final RepositorioSolicitanteJpa repositorioSolicitanteJpa;
    private final RepositorioIdentificacionSolicitanteJpa repositorioIdentificacionSolicitanteJpa;

    public RepositorioSolicitante(RepositorioSolicitanteJpa repositorioSolicitanteJpa, RepositorioIdentificacionSolicitanteJpa repositorioIdentificacionSolicitanteJpa) {
        this.repositorioSolicitanteJpa = repositorioSolicitanteJpa;
        this.repositorioIdentificacionSolicitanteJpa = repositorioIdentificacionSolicitanteJpa;
    }

    @Override
    public void registrarInformacionPersonal(Solicitante solicitante) {
        EntidadIdentificacionSolicitante entidadIdentificacionSolicitante =
                this.repositorioIdentificacionSolicitanteJpa.findByCodigo(
                        solicitante.getIdentificacionSolicitante().getIdentificacionCategoriaId());

        EntidadSolicitante entidadSolicitante = new EntidadSolicitante(solicitante.getNumeroIdentificacion(),
                solicitante.getNombre(), solicitante.getUsuario(), solicitante.getContrasena(), solicitante.getNumeroTelefonico(),
                entidadIdentificacionSolicitante);
        entidadSolicitante.setIdentificador(solicitante.getIdentificador());

        this.repositorioSolicitanteJpa.save(entidadSolicitante);
    }

    @Override
    public Solicitante realizarInicioSesion(String usuario, String contrasena) {
        EntidadSolicitante entidadSolicitante = this.repositorioSolicitanteJpa.findByUsuarioAndContrasena(usuario, contrasena);
        EntidadIdentificacionSolicitante entidadIdentificacionSolicitante = this.repositorioIdentificacionSolicitanteJpa
                .findByCodigo(entidadSolicitante.getEntidadIdentificacionSolicitante().getIdentificacionCategoriaId());

        IdentificacionSolicitante identificacionSolicitante = IdentificacionSolicitante.nuevaIdentificacionSolicitanteConIdentificador(
                entidadIdentificacionSolicitante.getIdentificador(),
                entidadIdentificacionSolicitante.getNombre(), entidadIdentificacionSolicitante.getIdentificacionCategoriaId());

        return Solicitante.nuevoSolicitanteConIdentificador(
                entidadSolicitante.getIdentificador(), entidadSolicitante.getNumeroIdentificacion(), entidadSolicitante.getNombre(),
                entidadSolicitante.getUsuario(), entidadSolicitante.getContrasena(), entidadSolicitante.getNumeroTelefonico(),
                identificacionSolicitante);
    }

    @Override
    public boolean validarSolicitante(String numeroIdentificacion) {
        return false;
    }
}
