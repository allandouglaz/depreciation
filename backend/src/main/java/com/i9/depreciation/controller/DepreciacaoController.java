package com.i9.depreciation.controller;

import com.i9.depreciation.dto.DepreciacaoDto;
import com.i9.depreciation.dto.DepreciacaoResponseDto;
import com.i9.depreciation.model.Depreciacao;
import com.i9.depreciation.repository.DepreciacaoRepository;
import com.i9.depreciation.service.DepreciacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depreciacao")
public class DepreciacaoController {
    private final DepreciacaoService service;

    public DepreciacaoController(DepreciacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepreciacaoResponseDto> calcularDepreciacao(@RequestBody DepreciacaoDto dto) {
        return ResponseEntity.ok(service.calcularDepreciacao(dto));
    }

}

