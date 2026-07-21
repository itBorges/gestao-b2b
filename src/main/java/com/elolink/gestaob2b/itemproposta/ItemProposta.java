package com.elolink.gestaob2b.itemproposta;


import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="item_proposta")
@NoArgsConstructor
@Getter
public class ItemProposta extends EntidadeBase {

    @Column(name = "valor_unitario",nullable = false )
    private Double valorUnitario;

    @Column(name ="quantidade" ,nullable = false )
    private BigDecimal quantidade;

    @Column(name ="valor_total" ,nullable = false )
    private Double valorTotal;

    @Column(name = "observacao",nullable = false,length =500 )
    private String observacao;

    public ItemProposta(
            Double valorUnitario,
            BigDecimal quantidade,
            Double valorTotal
    ){
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.valorUnitario = valorUnitario;
    }


}
