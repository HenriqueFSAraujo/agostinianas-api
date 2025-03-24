package com.agostinianas.demo.msat.repositories;

import com.agostinianas.demo.msat.entity.FormDadosParentes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormDadosParentesRepository extends JpaRepository<FormDadosParentes, Long> {

    List<FormDadosParentes> findByParent1Cpf(String cpf);
}
