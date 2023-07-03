package org.example.exercicio02;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoedaController {
    private Moeda[] listaMoedas = new Moeda[]{new DolarAmericano(), new DolarCanadense(), new Euro(), new LibraEsterlina()};

    public void imprimirMenu(){
        System.out.println("Moedas disponíveis para conversão");
        System.out.println("1. Dólar americano");
        System.out.println("2. Dólar canadense");
        System.out.println("3. Euro");
        System.out.println("4. Libra Esterlina");
    }

    public int entradaMoeda(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a moeda escolhida: ");
        return sc.nextInt() - 1;
    }

    public void validarEntradaMoeda(int indice){
        if (indice < 0 || indice > 4){
            throw new IllegalArgumentException("Tipo de moeda selecionado inválido");
        }
    }

    public BigDecimal entradaValorConverter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Só é possível converter o valor para Real (R$)");
        System.out.print("Digite o valor a converter: ");
        String valorDigitado = sc.next();
        BigDecimal valor = new BigDecimal(valorDigitado);
        validarEntradaValor(valor);
        return valor;
    }

    public void validarEntradaValor(BigDecimal valor){
        if (valor == null){
            throw new NumberFormatException("Para moeda, o valor monetário deve ser um número decimal");
        }
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Valor inválido, por favor, tente novamente");
        }
    }

    public void converter(int indice, BigDecimal valor){
        Moeda moedaEscolhida = listaMoedas[indice];
        BigDecimal valorConvertido = listaMoedas[indice].converter(valor);
        System.out.println(moedaEscolhida.obterNome() + " na cotação de hoje " + LocalDate.now() + " está em " + moedaEscolhida.obterCotacao() +
                "\n O valor que pediu pra converter de " + valor + " em reais é R$" + valorConvertido);
    }
}
