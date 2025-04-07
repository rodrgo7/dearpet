package oliveiradev.pets.DearPet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oliveiradev.pets.DearPet.models.PessoaFisica;
import oliveiradev.pets.DearPet.repositories.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepository pfRepository;

    public List<PessoaFisica> findAll() {
        return pfRepository.findAll();
    }

    public PessoaFisica findById(long id) {
        return pfRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));
    }

    public Optional<PessoaFisica> findByCpf(String cpf) {
        return pfRepository.findByCpf(cpf);
    }

    public PessoaFisica update(long id, PessoaFisica updatedPessoaFisica) {
        PessoaFisica existing = findById(id);
        existing.setNome(updatedPessoaFisica.getNome());
        existing.setEmail(updatedPessoaFisica.getEmail());
        existing.setContato(updatedPessoaFisica.getContato());
        existing.setEndereco(updatedPessoaFisica.getEndereco());

        return pfRepository.save(existing);
    }

    public void delete(long id) {
        pfRepository.deleteById(id);
    }

    public PessoaFisica save(PessoaFisica pessoa) {
        if (pfRepository.existsByCpf(pessoa.getCpf())) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        return pfRepository.save(pessoa);
    }
}