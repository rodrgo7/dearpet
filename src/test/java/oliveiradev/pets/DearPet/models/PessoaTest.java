package oliveiradev.pets.DearPet.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PessoaTest {

    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa();
    }

    @Test
    void testPessoaCreation() {
        assertNotNull(pessoa);
    }

    @Test
    void testPessoaFields() {
        pessoa.setId(1L);
        pessoa.setNome("John");
        pessoa.setSobrenome("Doe");
        pessoa.setGenero("Masculino");
        pessoa.setEmail("john@example.com");
        pessoa.setContato("1234567890");
        pessoa.setEndereco("123 Main St");

        assertEquals(1L, pessoa.getId());
        assertEquals("John", pessoa.getNome());
        assertEquals("Doe", pessoa.getSobrenome());
        assertEquals("Masculino", pessoa.getGenero());
        assertEquals("john@example.com", pessoa.getEmail());
        assertEquals("1234567890", pessoa.getContato());
        assertEquals("123 Main St", pessoa.getEndereco());
    }

    @Test
    void testPessoaConstructor() {
        Pessoa pessoaConstructor = new Pessoa(
            1L,
            "John",
            "Doe",
            "Masculino",
            "john@example.com",
            "1234567890",
            "123 Main St"
        );

        assertEquals(1L, pessoaConstructor.getId());
        assertEquals("John", pessoaConstructor.getNome());
        assertEquals("Doe", pessoaConstructor.getSobrenome());
        assertEquals("Masculino", pessoaConstructor.getGenero());
        assertEquals("john@example.com", pessoaConstructor.getEmail());
        assertEquals("1234567890", pessoaConstructor.getContato());
        assertEquals("123 Main St", pessoaConstructor.getEndereco());
    }

    @Test
    void testPessoaEquality() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1L);
        pessoa1.setNome("John");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(1L);
        pessoa2.setNome("John");

        assertEquals(pessoa1.getId(), pessoa2.getId());
        assertEquals(pessoa1.getNome(), pessoa2.getNome());
    }
} 