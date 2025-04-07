package oliveiradev.pets.DearPet.models;

//import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas_fisicas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {
    @Column(unique = true, nullable = false)
    private String cpf;

    public PessoaFisica() { }

    public PessoaFisica(Long id, String nome, String sobrenome, String genero, String email, String contato, String endereco, String cpf) {
        super(id, nome, sobrenome, genero, email, contato, endereco);
        this.cpf = cpf;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}
