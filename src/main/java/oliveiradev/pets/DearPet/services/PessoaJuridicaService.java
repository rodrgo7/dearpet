package oliveiradev.pets.DearPet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oliveiradev.pets.DearPet.models.PessoaJuridica;
import oliveiradev.pets.DearPet.repositories.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
    @Autowired
    private PessoaJuridicaRepository pjRepository;

    public List<PessoaJuridica> findAll() {
        return pjRepository.findAll();
    }

    public PessoaJuridica findById(long id) {
        return pjRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));
    }

    public Optional<PessoaJuridica> findByCnpj(String cnpj) {
        return pjRepository.findByCnpj(cnpj);
    }

    public PessoaJuridica save(PessoaJuridica pessoa) {
        if (pjRepository.existsByCnpj(pessoa.getCnpj())) {
            throw new RuntimeException("CNPJ já cadastrado!");
        }
        return pjRepository.save(pessoa);
    }

    public PessoaJuridica update(long id, PessoaJuridica updatedPessoaJuridica) {
        PessoaJuridica existing = findById(id);
        existing.setNome(updatedPessoaJuridica.getNome());
        existing.setEmail(updatedPessoaJuridica.getEmail());
        existing.setContato(updatedPessoaJuridica.getContato());
        existing.setEndereco(updatedPessoaJuridica.getEndereco());

        return pjRepository.save(existing);
    }

    public void delete(long id) {
        pjRepository.deleteById(id);
    }
}
