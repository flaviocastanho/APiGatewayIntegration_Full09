package com.example.pecas.controller; 

import com.example.pecas.model.Componente;
import com.example.pecas.model.Peca;
import com.example.pecas.repository.ComponenteRepository;
import com.example.pecas.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/peca")
public class PecaController {

    @Autowired
    private PecaRepository pecaRepository;

    @Autowired
    private ComponenteRepository componenteRepository;

    // POST /api/v1/peca
    @PostMapping
    public ResponseEntity<Peca> criarPeca(@RequestBody Peca peca) {
        return ResponseEntity.ok(pecaRepository.save(peca));
    }

    // POST /api/v1/peca/{codigo}/componente
    @PostMapping("/{codigo}/componente")
    public ResponseEntity<Componente> adicionarComponente(
            @PathVariable String codigo,
            @RequestBody Componente componente) {
        Peca peca = pecaRepository.findByCodigo(codigo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        componente.setPeca(peca);
        return ResponseEntity.ok(componenteRepository.save(componente));
    }

    // @GetMapping("/{codigo}")
    // public ResponseEntity<Peca> buscarPorCodigo(@PathVariable String codigo) {
    //     return pecaRepository.findByCodigo(codigo)
    //         .map(ResponseEntity::ok)
    //         .orElseThrow(() -> new ResponseStatusException(
    //             HttpStatus.NOT_FOUND, "Peça não encontrada com código: " + codigo));
    // }

    // // Exemplo com parâmetro opcional na URL: /api/v1/peca?nome=Filtro
    // @GetMapping("/busca")
    // public ResponseEntity<String> buscarPorNome(@RequestParam(required = false) String nome) {
    //     if (nome == null) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não fornecido");
    //     }
    //     return ResponseEntity.ok("Peça com nome: " + nome);
    // }
    // @GetMapping("/{codigo}")
    // public String buscar(@PathVariable String codigo) {
    //     return "Peça com código: " + codigo;
    // }

    // GET /api/v1/peca/{codigo}
    // @GetMapping("/{codigo}")
    // public ResponseEntity<Peca> buscarPeca(@PathVariable String codigo) {
    //     return ResponseEntity.of(pecaRepository.findByCodigo(codigo));
    // }

    // @GetMapping("/{codigo}")
    // public ResponseEntity<Peca> buscarPeca(@PathVariable String codigo) {
    //     try {
    //         return ResponseEntity.of(pecaRepository.findByCodigo(codigo));
    //     } catch (Exception e) {
    //         e.printStackTrace(); // Mostra o erro no terminal
    //         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno: " + e.getMessage());
    //     }
    // }

    // @GetMapping("/{codigo}")
    // public ResponseEntity<Peca> buscarPeca(@PathVariable String codigo) {
    //     Optional<Peca> peca = pecaRepository.findByCodigo(codigo);
    //     if (peca.isPresent()) {
    //         return ResponseEntity.ok(peca.get());
    //     } else {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Peça com código " + codigo + " não encontrada.");
    //     }
    // }

    @GetMapping("/{codigo}")
    public ResponseEntity<Peca> getProductById(@PathVariable String codigo) {
        return ResponseEntity.of(pecaRepository.findByCodigo(codigo));
    }

    // GET /api/v1/peca
    @GetMapping
    public List<Peca> listarPecas() {
        return pecaRepository.findAll();
    }

    // GET /api/v1/peca/{codigo}/componente
    @GetMapping("/{codigo}/componente")
    public List<Componente> listarComponentes(@PathVariable String codigo) {
        return componenteRepository.findByPecaCodigo(codigo);
    }
}
