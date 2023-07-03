package org.example.exercicio01;

import java.math.BigDecimal;

public class Alimento {
    TipoAlimento tipoAlimento;
    private BigDecimal quantidade;

    public Alimento(TipoAlimento tipoAlimento, BigDecimal quantidade) {
        this.tipoAlimento = tipoAlimento;
        this.quantidade = quantidade;
    }
    public Alimento(){

    }

    public TipoAlimento getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(TipoAlimento tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
