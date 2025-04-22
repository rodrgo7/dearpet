package oliveiradev.pets.DearPet.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PetTest {

    private Pet pet;
    private Pessoa dono;
    private Profissional profissional;

    @BeforeEach
    void setUp() {
        pet = new Pet();
        dono = new Pessoa();
        dono.setId(1L);
        dono.setNome("John Doe");
        
        profissional = new Profissional();
        profissional.setId(1L);
        profissional.setRegistroProfissional("CRMV-12345");
        profissional.setEspecialidade("Veterinário");
    }

    @Test
    void testPetCreation() {
        assertNotNull(pet);
    }

    @Test
    void testPetFields() {
        pet.setId(1L);
        pet.setNome("Rex");
        pet.setEspecie("Cachorro");
        pet.setRaca("Labrador");
        pet.setPorte("Grande");
        pet.setSexo("Macho");
        pet.setDataNascimento("2020-01-01");
        pet.setDono(dono);
        pet.setProfissional(profissional);
        pet.setNomeProfissional("Dr. Smith");

        assertEquals(1L, pet.getId());
        assertEquals("Rex", pet.getNome());
        assertEquals("Cachorro", pet.getEspecie());
        assertEquals("Labrador", pet.getRaca());
        assertEquals("Grande", pet.getPorte());
        assertEquals("Macho", pet.getSexo());
        assertEquals("2020-01-01", pet.getDataNascimento());
        assertEquals(dono, pet.getDono());
        assertEquals(profissional, pet.getProfissional());
        assertEquals("Dr. Smith", pet.getNomeProfissional());
    }

    @Test
    void testPetConstructor() {
        Pet petConstructor = new Pet(
            1L,
            "Rex",
            "Cachorro",
            "Labrador",
            "Grande",
            "Macho",
            "2020-01-01",
            dono,
            profissional,
            "Dr. Smith"
        );

        assertEquals(1L, petConstructor.getId());
        assertEquals("Rex", petConstructor.getNome());
        assertEquals("Cachorro", petConstructor.getEspecie());
        assertEquals("Labrador", petConstructor.getRaca());
        assertEquals("Grande", petConstructor.getPorte());
        assertEquals("Macho", petConstructor.getSexo());
        assertEquals("2020-01-01", petConstructor.getDataNascimento());
        assertEquals(dono, petConstructor.getDono());
        assertEquals(profissional, petConstructor.getProfissional());
        assertEquals("Dr. Smith", petConstructor.getNomeProfissional());
    }

    @Test
    void testPetEquality() {
        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setNome("Rex");

        Pet pet2 = new Pet();
        pet2.setId(1L);
        pet2.setNome("Rex");

        assertEquals(pet1, pet2);
        assertEquals(pet1.hashCode(), pet2.hashCode());
    }

    @Test
    void testPetInequality() {
        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setNome("Rex");

        Pet pet2 = new Pet();
        pet2.setId(2L);
        pet2.setNome("Max");

        assertNotEquals(pet1, pet2);
        assertNotEquals(pet1.hashCode(), pet2.hashCode());
    }
} 