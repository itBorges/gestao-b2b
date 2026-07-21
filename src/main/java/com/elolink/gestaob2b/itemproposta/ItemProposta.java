package com.elolink.gestaob2b.itemproposta;


import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import com.elolink.gestaob2b.produto.Produto;
import com.elolink.gestaob2b.proposta.Proposta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tools.jackson.databind.annotation.JsonAppend;

import java.math.BigDecimal;

@Entity
@Table(name = "item_proposta")
@NoArgsConstructor
@Getter
public class ItemProposta extends EntidadeBase {

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    @Column(name = "quantidade", nullable = false)
    private BigDecimal quantidade;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @Column(name = "observacao", nullable = false, length = 500)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposta_id", nullable = false)
    private Proposta proposta;

    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public ItemProposta(
            Double valorUnitario,
            BigDecimal quantidade,
            Double valorTotal
    ) {
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.valorUnitario = valorUnitario;
    }


}
