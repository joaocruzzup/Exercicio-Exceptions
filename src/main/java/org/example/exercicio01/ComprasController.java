package org.example.exercicio01;

import java.math.BigDecimal;
import java.util.Scanner;

public class ComprasController implements Compravel{

    private AlimentoEntrada alimentoEntrada;

    public ComprasController(AlimentoEntrada alimentoEntrada) {
        this.alimentoEntrada = alimentoEntrada;
    }

    public Alimento comprarAlimento() {
        TipoAlimento tipoAlimento = alimentoEntrada.lerTipoAlimento();
        BigDecimal quantidade = alimentoEntrada.lerQuantidade(tipoAlimento);
        return new Alimento(tipoAlimento, quantidade);
    }
}
