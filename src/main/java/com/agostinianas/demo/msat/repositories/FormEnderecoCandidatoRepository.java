package com.agostinianas.demo.msat.repositories;

import com.agostinianas.demo.msat.entity.FormEnderecoCandidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface FormEnderecoCandidatoRepository  extends JpaRepository<FormEnderecoCandidato, Long> {
    Optional<FormEnderecoCandidato> findByCep(String cep);
}
