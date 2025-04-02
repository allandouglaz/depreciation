package com.i9.depreciation.controller;

import com.i9.depreciation.dto.DepreciacaoResponseDto;
import com.i9.depreciation.model.Depreciacao;
import com.i9.depreciation.service.DepreciacaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/depreciacao")
public class DepreciacaoController {

    private final DepreciacaoService service;

    public DepreciacaoController(DepreciacaoService service) {
        this.service = service;
    }

    @PostMapping("/calcular")
    public DepreciacaoResponseDto calcular(@RequestBody Depreciacao depreciacao) {
        return service.calcularDepreciacao(depreciacao);
    }
}
