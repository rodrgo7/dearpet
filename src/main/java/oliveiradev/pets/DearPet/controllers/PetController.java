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
import oliveiradev.pets.DearPet.models.Pet;
import oliveiradev.pets.DearPet.services.PetService;

@RestController
@RequestMapping("/v1/pets")
@Tag(name = "Pets", description = "Endpoints para gerenciamento de pets")
public class PetController {

    @Autowired
    private PetService petService;

    @Operation(summary = "Lista todos os pets", description = "Retorna uma lista de todos os pets cadastrados no sistema")
    @ApiResponse(responseCode = "200", description = "Pets encontrados com sucesso")
    @GetMapping
    public ResponseEntity<List<Pet>> findAll() {
        return ResponseEntity.ok(petService.findAll());
    }

    @Operation(summary = "Busca pet por ID", description = "Retorna um pet específico baseado no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pet encontrado"),
        @ApiResponse(responseCode = "404", description = "Pet não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable long id) {
        return ResponseEntity.ok(petService.findById(id));
    }

    @Operation(summary = "Cria um novo pet", description = "Cria um novo registro de pet com os dados fornecidos")
    @ApiResponse(responseCode = "200", description = "Pet criado com sucesso")
    @PostMapping
    public ResponseEntity<Pet> create(@Valid @RequestBody Pet pet) {
        return ResponseEntity.ok(petService.save(pet));
    }

    @Operation(summary = "Atualiza um pet", description = "Atualiza os dados de um pet existente baseado no ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pet atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pet não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Pet> update(@PathVariable long id, @Valid @RequestBody Pet pet) {
        pet.setId(id);
        return ResponseEntity.ok(petService.save(pet));
    }

    @Operation(summary = "Remove um pet", description = "Remove um pet do sistema baseado no ID fornecido")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Pet removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pet não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }
}