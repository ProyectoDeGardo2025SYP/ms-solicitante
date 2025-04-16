package co.edu.uco.burstcar.solicitante.aplicacion.mapeador;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.SolicitanteDto;
import co.edu.uco.burstcar.solicitante.aplicacion.mapeador.solicitante.impl.MapeadorSolicitanteAplicacion;
import co.edu.uco.burstcar.solicitante.dominio.modelo.IdentificacionSolicitante;
import co.edu.uco.burstcar.solicitante.dominio.modelo.Solicitante;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioIdentificacionSolicitante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MapeadorSolicitanteAplicacionTest {


    @Mock
    private RepositorioIdentificacionSolicitante repositorioIdentificacionSolicitante;

    @InjectMocks
    private MapeadorSolicitanteAplicacion mapeador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void mapearCorrectamenteSolicitanteDtoADominio() {
        SolicitanteDto dto = new SolicitanteDto();
        dto.setNumeroIdentificacion("123");
        dto.setNombre("Juan Pérez");
        dto.setUsuario("juan123");
        dto.setContrasena("secreta");
        dto.setNumeroTelefonico(1234567890L);
        dto.setCategoriaIdentificador("CC");
        IdentificacionSolicitante identificacionMock = new IdentificacionSolicitante();
        when(repositorioIdentificacionSolicitante.asociarTipoIdentificacionPrestador("CC"))
                .thenReturn(identificacionMock);

        Solicitante dominio = mapeador.aDominio(dto);

        Assertions.assertNotNull(dominio);
        Assertions.assertEquals("123", dominio.getNumeroIdentificacion());
        Assertions.assertEquals("Juan Pérez", dominio.getNombre());
        Assertions.assertEquals("juan123", dominio.getUsuario());
        Assertions.assertEquals("secreta", dominio.getContrasena());
        Assertions.assertEquals(1234567890L, dominio.getNumeroTelefonico());
        Assertions.assertEquals(identificacionMock, dominio.getIdentificacionSolicitante());
        verify(repositorioIdentificacionSolicitante, Mockito.times(1)).asociarTipoIdentificacionPrestador("CC");
        verify(repositorioIdentificacionSolicitante).asociarTipoIdentificacionPrestador("CC");
    }

    @Test
    void debeRetornarSolicitanteConIdentificacionNullSiCategoriaEsInvalida() {
        SolicitanteDto dto = new SolicitanteDto();
        dto.setNumeroIdentificacion("123");
        dto.setNombre("Juan Pérez");
        dto.setUsuario("juan123");
        dto.setContrasena("secreta");
        dto.setNumeroTelefonico(1234567890L);
        dto.setCategoriaIdentificador("CC");
        dto.setCategoriaIdentificador("otra");
        when(repositorioIdentificacionSolicitante.asociarTipoIdentificacionPrestador("otra"))
                .thenThrow(new IllegalArgumentException("El atributo Identificación del solicitante no puede estar nulo"));

        Assertions.assertThrows(IllegalArgumentException.class,  () -> mapeador.aDominio(dto));
    }

}
