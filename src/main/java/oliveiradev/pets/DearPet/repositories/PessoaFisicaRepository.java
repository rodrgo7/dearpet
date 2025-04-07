package oliveiradev.pets.DearPet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import oliveiradev.pets.DearPet.models.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> { 
    boolean existsByCpf(String cpf);
    Optional<PessoaFisica> findByCpf(String cpf);
}