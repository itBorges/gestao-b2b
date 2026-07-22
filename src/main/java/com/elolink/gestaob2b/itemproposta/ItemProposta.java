package com.elolink.gestaob2b.itemproposta;


import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import com.elolink.gestaob2b.produto.Produto;
import com.elolink.gestaob2b.proposta.Proposta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "item_proposta")
@NoArgsConstructor
@Getter
public class ItemProposta extends EntidadeBase {

    @Column(name = "valor_unitario", nullable = false, precision = 19, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "quantidade", nullable = false, precision = 19, scale = 3)
    private BigDecimal quantidade;

    @Column(name = "valor_total", nullable = false, precision = 19, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "observacao", nullable = false, length = 500)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposta_id", nullable = false)
    private Proposta proposta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public ItemProposta(
            BigDecimal valorUnitario,
            BigDecimal quantidade,
            Proposta proposta,
            Produto produto
    ) {
        this.quantidade = quantidade;
        this.valorTotal = valorUnitario.multiply(quantidade).setScale()
        this.produto = produto;
        this.proposta = proposta;
    }

    public void inserirObservacao(
            String observacao
    ) {
        this.observacao = observacao;
    }

}
