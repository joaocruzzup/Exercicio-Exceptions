package org.example.exercicio01;

import java.math.BigDecimal;
import java.util.Scanner;

public class ComprasController {

    public Alimento comprarAlimento(){
        TipoAlimento tipoAlimento = entradaAlimento();
        BigDecimal quantidade =  entradaQuantidade(tipoAlimento);
        return new Alimento(tipoAlimento, quantidade);
    }

    public TipoAlimento entradaAlimento (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tipo de Alimento que você quer exatamente como está no menu");
        System.out.print("Digite aqui: ");
        String tipoDigitado = sc.nextLine().toUpperCase();
        verificaTipoAlimento(tipoDigitado);
        return TipoAlimento.valueOf(tipoDigitado.toUpperCase());
    }

    public BigDecimal entradaQuantidade(TipoAlimento tipoAlimento){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade que deseja comprar: ");
        BigDecimal quantidade = null;

        if (tipoAlimento.equals(TipoAlimento.VERDURA) || tipoAlimento.equals(TipoAlimento.GRAOS)) {
            quantidade = sc.nextBigDecimal();
            verificaQuantidade(quantidade);
            verificaInstanciaQuantidade(tipoAlimento, quantidade);
            return quantidade;
        } else if (tipoAlimento.equals(TipoAlimento.LEGUME) || tipoAlimento.equals(TipoAlimento.OUTROS)) {
            quantidade = sc.nextBigDecimal();
            verificaQuantidade(quantidade);
            verificaInstanciaQuantidade(tipoAlimento, quantidade);
            return quantidade;
        }
        return quantidade;
    }



    public void verificaTipoAlimento(String tipoAlimento){
        if (tipoAlimento == null){
            throw new UnsupportedOperationException("Não é permitido inserir nome vazio");
        }
        if (!tipoAlimento.equals("VERDURA") && !tipoAlimento.equals("LEGUME") && !tipoAlimento.equals("GRAOS")  && !tipoAlimento.equals("OUTROS")){
            throw new IllegalArgumentException("Tipo de alimento inválido");
        }
    }

    public void verificaInstanciaQuantidade(TipoAlimento tipoAlimento, BigDecimal quantidade){
        if (tipoAlimento.equals(TipoAlimento.VERDURA) && quantidade.scale() == 0){
            throw new NumberFormatException("Para verdura, a quantidade deve ser informada com casas decimais");
        }
        if (tipoAlimento.equals(TipoAlimento.GRAOS) && quantidade.scale() == 0){
            throw new NumberFormatException("Para grãos, a quantidade deve ser informada com casas decimais");
        }
        if (tipoAlimento.equals(TipoAlimento.LEGUME) && quantidade.scale() > 0){
            throw new NumberFormatException("Para legume, a quantidade deve ser informada em unidades inteiras");
        }
        if (tipoAlimento.equals(TipoAlimento.OUTROS) && quantidade.scale() > 0){
            throw new NumberFormatException("Para outros, a quantidade deve ser informada em unidades inteiras");
        }
    }

    public void verificaQuantidade(BigDecimal  quantidade){
        if (quantidade == null){
            throw new UnsupportedOperationException("Não é permitido inserir valor vazio");
        }
        if (quantidade.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Não é permitido inserir valores negativos para quantidades");
        }
    }



}
