package oliveiradev.pets.DearPet.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas_juridicas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {
    @Column(unique = true, nullable = false, length = 18)
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica() { }

    public PessoaJuridica(Long id, String nome, String sobrenome, String genero, String email, String contato, String endereco, String cnpj, String razaoSocial) {
        super(id, nome, sobrenome, genero, email, contato, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }


    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }

}
