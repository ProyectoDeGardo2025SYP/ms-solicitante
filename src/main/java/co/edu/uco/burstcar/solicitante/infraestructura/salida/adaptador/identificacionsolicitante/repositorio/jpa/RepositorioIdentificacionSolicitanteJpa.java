package co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.repositorio.jpa;

import co.edu.uco.burstcar.solicitante.infraestructura.salida.adaptador.identificacionsolicitante.entidad.EntidadIdentificacionSolicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioIdentificacionSolicitanteJpa extends JpaRepository<EntidadIdentificacionSolicitante, UUID> {

    @Query(value = "Select * From solicitante.identificacion_solicitante WHERE identificacion_categoria_id = :codigo",
            nativeQuery = true)
    EntidadIdentificacionSolicitante findByCodigo(@Param("codigo") String codigo);
}
