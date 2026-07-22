package com.elolink.gestaob2b.usuario;


import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Usuario extends EntidadeBase {

    @Column(name = "nome_completo", nullable = false, length = 300)
    private String nomeCompleto;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "matricula", nullable = false,length = 8)
    private String matricula;

    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @Column(name = "email", length = 320)
    private String email;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    @Column (name = "papel", nullable = false, length = 20)
    private PapelUsuario papel;

    public Usuario (
        String nomeCompleto,
        String cpf,
        String matricula,
        boolean ativo,
        PapelUsuario papel
    ){
        this.ativo = ativo;
        this.cpf = cpf;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.papel = papel;
    }

    public void inserirEmail(
            String email
    ){
        this.email = email;
    }

    public void inserirTelefone(
            String telefone
    ){
        this.telefone = telefone;
    }

}
