package com.agostinianas.demo.msat.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormEnderecoCandidatoDTO {
    private Long id;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String pontoReferencia;
    private String residencia;
    private String transporteEducacional;
    private String tempoDeslocamento;
    private String atividadesContraturno;
    private String telefoneResidencial;
    private String telefoneTrabalho;
    private String telefoneCelular;
    private String emailConfirmacao;
    private String responsavelLegal;
    private String segmento2025;
}

