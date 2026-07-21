package com.elolink.gestaob2b.proposta;


import com.elolink.gestaob2b.cliente.Cliente;
import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import com.elolink.gestaob2b.itemproposta.ItemProposta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proposta")
@NoArgsConstructor
@Getter
public class Proposta extends EntidadeBase {

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", length =2000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_proposta", nullable = false)
    private StatusProposta status;

    @Column(name = "valor_subtotal", nullable = false)
    private Double valorSubtotal;

    @Column(name = "valor_desconto")
    private Double valorDesconto;

    @Column(name = "observacao", length =  500)
    private String observacao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(
            mappedBy = "proposta",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ItemProposta> itensProposta = new ArrayList<>();

    public Proposta(
            String titulo,
            StatusProposta status,
            Double valorSubtotal,
            boolean ativo
    ) {
        this.ativo = ativo;
        this.status = status;
        this.valorSubtotal = valorSubtotal;
        this.titulo = titulo;
    }

    public void inserirDescricao(
            String descricao
    ) {
        this.descricao = descricao;
    }

    public void inserirValorDesconto(
            Double valorDesconto
    ) {
        this.valorDesconto = valorDesconto;
    }

    public void inserirObeservacao(
        String observacao
    ){
        this.observacao=observacao;
    }
}

