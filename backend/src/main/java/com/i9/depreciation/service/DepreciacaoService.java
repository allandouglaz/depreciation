package com.i9.depreciation.service;

import com.i9.depreciation.dto.DepreciacaoResponseDto;
import com.i9.depreciation.model.Depreciacao;
import com.i9.depreciation.repository.DepreciacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        // Se o valor residual não for informado, calcula automaticamente
        double valorResidual = dto.getValorResidual();
        if (valorResidual <= 0) {
            valorResidual = dto.getValorInicial() * Math.pow(0.9, dto.getVidaUtil()); // 10% de depreciação por ano
        }

        double depreciacaoAnual = (dto.getValorInicial() - valorResidual) / dto.getVidaUtil();
        double valorFinal = dto.getValorInicial() - (depreciacaoAnual * dto.getVidaUtil());

        Depreciacao depreciacao = new Depreciacao(dto.getValorInicial(), valorResidual, dto.getVidaUtil());
        repository.save(depreciacao);

        logger.info("Depreciação calculada e salva: {}", depreciacao);

        return new DepreciacaoResponseDto(depreciacaoAnual, valorFinal, dto.getValorInicial(), valorResidual);
    }
}
