package com.elolink.gestaob2b.usuario;


import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
public class Usuario extends EntidadeBase {

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 254)
    private String email;

    @Column(nullable = false)
    private boolean ativo;



}
