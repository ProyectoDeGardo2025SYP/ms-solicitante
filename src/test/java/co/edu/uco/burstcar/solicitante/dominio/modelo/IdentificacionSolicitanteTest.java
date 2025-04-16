package co.edu.uco.burstcar.solicitante.dominio.modelo;

import co.edu.uco.burstcar.solicitante.dominio.testdatabuilder.modelo.IdentificacionSolicitanteTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdentificacionSolicitanteTest {
    @Test
    void validarCreacionExitosa() {
        IdentificacionSolicitante identificacionSolicitante =
                new IdentificacionSolicitanteTestDataBuilder().byDefault().build();

        Assertions.assertEquals("Cedula", identificacionSolicitante.getNombre());
        Assertions.assertEquals("C.C", identificacionSolicitante.getIdentificacionCategoriaId());
    }


    @Test
    void validarCampoFaltanteCategoria() {
        Assertions.assertEquals("El atributo Categoría de la identificación no puede estar nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new IdentificacionSolicitanteTestDataBuilder().byDefault().conIdentificacionCategoriaId("").build()).getMessage());
    }

    @Test
    void validarCampoImcumpleTamanoCategoria() {
        Assertions.assertEquals("El atributo Categoría de la identificación es más grande de lo permitido, solo soporta 5 caracteres",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new IdentificacionSolicitanteTestDataBuilder().byDefault().conIdentificacionCategoriaId("123456787654323456").build()).getMessage());
    }

    @Test
    void validarCampoFaltanteNombre() {
        Assertions.assertEquals("El atributo nombre de la identificacion no puede estar nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new IdentificacionSolicitanteTestDataBuilder().byDefault().conNombre("").build()).getMessage());
    }

    @Test
    void validarCampoImcumpleTamanoNombre() {
        Assertions.assertEquals("El atributo nombre de la identificacion es más grande de lo permitido, solo soporta 30 caracteres",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new IdentificacionSolicitanteTestDataBuilder().byDefault().conNombre("Esto es una identificacion de pruebas para poder analizar el comportamiento").build()).getMessage());
    }
}
