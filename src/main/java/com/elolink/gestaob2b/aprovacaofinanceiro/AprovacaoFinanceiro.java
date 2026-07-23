package com.elolink.gestaob2b.aprovacaofinanceiro;

import com.elolink.gestaob2b.entidadebase.EntidadeBase;
import com.elolink.gestaob2b.proposta.Proposta;
import com.elolink.gestaob2b.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aprovacoes_financeiras")
@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class AprovacaoFinanceiro extends EntidadeBase {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposta_id", nullable = false)
    private Proposta proposta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario aprovadoPor;

    @Enumerated(EnumType.STRING)
    @Column(name = "resultado_aprovacao", nullable = false, length = 30)
    private ResultadoAprovacao resultadoAprovacao;

    @Column(name = "observacao", length = 2000)
    private String observacao;

    public AprovacaoFinanceiro(
            Proposta proposta,
            Usuario aprovadoPor,
            ResultadoAprovacao resultadoAprovacao

    ) {
        this.aprovadoPor = aprovadoPor;
        this.proposta = proposta;
        this.resultadoAprovacao = resultadoAprovacao;
    }

    public void inserirObservacao(
            String observacao
    ) {
        this.observacao = observacao;
    }

}
