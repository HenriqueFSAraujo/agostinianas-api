package com.agostinianas.demo.msat.repositories;

import com.agostinianas.demo.msat.entity.FormDadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormRepository extends JpaRepository<FormDadosPessoais, Long> {
}
