package oliveiradev.pets.DearPet.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfissionalTest {

    private Profissional profissional;

    @BeforeEach
    void setUp() {
        profissional = new Profissional();
    }

    @Test
    void testProfissionalCreation() {
        assertNotNull(profissional);
    }

    @Test
    void testProfissionalFields() {
        profissional.setId(1L);
        profissional.setRegistroProfissional("CRMV-12345");
        profissional.setEspecialidade("Veterinário");
        profissional.setDataInicio("2020-01-01");
        profissional.setDataFim("2025-01-01");
        profissional.setObservacoes("Especialista em cães");

        assertEquals(1L, profissional.getId());
        assertEquals("CRMV-12345", profissional.getRegistroProfissional());
        assertEquals("Veterinário", profissional.getEspecialidade());
        assertEquals("2020-01-01", profissional.getDataInicio());
        assertEquals("2025-01-01", profissional.getDataFim());
        assertEquals("Especialista em cães", profissional.getObservacoes());
    }

    @Test
    void testProfissionalConstructor() {
        Profissional profissionalConstructor = new Profissional(
            1L,
            "Dr. Smith",
            "CRMV-12345",
            "Masculino",
            "Veterinário",
            "2020-01-01",
            "2025-01-01",
            "Especialista em cães"
        );

        assertEquals(1L, profissionalConstructor.getId());
        assertEquals("CRMV-12345", profissionalConstructor.getRegistroProfissional());
        assertEquals("Veterinário", profissionalConstructor.getEspecialidade());
        assertEquals("2020-01-01", profissionalConstructor.getDataInicio());
        assertEquals("2025-01-01", profissionalConstructor.getDataFim());
        assertEquals("Especialista em cães", profissionalConstructor.getObservacoes());
    }

    @Test
    void testProfissionalEquality() {
        Profissional profissional1 = new Profissional();
        profissional1.setId(1L);
        profissional1.setRegistroProfissional("CRMV-12345");

        Profissional profissional2 = new Profissional();
        profissional2.setId(1L);
        profissional2.setRegistroProfissional("CRMV-12345");

        assertEquals(profissional1, profissional2);
        assertEquals(profissional1.hashCode(), profissional2.hashCode());
    }

    @Test
    void testProfissionalInequality() {
        Profissional profissional1 = new Profissional();
        profissional1.setId(1L);
        profissional1.setRegistroProfissional("CRMV-12345");

        Profissional profissional2 = new Profissional();
        profissional2.setId(2L);
        profissional2.setRegistroProfissional("CRMV-67890");

        assertNotEquals(profissional1, profissional2);
        assertNotEquals(profissional1.hashCode(), profissional2.hashCode());
    }
} 