package com.elolink.gestaob2b.cliente;

import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "clientes")
@Getter
@NoArgsConstructor
public class Cliente extends EntidadeBase {

    @Column(name = "nome_fantasia", nullable = false, length = 120)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false, length = 60)
    private String razaoSocial;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "email", length = 320)
    private String email;

    @Column(name = "numeroCelular", length = 9)
    private String numeroCelular;

    public Cliente(
            String nomeFantasia,
            String razaoSocial,
            String cnpj
    ) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;

    }

    public void inserirEmail(
            String email
    ) {
        this.email = email;
    }

    public void inserirNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }


}
