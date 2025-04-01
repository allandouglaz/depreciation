package com.i9.depreciation.model.controller;

import com.i9.depreciation.model.Depreciacao;
import com.i9.depreciation.repository.DepreciacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depreciacao")
public class DepreciacaoController {
    private final DepreciacaoRepository repository;

    public DepreciacaoController(DepreciacaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Depreciacao calcularDepreciacao(@RequestBody Depreciacao depreciacao) {
        depreciacao = new Depreciacao(
                depreciacao.getValorInicial(),
                depreciacao.getValorResidual(),
                depreciacao.getVidaUtil()
        );
        return repository.save(depreciacao);
    }

    @GetMapping
    public List<Depreciacao> listarDepreciacoes() {
        return repository.findAll();
    }
}
