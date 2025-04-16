package com.agostinianas.demo.msat.repositories;

import com.agostinianas.demo.msat.entity.FormCondicoesHabitacionais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormCondicoesHabitacionaisRepository extends JpaRepository<FormCondicoesHabitacionais, Long> {
}
