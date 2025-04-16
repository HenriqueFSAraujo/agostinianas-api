package com.agostinianas.demo.msat.repositories;

import com.agostinianas.demo.msat.entity.FormEnderecoCandidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface FormEnderecoCandidatoRepository  extends JpaRepository<FormEnderecoCandidato, Long> {
    Optional<FormEnderecoCandidato> findByCep(String cep);
}
