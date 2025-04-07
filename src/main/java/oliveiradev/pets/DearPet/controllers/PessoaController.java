package oliveiradev.pets.DearPet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import oliveiradev.pets.DearPet.models.Pessoa;
import oliveiradev.pets.DearPet.models.PessoaFisica;
import oliveiradev.pets.DearPet.models.PessoaJuridica;
import oliveiradev.pets.DearPet.services.PessoaFisicaService;
import oliveiradev.pets.DearPet.services.PessoaJuridicaService;
import oliveiradev.pets.DearPet.services.PessoaService;

@RestController
@RequestMapping("/v1/pessoa")
@Tag(name = "Pessoas", description = "Endpoints para buscar pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    
    @Autowired
    private PessoaFisicaService pfService;
    
    @Autowired
    private PessoaJuridicaService pjService;;

    @Operation(summary = "Lista todas as pessoas", description = "Retorna uma lista de todas as pessoas cadastradas no sistema")
    @ApiResponse(responseCode = "200", description = "Pessoas encontradas com sucesso")
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = pessoaService.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @Operation(summary = "Busca pessoa por ID", description = "Retorna uma pessoa específica baseada no ID fornecido")
    @ApiResponse(responseCode = "200", description = "Pessoa encontrada")
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @Operation(summary = "Cria uma nova pessoa", description = "Cria um novo registro de pessoa com os dados fornecidos")
    @ApiResponse(responseCode = "200", description = "Pessoa criada com sucesso")
    @PostMapping
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) {
        if (pessoa instanceof PessoaFisica pessoaFisica) {
            return ResponseEntity.ok(pfService.save(pessoaFisica));
        } else if (pessoa instanceof PessoaJuridica pessoaJuridica) {
            return ResponseEntity.ok(pjService.save(pessoaJuridica));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Atualiza uma pessoa", description = "Atualiza os dados de uma pessoa existente baseado no ID")
    @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        if (pessoa instanceof PessoaFisica) {
            return ResponseEntity.ok(pfService.update(id, (PessoaFisica) pessoa));
        } else if (pessoa instanceof PessoaJuridica) {
            return ResponseEntity.ok(pjService.update(id, (PessoaJuridica) pessoa));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Remove uma pessoa", description = "Remove uma pessoa do sistema baseado no ID fornecido")
    @ApiResponse(responseCode = "204", description = "Pessoa removida com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca pessoa por email", description = "Retorna uma pessoa específica baseada no email fornecido")
    @ApiResponse(responseCode = "200", description = "Pessoa encontrada")
    @GetMapping("/email/{email}")
    public ResponseEntity<Pessoa> findByEmail(@PathVariable String email) {
        return pessoaService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Busca pessoa por CPF", description = "Retorna uma pessoa específica baseada no CPF fornecido")
    @ApiResponse(responseCode = "200", description = "Pessoa encontrada")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PessoaFisica> findByCpf(@PathVariable String cpf) {
        return pfService.findByCpf(cpf)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Busca pessoa por CNPJ", description = "Retorna uma pessoa específica baseada no CNPJ fornecido")
    @ApiResponse(responseCode = "200", description = "Pessoa encontrada")
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<PessoaJuridica> findByCnpj(@PathVariable String cnpj) {
        return pjService.findByCnpj(cnpj)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}