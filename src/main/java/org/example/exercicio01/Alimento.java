package org.example.exercicio01;

public class Alimento {
    TipoAlimento tipoAlimento;
    private Number quantidade;

    public Alimento(TipoAlimento tipoAlimento, Number quantidade) {
        this.tipoAlimento = tipoAlimento;
        this.quantidade = quantidade;
    }

    public TipoAlimento getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(TipoAlimento tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public void setQuantidade(Number quantidade) {
        this.quantidade = quantidade;
    }
}
