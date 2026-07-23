package com.elolink.gestaob2b.cliente;

import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import com.elolink.gestaob2b.proposta.Proposta;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "clientes")
@Getter
@NoArgsConstructor
public class Cliente extends EntidadeBase {

    @Column(name = "nome_fantasia", nullable = false, length = 120)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false, length = 60)
    private String razaoSocial;

    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "email", length = 320)
    private String email;

    @Pattern(regexp = "^[0-9]{10,11}$")
    @Column(name = "telefone", length = 11)
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Proposta> propostas = new ArrayList<>();

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

    public void inserirTelefone(String telefone) {
        this.telefone = telefone;
    }


}
