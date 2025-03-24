package com.agostinianas.demo.msat.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "candidatos")
@Getter
@Setter
public class FormEnderecoCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    @Column(name = "residencia")
    private String residencia;

    @Column(name = "transporte_educacional")
    private String transporteEducacional;

    @Column(name = "tempo_deslocamento")
    private String tempoDeslocamento;

    @Column(name = "atividades_contraturno")
    private String atividadesContraturno;

    @Column(name = "telefone_residencial")
    private String telefoneResidencial;

    @Column(name = "telefone_trabalho")
    private String telefoneTrabalho;

    @Column(name = "telefone_celular")
    private String telefoneCelular;

    @Column(name = "email_confirmacao")
    private String emailConfirmacao;

    @Column(name = "responsavel_legal")
    private String responsavelLegal;

    @Column(name = "segmento_2025")
    private String segmento2025;
}

