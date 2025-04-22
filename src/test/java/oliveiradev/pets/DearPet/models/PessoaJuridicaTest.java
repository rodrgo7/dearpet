package oliveiradev.pets.DearPet.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PessoaJuridicaTest {

    private PessoaJuridica pessoaJuridica;
    private Pet pet;

    @BeforeEach
    void setUp() {
        pessoaJuridica = new PessoaJuridica();
        pet = new Pet();
        pet.setId(1L);
        pet.setNome("Rex");
    }

    @Test
    void testPessoaJuridicaCreation() {
        assertNotNull(pessoaJuridica);
    }

    @Test
    void testPessoaJuridicaFields() {
        pessoaJuridica.setId(1L);
        pessoaJuridica.setNome("Pet Shop");
        pessoaJuridica.setSobrenome("Ltda");
        pessoaJuridica.setGenero("Empresa");
        pessoaJuridica.setEmail("petshop@example.com");
        pessoaJuridica.setContato("1234567890");
        pessoaJuridica.setEndereco("123 Main St");
        pessoaJuridica.setCnpj("12.345.678/0001-90");
        pessoaJuridica.setRazaoSocial("Pet Shop Ltda");
        pessoaJuridica.setPet(pet);
        pessoaJuridica.setNomePet("Rex");

        assertEquals(1L, pessoaJuridica.getId());
        assertEquals("Pet Shop", pessoaJuridica.getNome());
        assertEquals("Ltda", pessoaJuridica.getSobrenome());
        assertEquals("Empresa", pessoaJuridica.getGenero());
        assertEquals("petshop@example.com", pessoaJuridica.getEmail());
        assertEquals("1234567890", pessoaJuridica.getContato());
        assertEquals("123 Main St", pessoaJuridica.getEndereco());
        assertEquals("12.345.678/0001-90", pessoaJuridica.getCnpj());
        assertEquals("Pet Shop Ltda", pessoaJuridica.getRazaoSocial());
        assertEquals(pet, pessoaJuridica.getPet());
        assertEquals("Rex", pessoaJuridica.getNomePet());
    }

    @Test
    void testPessoaJuridicaConstructor() {
        PessoaJuridica pessoaJuridicaConstructor = new PessoaJuridica(
            1L,
            "Pet Shop",
            "Ltda",
            "Empresa",
            "petshop@example.com",
            "1234567890",
            "123 Main St",
            "12.345.678/0001-90",
            "Pet Shop Ltda",
            pet,
            "Rex"
        );

        assertEquals(1L, pessoaJuridicaConstructor.getId());
        assertEquals("Pet Shop", pessoaJuridicaConstructor.getNome());
        assertEquals("Ltda", pessoaJuridicaConstructor.getSobrenome());
        assertEquals("Empresa", pessoaJuridicaConstructor.getGenero());
        assertEquals("petshop@example.com", pessoaJuridicaConstructor.getEmail());
        assertEquals("1234567890", pessoaJuridicaConstructor.getContato());
        assertEquals("123 Main St", pessoaJuridicaConstructor.getEndereco());
        assertEquals("12.345.678/0001-90", pessoaJuridicaConstructor.getCnpj());
        assertEquals("Pet Shop Ltda", pessoaJuridicaConstructor.getRazaoSocial());
        assertEquals(pet, pessoaJuridicaConstructor.getPet());
        assertEquals("Rex", pessoaJuridicaConstructor.getNomePet());
    }
} 