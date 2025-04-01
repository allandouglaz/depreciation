package com.i9.depreciation.repository;

import com.i9.depreciation.model.Depreciacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepreciacaoRepository extends JpaRepository<Depreciacao, Long> {}

