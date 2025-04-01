package com.i9.depreciation.controller;

import com.i9.depreciation.dto.DepreciacaoResponseDto;
import com.i9.depreciation.model.Depreciacao;
import com.i9.depreciation.service.DepreciacaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DepreciacaoController {

    private DepreciacaoService depreciacaoService;

    @CrossOrigin(origins = "http://localhost:3000") // Permite o frontend de localhost:3000
    @PostMapping("/depreciacao")
    public DepreciacaoResponseDto calcularDepreciacao(@RequestBody Depreciacao depreciacao) {
        return depreciacaoService.calcularDepreciacao(depreciacao);
    }

}

