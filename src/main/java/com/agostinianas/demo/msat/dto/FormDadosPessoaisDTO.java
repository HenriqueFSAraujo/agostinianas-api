package com.agostinianas.demo.msat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class FormDadosPessoaisDTO {

    private Long id;

    @JsonProperty("username")
    private String fullName;

    @JsonProperty("login")
    private String login;

    @JsonProperty("email")
    private String email;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("cpfScholarship")

    private String cpfBolsista;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dateBirth")
    private LocalDate dataNascimento;

    @JsonProperty("deficiency")
    private String pcd;

    @JsonProperty("educasenso")
    private String numEducasenso;

    @JsonProperty("parent1Cpf")
    private String parent1Cpf;

    @JsonProperty ( "parent1FullName" )
    private String parent1FullName;

    @JsonProperty("parent1Phone" )
    private String parent1Phone;

    @JsonProperty ( "parent1MaritalStatus" )
    private String parent1MaritalStatus;

    @JsonProperty( "parent2Cpf")
    private String parent2Cpf;

    @JsonProperty ( "parent2FullName" )
    private String parent2FullName;

    @JsonProperty ( "parent2Phone" )
    private String parent2Phone;

    @JsonProperty ( "parent2MaritalStatus" )
    private String parent2MaritalStatus;

    @JsonProperty ("residesWithBothParents" )
    private String residesWithBothParents;
}