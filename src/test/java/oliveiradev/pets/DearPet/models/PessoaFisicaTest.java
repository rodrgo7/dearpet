package oliveiradev.pets.DearPet.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PessoaFisicaTest {

    private PessoaFisica pessoaFisica;
    private Pet pet;

    @BeforeEach
    void setUp() {
        pessoaFisica = new PessoaFisica();
        pet = new Pet();
        pet.setId(1L);
        pet.setNome("Rex");
    }

    @Test
    void testPessoaFisicaCreation() {
        assertNotNull(pessoaFisica);
    }

    @Test
    void testPessoaFisicaFields() {
        pessoaFisica.setId(1L);
        pessoaFisica.setNome("John");
        pessoaFisica.setSobrenome("Doe");
        pessoaFisica.setGenero("Masculino");
        pessoaFisica.setEmail("john@example.com");
        pessoaFisica.setContato("1234567890");
        pessoaFisica.setEndereco("123 Main St");
        pessoaFisica.setCpf("123.456.789-00");
        pessoaFisica.setPet(pet);
        pessoaFisica.setNomePet("Rex");

        assertEquals(1L, pessoaFisica.getId());
        assertEquals("John", pessoaFisica.getNome());
        assertEquals("Doe", pessoaFisica.getSobrenome());
        assertEquals("Masculino", pessoaFisica.getGenero());
        assertEquals("john@example.com", pessoaFisica.getEmail());
        assertEquals("1234567890", pessoaFisica.getContato());
        assertEquals("123 Main St", pessoaFisica.getEndereco());
        assertEquals("123.456.789-00", pessoaFisica.getCpf());
        assertEquals(pet, pessoaFisica.getPet());
        assertEquals("Rex", pessoaFisica.getNomePet());
    }

    @Test
    void testPessoaFisicaConstructor() {
        PessoaFisica pessoaFisicaConstructor = new PessoaFisica(
            1L,
            "John",
            "Doe",
            "Masculino",
            "john@example.com",
            "1234567890",
            "123 Main St",
            "123.456.789-00",
            pet,
            "Rex"
        );

        assertEquals(1L, pessoaFisicaConstructor.getId());
        assertEquals("John", pessoaFisicaConstructor.getNome());
        assertEquals("Doe", pessoaFisicaConstructor.getSobrenome());
        assertEquals("Masculino", pessoaFisicaConstructor.getGenero());
        assertEquals("john@example.com", pessoaFisicaConstructor.getEmail());
        assertEquals("1234567890", pessoaFisicaConstructor.getContato());
        assertEquals("123 Main St", pessoaFisicaConstructor.getEndereco());
        assertEquals("123.456.789-00", pessoaFisicaConstructor.getCpf());
        assertEquals(pet, pessoaFisicaConstructor.getPet());
        assertEquals("Rex", pessoaFisicaConstructor.getNomePet());
    }

    @Test
    void testGetNomeCompleto() {
        pessoaFisica.setNome("John");
        pessoaFisica.setSobrenome("Doe");
        
        assertEquals("John Doe", pessoaFisica.getNomeCompleto());
    }
} 