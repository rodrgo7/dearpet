package oliveiradev.pets.DearPet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import oliveiradev.pets.DearPet.models.Pet;

public interface PetRepositorio extends JpaRepository<Pet, Long> { }