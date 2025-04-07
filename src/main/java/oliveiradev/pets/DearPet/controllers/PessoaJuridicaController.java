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
import oliveiradev.pets.DearPet.models.PessoaJuridica;
import oliveiradev.pets.DearPet.services.PessoaJuridicaService;

@RestController
@RequestMapping("/v1/pessoa-juridica")
@Tag(name = "Pessoa Jurídica", description = "Endpoints para gerenciamento de pessoas jurídicas")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService pjService;

    @Operation(summary = "Lista todas as pessoas jurídicas", description = "Retorna uma lista de todas as pessoas jurídicas cadastradas no sistema")
    @ApiResponse(responseCode = "200", description = "Pessoas jurídicas encontradas com sucesso")
    @GetMapping
    public ResponseEntity<List<PessoaJuridica>> findAll() {
        return ResponseEntity.ok(pjService.findAll());
    }

    @Operation(summary = "Busca pessoa jurídica por ID", description = "Retorna uma pessoa jurídica específica baseada no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pessoa jurídica encontrada"),
        @ApiResponse(responseCode = "404", description = "Pessoa jurídica não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PessoaJuridica> findById(@PathVariable long id) {
        return ResponseEntity.ok(pjService.findById(id));
    }

    @Operation(summary = "Cria uma nova pessoa jurídica", description = "Cria um novo registro de pessoa jurídica com os dados fornecidos")
    @ApiResponse(responseCode = "200", description = "Pessoa jurídica criada com sucesso")
    @PostMapping
    public ResponseEntity<PessoaJuridica> create(@Valid @RequestBody PessoaJuridica PessoaJuridica) {
        return ResponseEntity.ok(pjService.save(PessoaJuridica));
    }

    @Operation(summary = "Atualiza uma pessoa jurídica", description = "Atualiza os dados de uma pessoa jurídica existente baseado no ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pessoa jurídica atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pessoa jurídica não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PessoaJuridica> update(@PathVariable long id, @Valid @RequestBody PessoaJuridica PessoaJuridica) {
        PessoaJuridica.setId(id);
        return ResponseEntity.ok(pjService.save(PessoaJuridica));
    }

    @Operation(summary = "Remove uma pessoa jurídica", description = "Remove uma pessoa jurídica do sistema baseado no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pessoa jurídica removida com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pessoa jurídica não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletepj(@PathVariable long id) {
        pjService.delete(id);
        return ResponseEntity.noContent().build();
    }
}