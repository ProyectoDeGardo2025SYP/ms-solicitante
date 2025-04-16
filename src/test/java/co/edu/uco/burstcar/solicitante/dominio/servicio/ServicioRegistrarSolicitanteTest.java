package co.edu.uco.burstcar.solicitante.dominio.servicio;


import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.servicio.solicitante.ServicioRegistrarSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.testdatabuilder.modelo.SolicitanteTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioRegistrarSolicitanteTest {

    @Test
    void registrarSolicitanteexitosamente(){
        Solicitante solicitante = new SolicitanteTestDataBuilder().byDefault().build();

        RepositorioSolicitante repositorioSolicitante = Mockito.mock(RepositorioSolicitante.class);
        ServicioRegistrarSolicitante servicioRegistrarSolicitante = new ServicioRegistrarSolicitante(repositorioSolicitante);
        servicioRegistrarSolicitante.ejecutarRegistro(solicitante);

        Mockito.verify(repositorioSolicitante, Mockito.times(1)).registrarInformacionPersonal(solicitante);
    }
}
