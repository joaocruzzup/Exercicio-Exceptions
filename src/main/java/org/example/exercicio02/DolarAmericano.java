package org.example.exercicio02;

import java.math.BigDecimal;

public class DolarAmericano extends Moeda implements Cotavel{

    @Override
    public BigDecimal obterCotacao() {
        return new BigDecimal("5.25");
    }

    @Override
    public BigDecimal converter(BigDecimal valor) {
        return valor.multiply(obterCotacao());
    }

    @Override
    public String obterNome() {
        return "Dólar Americano";
    }
}
