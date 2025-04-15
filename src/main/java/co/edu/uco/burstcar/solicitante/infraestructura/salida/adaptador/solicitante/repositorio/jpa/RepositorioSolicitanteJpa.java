package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.repositorio.jpa;

import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.solicitante.entidad.EntidadSolicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioSolicitanteJpa extends JpaRepository<EntidadSolicitante, UUID> {

    /*@Query(value = "Select * From prestador.prestador WHERE " +
            "numero_identificacion = :identificacion", nativeQuery = true)
    EntidadPrestador consultarPrestadorPorSuIdentificacion(@Param("identificacion")String identificacion);*/

    EntidadSolicitante findByUsuarioAndContrasena(String usuario, String contrasena);
}
