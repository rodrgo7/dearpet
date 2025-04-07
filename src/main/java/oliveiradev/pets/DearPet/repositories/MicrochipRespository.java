package oliveiradev.pets.DearPet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import oliveiradev.pets.DearPet.models.Pessoa;

public interface MicrochipRespository extends JpaRepository<Pessoa, Long> { }
