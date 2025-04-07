package oliveiradev.pets.DearPet.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oliveiradev.pets.DearPet.exceptions.ResourceNotFoundException;
import oliveiradev.pets.DearPet.models.Profissional;
import oliveiradev.pets.DearPet.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {
    private static final Logger logger = LoggerFactory.getLogger(ProfissionalService.class);
    @Autowired
    private ProfissionalRepository profRepository;

    public List<Profissional> findAll() {
        List<Profissional> profissionais = profRepository.findAll();
        if (profissionais.isEmpty()) {
            logger.warn("Não há profissionais cadastradas");
            throw new ResourceNotFoundException("Não há profissionais cadastradas");
        }
        logger.info("Foram encontradas {} pets", profissionais.size());
        return profissionais;
    }

    public Profissional findById(long id) {
        return profRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrada com o ID: " + id));
    }

    public Profissional save(Profissional profissional) {
        return profRepository.save(profissional);
    }

    public Profissional update(Long id, Profissional profissional) {
        if (profRepository.existsById(id)) {
            profissional.setId(id);
            return profRepository.save(profissional);
        }
        return null;
    }

    public void delete(long id) {
        if (!profRepository.existsById(id)) {
            logger.error("Tentativa de deletar um profissional não existente com ID: {}", id);
            throw new ResourceNotFoundException("Profissional não encontrado com o ID: " + id);
        }
        logger.info("Deletando profissional com ID: {}", id);
        profRepository.deleteById(id);
    }
} 