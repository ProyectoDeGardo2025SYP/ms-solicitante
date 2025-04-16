package co.edu.uco.burstcar.solicitante.infraestructura.controlador.solicitante.comando;

import co.edu.uco.burstcar.solicitante.aplicacion.casodeuso.solicitante.comando.dto.SolicitanteDto;
import co.edu.uco.burstcar.solicitante.dominio.puerto.RepositorioSolicitante;
import co.edu.uco.burstcar.solicitante.infraestructura.ApplicationMock;
import co.edu.uco.burstcar.solicitante.infraestructura.controlador.solicitante.comando.model.ComandoSolicitanteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoSolicitanteTest {

    @Autowired
    private RepositorioSolicitante repositorioSolicitante;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void registrarSolicitanteExitosamente() throws Exception {
        SolicitanteDto solicitanteDto = new ComandoSolicitanteTestDataBuilder()
                .porDefecto().construir();

        mocMvc.perform(post("/solicitante/nuevo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(solicitanteDto)))
                .andExpect(status().is2xxSuccessful()).andReturn();
    }
}
