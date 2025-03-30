package com.agostinianas.demo.msat.dto;

import com.agostinianas.demo.msat.enums.AbastecimentoAguaEnum;
import com.agostinianas.demo.msat.enums.EsgotoSanitarioEnum;
import com.agostinianas.demo.msat.enums.EstruturaFisicaEnum;
import com.agostinianas.demo.msat.enums.FornecimentoEnergiaEnum;
import com.agostinianas.demo.msat.enums.SituacaoImovelEnum;
import com.agostinianas.demo.msat.enums.TipoImovelEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CondicoesHabitacionaisDTO {

    @JsonProperty("situacaoImovel")
    private SituacaoImovelEnum situacaoImovel;

    @JsonProperty("tipoImovel")
    private TipoImovelEnum tipoImovel;

    @JsonProperty("estruturaFisica")
    private EstruturaFisicaEnum estruturaFisica;

    @JsonProperty("esgotoSanitario")
    private EsgotoSanitarioEnum esgotoSanitario;

    @JsonProperty("fornecimentoEnergia")
    private FornecimentoEnergiaEnum fornecimentoEnergia;

    @JsonProperty("abastecimentoAgua")
    private AbastecimentoAguaEnum abastecimentoAgua;
}
