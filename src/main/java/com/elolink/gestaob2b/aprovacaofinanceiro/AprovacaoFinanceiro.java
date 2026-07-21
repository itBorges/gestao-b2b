package com.elolink.gestaob2b.aprovacaofinanceiro;

import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import com.elolink.gestaob2b.proposta.Proposta;
import com.elolink.gestaob2b.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aprovacao_financeiro")
@Getter
@NoArgsConstructor
public class AprovacaoFinanceiro extends EntidadeBase {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="proposta_id", nullable = false)
    private Proposta proposta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario aprovadoPor;

    @Enumerated(EnumType.STRING)
    @Column(name = "resultado_aprovacao",nullable = false)
    private ResultadoAprovacao resultadoAprovacao;

    @Column(name = "observacao", nullable = false, length = 2000)
    private String observacao;

    public AprovacaoFinanceiro(
            Proposta proposta,
            Usuario aprovadoPor

    ){
        this.aprovadoPor = aprovadoPor;
        this.proposta = proposta;
    }

    public void inserirObservacao(
            String observacao
    ){
        this.observacao = observacao;
    }

}
