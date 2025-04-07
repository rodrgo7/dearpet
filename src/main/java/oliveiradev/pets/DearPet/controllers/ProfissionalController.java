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
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import oliveiradev.pets.DearPet.models.Profissional;
import oliveiradev.pets.DearPet.services.ProfissionalService;

@RestController
@RequestMapping("/api/profissionais")
@Tag(name = "Profissionais", description = "Endpoints para gerenciamento de profissionais")
public class ProfissionalController {
    @Autowired
    private ProfissionalService profissionalService;

    @Operation(summary = "Lista todos os profissionais", description = "Retorna uma lista de todos os profissionais cadastrados no sistema")
    @ApiResponse(responseCode = "200", description = "Profissionais encontrados com sucesso")
    @GetMapping
    public List<Profissional> findAll() {
        return profissionalService.findAll();
    }

    @Operation(summary = "Busca profissional por ID", description = "Retorna um profissional específico baseado no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Profissional encontrado"),
        @ApiResponse(responseCode = "404", description = "Profissional não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Profissional> findById(@PathVariable Long id) {
        Profissional profissional = profissionalService.findById(id);
        return ResponseEntity.ok(profissional);
    }

    @Operation(summary = "Cria um novo profissional", description = "Cria um novo registro de profissional com os dados fornecidos")
    @ApiResponse(responseCode = "200", description = "Profissional criado com sucesso")
    @PostMapping
    public Profissional create(@Valid @RequestBody Profissional profissional) {
        return profissionalService.save(profissional);
    }

    @Operation(summary = "Atualiza um profissional", description = "Atualiza os dados de um profissional existente baseado no ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Profissional atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Profissional não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Profissional> update(@PathVariable Long id, @Valid @RequestBody Profissional profissional) {
        Profissional updatedProfissional = profissionalService.update(id, profissional);
        if (updatedProfissional != null) {
            return ResponseEntity.ok(updatedProfissional);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Remove um profissional", description = "Remove um profissional do sistema baseado no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Profissional removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Profissional não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profissionalService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 