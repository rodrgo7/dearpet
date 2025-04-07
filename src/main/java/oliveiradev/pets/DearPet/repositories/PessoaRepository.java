package oliveiradev.pets.DearPet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import oliveiradev.pets.DearPet.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> { 
    Optional<Pessoa> findByEmail(String email);
    boolean existsByEmail(String email);
}
