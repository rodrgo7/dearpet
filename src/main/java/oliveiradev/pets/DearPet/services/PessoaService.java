package oliveiradev.pets.DearPet.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oliveiradev.pets.DearPet.exceptions.ResourceNotFoundException;
import oliveiradev.pets.DearPet.models.Pessoa;
import oliveiradev.pets.DearPet.repositories.PessoaRepository;

@Service
public class PessoaService {
    private static final Logger logger = LoggerFactory.getLogger(PessoaService.class);

    @Autowired
    private PessoaRepository pRepositorio;

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = pRepositorio.findAll();
        if (pessoas.isEmpty()) {
            logger.warn("Não há pessoas cadastradas");
            throw new ResourceNotFoundException("Não há pessoas cadastradas");
        }
        logger.info("Foram encontradas {} pessoas", pessoas.size());
        return pessoas;
    }

    public Pessoa findById(long id) {
        logger.info("Buscando pessoa com o ID: {}", id);
        return pRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com o ID: " + id));
    }

    public Pessoa save(Pessoa pessoa) {
        if (existsByEmail(pessoa.getEmail())) {
            logger.error("Tentativa de cadastrar e-mail duplicado: {}", pessoa.getEmail());
            throw new IllegalArgumentException("E-mail já cadastrado: " + pessoa.getEmail());
        }
        logger.info("Salvando nova pessoa com o e-mail: {}", pessoa.getEmail());
        return pRepositorio.save(pessoa);
    }

    public Pessoa update(long id, Pessoa novaPessoa) {
        Pessoa pessoaExistente = findById(id);
        logger.info("Atualizando dados da pessoa com ID: {}", id);
        pessoaExistente.setNome(novaPessoa.getNome());
        pessoaExistente.setSobrenome(novaPessoa.getSobrenome());
        pessoaExistente.setEmail(novaPessoa.getEmail());
        pessoaExistente.setContato(novaPessoa.getContato());
        pessoaExistente.setEndereco(novaPessoa.getEndereco());
        return pRepositorio.save(pessoaExistente);
    }

    public void delete(long id) {
        if (!pRepositorio.existsById(id)) {
            logger.error("Tentativa de deletar pessoa não existente com ID: {}", id);
            throw new ResourceNotFoundException("Pessoa não encontrada com o ID: " + id);
        }
        logger.info("Deletando pessoa com ID: {}", id);
        pRepositorio.deleteById(id);
    }

    public Optional<Pessoa> findByEmail(String email) {
        logger.info("Buscando pessoa com o e-mail: {}", email);
        return pRepositorio.findByEmail(email);
    }

    public Pessoa findByEmailOrThrow(String email) {
        logger.info("Buscando pessoa com o e-mail (com exceção): {}", email);
        return pRepositorio.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com o e-mail: " + email));
    }

    public boolean existsByEmail(String email) {
        logger.info("Verificando se o e-mail já está cadastrado: {}", email);
        return pRepositorio.existsByEmail(email);
    }
}