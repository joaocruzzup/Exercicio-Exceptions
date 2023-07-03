package org.example.exercicio02;

import java.math.BigDecimal;

public class LibraEsterlina extends Moeda implements Cotavel{

    @Override
    public BigDecimal obterCotacao() {
        return new BigDecimal("7.50");
    }

    @Override
    public BigDecimal converter(BigDecimal valor) {
        return valor.multiply(obterCotacao());
    }

    @Override
    public String obterNome() {
        return "Libra Esterlina";
    }
}
