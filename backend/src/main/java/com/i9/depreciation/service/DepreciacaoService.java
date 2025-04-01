package com.i9.depreciation.service;

import com.i9.depreciation.dto.DepreciacaoResponseDto;
import com.i9.depreciation.model.Depreciacao;
import com.i9.depreciation.repository.DepreciacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DepreciacaoService {
    private static final Logger logger = LoggerFactory.getLogger(DepreciacaoService.class);
    private final DepreciacaoRepository repository;

    public DepreciacaoService(DepreciacaoRepository repository) {
        this.repository = repository;
    }

    public DepreciacaoResponseDto calcularDepreciacao(Depreciacao dto) {
        if (dto.getVidaUtil() <= 0) {
            throw new IllegalArgumentException("A vida útil deve ser maior que zero.");
        }

        double depreciacaoAnual = (dto.getValorInicial() - dto.getValorResidual()) / dto.getVidaUtil();
        double valorFinal = dto.getValorInicial() - (depreciacaoAnual * dto.getVidaUtil());

        Depreciacao depreciacao = new Depreciacao(dto.getValorInicial(), dto.getValorResidual(), dto.getVidaUtil());
        repository.save(depreciacao);

        logger.info("Depreciação calculada e salva: {}", depreciacao);

        return new DepreciacaoResponseDto(depreciacaoAnual, valorFinal, dto.getValorInicial(), dto.getValorResidual());
    }

}
