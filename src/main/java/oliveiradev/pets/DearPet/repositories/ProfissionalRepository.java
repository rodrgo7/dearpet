package oliveiradev.pets.DearPet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import oliveiradev.pets.DearPet.models.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
