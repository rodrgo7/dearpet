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
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import oliveiradev.pets.DearPet.models.PessoaFisica;
import oliveiradev.pets.DearPet.services.PessoaFisicaService;

@RestController
@RequestMapping("/v1/pessoa-fisica")
@Tag(name = "Pessoa Física", description = "Endpoints para gerenciamento de pessoas físicas")
public class PessoaFisicaController {
    @Autowired
    private PessoaFisicaService pfService;

    @Operation(summary = "Lista todas as pessoas físicas", description = "Retorna uma lista de todas as pessoas físicas cadastradas no sistema")
    @ApiResponse(responseCode = "200", description = "Pessoas físicas encontradas com sucesso")
    @GetMapping
    public ResponseEntity<List<PessoaFisica>> findAll() {
        return ResponseEntity.ok(pfService.findAll());
    }

    @Operation(summary = "Busca pessoa física por ID", description = "Retorna uma pessoa física específica baseada no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pessoa física encontrada"),
        @ApiResponse(responseCode = "404", description = "Pessoa física não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisica> findById(@PathVariable long id) {
        return ResponseEntity.ok(pfService.findById(id));
    }

    @Operation(summary = "Cria uma nova pessoa física", description = "Cria um novo registro de pessoa física com os dados fornecidos")
    @ApiResponse(responseCode = "200", description = "Pessoa física criada com sucesso")
    @PostMapping
    public ResponseEntity<PessoaFisica> create(@Valid @RequestBody PessoaFisica pessoaFisica) {
        return ResponseEntity.ok(pfService.save(pessoaFisica));
    }

    @Operation(summary = "Atualiza uma pessoa física", description = "Atualiza os dados de uma pessoa física existente baseado no ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pessoa física atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pessoa física não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PessoaFisica> update(@PathVariable long id, @Valid @RequestBody PessoaFisica pessoaFisica) {
        pessoaFisica.setId(id);
        return ResponseEntity.ok(pfService.save(pessoaFisica));
    }

    @Operation(summary = "Remove uma pessoa física", description = "Remove uma pessoa física do sistema baseado no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pessoa física removida com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pessoa física não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletepf(@PathVariable long id) {
        pfService.delete(id);
        return ResponseEntity.noContent().build();
    }
}