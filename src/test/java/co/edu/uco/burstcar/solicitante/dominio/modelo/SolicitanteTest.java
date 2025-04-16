package co.edu.uco.burstcar.solicitante.dominio.modelo;

import co.edu.uco.burstcar.solicitante.dominio.testdatabuilder.modelo.SolicitanteTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SolicitanteTest {

    @Test
    void validateCreationSuccessful() {
        Solicitante solicitante = new SolicitanteTestDataBuilder().byDefault().build();

        Assertions.assertEquals("123456789", solicitante.getNumeroIdentificacion());
        Assertions.assertEquals("Prueba", solicitante.getNombre());
        Assertions.assertEquals("usuario1", solicitante.getUsuario());
        Assertions.assertEquals("password", solicitante.getContrasena());
        Assertions.assertEquals(43575248723L, solicitante.getNumeroTelefonico());
        Assertions.assertEquals("Cedula", solicitante.getIdentificacionSolicitante().getNombre());
        Assertions.assertEquals("C.C", solicitante.getIdentificacionSolicitante().getIdentificacionCategoriaId());
    }

    @Test
    void validarCampoFaltanteNumeroIdentificacion() {
        Assertions.assertEquals("El atributo Número de identificación no puede estar nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conNumeroIdentificaion("").build()).getMessage());
    }

    @Test
    void validarCampoTamanoNumeroIdentificacion() {
        Assertions.assertEquals("El atributo Número de identificación es más grande de lo permitido, solo soporta 12 caracteres",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conNumeroIdentificaion("1234567890987654321").build()).getMessage());
    }

    @Test
    void validarCampoFaltanteNombre() {
        Assertions.assertEquals("El atributo nombre no puede estar nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conNombre("").build()).getMessage());
    }

    @Test
    void validarCampoTamanoNombre() {
        Assertions.assertEquals("El atributo nombre es más grande de lo permitido, solo soporta 30 caracteres",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conNombre("PRUEBA DE UN NOMBRE MUY LARGO PARA VERIFICAR EL TAMAÑO PERMITIDO").build()).getMessage());
    }

    @Test
    void validarCampoFaltanteUsuario() {
        Assertions.assertEquals("El atributo usuario no puede estar nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conUsuario("").build()).getMessage());
    }

    @Test
    void validarCampoTamanoUsuario() {
        Assertions.assertEquals("El atributo usuario es más grande de lo permitido, solo soporta 15 caracteres",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conUsuario("PRUEBA DE UN NOMBREDE USUARIO MUY LARGO PARA VERIFICAR EL TAMAÑO PERMITIDO").build()).getMessage());
    }

    @Test
    void validarCampoFaltanteContrasena() {
        Assertions.assertEquals("El atributo contraseña no puede estar nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conContrasena("").build()).getMessage());
    }

    @Test
    void validarCampoTamanoContrasena() {
        Assertions.assertEquals("El atributo contraseña es más grande de lo permitido, solo soporta 16 caracteres",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conContrasena("PRUEBA DE UNA CONTRASEÑA MUY LARAG PARA VERIFICAR EL TAMAÑO PERMITIDO").build()).getMessage());
    }

    @Test
    void validarCampoFaltanteTelefono() {
        Assertions.assertEquals("El atributo Número telefonico no puede estar nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conNumeroTelefonico(null).build()).getMessage());
    }

    @Test
    void validarCampoFaltanteIdentificacion() {
        Assertions.assertEquals("El atributo Identificación del solicitante no puede estar nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new SolicitanteTestDataBuilder().byDefault().conIdentificacionSolicitante(null).build()).getMessage());
    }


}
