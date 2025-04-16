package co.edu.uco.burstcar.solicitante.arquitectura;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureCleanTest {

    JavaClasses javaClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
            .importPackages("co.edu.uco.burstcar.solicitante");

    @Test
    void dominioDependeSoloDeJava(){
        classes()
                .that().resideInAPackage("..dominio..")
                .should().onlyAccessClassesThat()
                .resideInAnyPackage("java..", "lombok..", "co.edu.uco.burstcar.solicitante..")
                .check(javaClasses);
    }

    @Test
    void contratosPorInterfaces(){
        classes()
                .that().resideInAnyPackage("..dominio.puerto..")
                .should().beInterfaces().check(javaClasses);
    }

    @Test
    void layersChecks(){
        Architectures.layeredArchitecture().consideringAllDependencies()
                .layer("Infrastructure").definedBy("..infraestructura..")
                .layer("Application").definedBy("..aplicacion..")
                .layer("Domain").definedBy("..dominio..")

                .whereLayer("Infrastructure").mayNotBeAccessedByAnyLayer()
                .whereLayer("Application").mayOnlyBeAccessedByLayers("Infrastructure")
                .whereLayer("Domain").mayOnlyBeAccessedByLayers("Infrastructure", "Application")
                .ignoreDependency(
                        "co.edu.uco.burstcar.solicitante.SolicitanteApplication",
                        "co.edu.uco.burstcar.solicitante.infraestructura.config.general.token.PropiedadesConfiguracionJwt"
                )
                .check(javaClasses);
    }
}
