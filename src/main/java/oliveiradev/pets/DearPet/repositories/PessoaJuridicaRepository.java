package oliveiradev.pets.DearPet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import oliveiradev.pets.DearPet.models.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {  
    boolean existsByCnpj(String cnpj);
    Optional<PessoaJuridica> findByCnpj(String cnpj);
}