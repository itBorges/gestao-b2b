package com.elolink.gestaob2b.proposta;


import com.elolink.gestaob2b.cliente.Cliente;
import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import com.elolink.gestaob2b.itemproposta.ItemProposta;
import com.elolink.gestaob2b.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propostas")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
public class Proposta extends EntidadeBase {

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", length = 2000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_proposta", nullable = false, length = 30)
    private StatusProposta status;

    @Column(name = "valor_subtotal", nullable = false, precision = 19, scale = 2)
    private BigDecimal valorSubtotal;

    @Column(name = "valor_desconto", precision = 19, scale = 2)
    private BigDecimal valorDesconto;

    @Column(name = "observacao", length = 500)
    private String observacao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(
            mappedBy = "proposta",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ItemProposta> itensProposta = new ArrayList<>();

    public Proposta(
            String titulo,
            StatusProposta status,
            BigDecimal valorSubtotal,
            boolean ativo,
            Cliente cliente,
            Usuario usuario
    ) {
        this.ativo = ativo;
        this.status = status;
        this.valorSubtotal = valorSubtotal;
        this.titulo = titulo;
        this.cliente = cliente;
        this.usuario = usuario;
    }

    public void inserirDescricao(
            String descricao
    ) {
        this.descricao = descricao;
    }

    public void inserirValorDesconto(
            BigDecimal valorDesconto
    ) {
        this.valorDesconto = valorDesconto;
    }

    public void inserirObeservacao(
            String observacao
    ) {
        this.observacao = observacao;
    }
}

