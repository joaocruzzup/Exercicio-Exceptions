package org.example.exercicio01;

import java.math.BigDecimal;
import java.util.Scanner;

public class AlimentoEntrada {
    private Scanner scanner;

    public AlimentoEntrada() {
        this.scanner = new Scanner(System.in);
    }

    public TipoAlimento lerTipoAlimento() {
        System.out.println("Digite o tipo de alimento que você deseja, exatamente como está no menu:");
        System.out.print("Digite aqui: ");
        String tipoDigitado = scanner.nextLine().toUpperCase();
        verificaTipoAlimento(tipoDigitado);
        return TipoAlimento.valueOf(tipoDigitado);
    }

    public BigDecimal lerQuantidade(TipoAlimento tipoAlimento) {
        System.out.println("Digite a quantidade que deseja comprar: ");
        BigDecimal quantidade = scanner.nextBigDecimal();
        verificaQuantidade(quantidade);
        verificaInstanciaQuantidade(tipoAlimento, quantidade);
        return quantidade;
    }

    private void verificaTipoAlimento(String tipoAlimento){
        if (tipoAlimento == null){
            throw new UnsupportedOperationException("Não é permitido inserir nome vazio");
        }
        if (!tipoAlimento.equals("VERDURA") && !tipoAlimento.equals("LEGUME") && !tipoAlimento.equals("GRAOS")  && !tipoAlimento.equals("OUTROS")){
            throw new IllegalArgumentException("Tipo de alimento inválido");
        }
    }

    private void verificaInstanciaQuantidade(TipoAlimento tipoAlimento, BigDecimal quantidade) {
        if (tipoAlimento == TipoAlimento.VERDURA && quantidade.scale() == 0) {
            throw new NumberFormatException("Para verdura, a quantidade deve ser informada com casas decimais");
        }
        if (tipoAlimento == TipoAlimento.GRAOS && quantidade.scale() == 0) {
            throw new NumberFormatException("Para grãos, a quantidade deve ser informada com casas decimais");
        }
        if ((tipoAlimento == TipoAlimento.LEGUME || tipoAlimento == TipoAlimento.OUTROS) && quantidade.scale() > 0) {
            throw new NumberFormatException("Para legume ou outros, a quantidade deve ser informada em unidades inteiras");
        }
    }

    private void verificaQuantidade(BigDecimal quantidade) {
        if (quantidade == null) {
            throw new UnsupportedOperationException("Não é permitido inserir valor vazio");
        }
        if (quantidade.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Não é permitido inserir valores negativos para quantidades");
        }
    }
}
