package org.example.exercicio02;

import java.math.BigDecimal;

public interface Cotavel {
    public abstract BigDecimal obterCotacao();
    public abstract BigDecimal converter(BigDecimal valor)
            ;
}
