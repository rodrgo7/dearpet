package oliveiradev.pets.DearPet.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oliveiradev.pets.DearPet.exceptions.ResourceNotFoundException;
import oliveiradev.pets.DearPet.models.Pet;
import oliveiradev.pets.DearPet.repositories.PetRepositorio;

@Service
public class PetService {
    private static final Logger logger = LoggerFactory.getLogger(PetService.class);
    
    @Autowired
    private PetRepositorio petRepositorio;

    public List<Pet> findAll() {
        List<Pet> pets = petRepositorio.findAll();
        if (pets.isEmpty()) {
            logger.warn("Não há pets cadastradas");
            throw new ResourceNotFoundException("Não há pets cadastradas");
        }
        logger.info("Foram encontradas {} pets", pets.size());
        return pets;
    }

    public Pet findById(long id) {
        return petRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrada com o ID: " + id));
    }

    public Pet save(Pet Pet) {
        return petRepositorio.save(Pet);
    }

    public Pet update(long id, Pet novoPet) {
        Pet petExistente = findById(id);
        logger.info("Atualizando dados da pessoa com ID: {}", id);
        petExistente.setNome(novoPet.getNome());
        petExistente.setEspecie(novoPet.getEspecie());
        petExistente.setRaca(novoPet.getRaca());
        petExistente.setDataNascimento(novoPet.getDataNascimento());
        return petRepositorio.save(petExistente);
    }

    public void delete(long id) {
        if (!petRepositorio.existsById(id)) {
            logger.error("Tentativa de deletar um pet não existente com ID: {}", id);
            throw new ResourceNotFoundException("Pet não encontrado com o ID: " + id);
        }
        logger.info("Deletando pet com ID: {}", id);
        petRepositorio.deleteById(id);
    }
}