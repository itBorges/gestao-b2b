package com.elolink.gestao_b2b.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
public class Usuario extends EntidadeBase{

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 254)
    private String email;

    @Column(nullable = false)
    private boolean ativo;



}
