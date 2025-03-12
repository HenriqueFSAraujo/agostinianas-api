package com.agostinianas.demo.msat.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "fomulario_alunos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Form {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "username")
        private String username;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "fullname")
        private String fullName;

        @Column(name = "cpf")
        private String cpf;

        @Column(name = "phone")
        private String phone;

        @Column(name = "gender")
        private String gender;

        @Column(name = "cpfBolsista")
        private String cpfBolsista;

        @Column(name = "dataNascimento")
        private LocalDate dataNascimento;

        @Column(name = "numEducasenso")
        private String numEducasenso;

        @Column(name = "PCD")
        private String pcd;

        @Column(name = "parent1Cpf")
        private String parent1Cpf;

        @Column (name = "parent1FullName" )
        private String parent1FullName;

        @Column (name = "parent1Phone" )
        private String parent1Phone;

        @Column (name = "parent1Phone" )
        private String parent1MaritalStatus;

        @Column(name = "parent1Cpf")
        private String parent2Cpf;

        @Column (name = "parent1FullName" )
        private String parent2FullName;

        @Column (name = "parent1Phone" )
        private String parent2Phone;

        @Column (name = "parent1Phone" )
        private String parent2MaritalStatus;

        @Column (name = "residesWithBothParents" )
        private String residesWithBothParents;


}
