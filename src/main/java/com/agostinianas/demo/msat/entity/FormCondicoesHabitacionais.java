package com.agostinianas.demo.msat.entity;

import com.agostinianas.demo.msat.enums.AbastecimentoAguaEnum;
import com.agostinianas.demo.msat.enums.EsgotoSanitarioEnum;
import com.agostinianas.demo.msat.enums.EstruturaFisicaEnum;
import com.agostinianas.demo.msat.enums.FornecimentoEnergiaEnum;
import com.agostinianas.demo.msat.enums.SituacaoImovelEnum;
import com.agostinianas.demo.msat.enums.TipoImovelEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "form_condicoes_habitacionais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormCondicoesHabitacionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SituacaoImovelEnum situacaoImovel;

    @Enumerated(EnumType.STRING)
    private TipoImovelEnum tipoImovel;

    @Enumerated(EnumType.STRING)
    private EstruturaFisicaEnum estruturaFisica;

    @Enumerated(EnumType.STRING)
    private EsgotoSanitarioEnum esgotoSanitario;

    @Enumerated(EnumType.STRING)
    private FornecimentoEnergiaEnum fornecimentoEnergia;

    @Enumerated(EnumType.STRING)
    private AbastecimentoAguaEnum abastecimentoAgua;
}
