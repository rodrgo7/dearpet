package oliveiradev.pets.DearPet.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "pessoas_fisicas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {
    
    @Column(unique = true, nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "nome_pet")
    private String nomePet;

    public PessoaFisica() { }

    public PessoaFisica(Long id, String nome, String sobrenome, String genero, String email, String contato, String endereco, String cpf, Pet pet, String nomePet) {
        super(id, nome, sobrenome, genero, email, contato, endereco);
        this.cpf = cpf;
        this.pet = pet;
        this.nomePet = nomePet;
    }

    // Método para obter nome completo
    @Transient
    public String getNomeCompleto() {
        return super.getNome() + " " + super.getSobrenome();
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public String getNomePet() { return nomePet; }
    public void setNomePet(String nomePet) { this.nomePet = nomePet; }
}