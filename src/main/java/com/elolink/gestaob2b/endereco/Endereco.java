package com.elolink.gestaob2b.endereco;


import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Enderecos")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Endereco extends EntidadeBase {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private TipoEndereco tipo;

    @Column(name = "cep", nullable = false, length = 8)
    private String cep;

    @Column(name = "logradouro", nullable = false, length = 150)
    private String logradouro;

    @Column(name = "numero", length = 20)
    private String numero;

    @Column(name = "complemento", length = 100)
    private String complemento;

    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "estado", nullable = false, length = 2)
    private String estado;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    public Endereco(
        TipoEndereco tipo,
        String cep,
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado

    ){
        this.tipo = tipo;
        this.cep =cep;
        this.logradouro =logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;

    }

    public void informarComplemento(
            String complemento
    ){
        this.complemento=complemento;
    }

}
