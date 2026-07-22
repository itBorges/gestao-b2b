package com.elolink.gestaob2b.produto;


import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@NoArgsConstructor

public class Produto extends EntidadeBase {

    @Column(name = "sku", nullable = false, length = 100)
    private String sku;

    @Column(name = "codigoFabricante", length = 150)
    private String codigoFabricante;

    @Column(name = "gtin", nullable = false, length = 14)
    private String gtin;   //codigo de barras

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "marca", length = 150)
    private String marca;

    @Column(name = "fabricante", nullable = false, length = 200)
    private String fabricante;

    @Column(name = "categoria", nullable = false, length = 150)
    private String categoria;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "preco_base", nullable = false, precision = 19, scale = 2)
    private BigDecimal precoBase;

    public Produto(
            String sku,
            String gtin,
            String nome,
            String fabricante,
            String categoria,
            BigDecimal precoBase,
            boolean ativo

    ) {
        this.categoria = categoria;
        this.gtin = gtin;
        this.nome = nome;
        this.fabricante = fabricante;
        this.sku = sku;
        this.precoBase = precoBase;
        this.ativo = ativo;

    }

    public void inserirCodigoFabricante(
            String codigoFabricante
    ) {
        this.codigoFabricante = codigoFabricante;
    }

    public void inserirDescricao(
            String descricao
    ) {
        this.descricao = descricao;
    }

    public void inserirMarca(
            String marca
    ) {
        this.marca = marca;
    }


}
