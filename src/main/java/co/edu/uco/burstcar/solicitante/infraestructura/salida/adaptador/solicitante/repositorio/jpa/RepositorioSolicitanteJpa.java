package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.repositorio.jpa;

import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.entidad.EntidadSolicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioSolicitanteJpa extends JpaRepository<EntidadSolicitante, UUID> {

    EntidadSolicitante findByUsuarioAndContrasena(String usuario, String contrasena);

    @Query(value = "Select * From solicitante.solicitante WHERE " +
            "numero_identificacion = :numeroIdentificacion", nativeQuery = true)
    EntidadSolicitante consultarSolicitantePorSuIdentificacion(@Param("numeroIdentificacion") String numeroIdentificacion);
}
