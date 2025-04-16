package com.agostinianas.demo.msat.repositories;

import com.agostinianas.demo.msat.entity.FormDadosParentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FormDadosParentesRepository extends JpaRepository<FormDadosParentes, Long> {

    List<FormDadosParentes> findByParent1Cpf(String cpf);
}
