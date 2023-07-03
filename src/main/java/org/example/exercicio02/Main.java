package org.example.exercicio02;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MoedaController moedaController = new MoedaController();
        moedaController.imprimirMenu();
        boolean realizarOutraConversao = true;
        while (realizarOutraConversao) {
            try {
                int indiceMoeda = moedaController.entradaMoeda();
                moedaController.validarEntradaMoeda(indiceMoeda);

                BigDecimal valorConverter = moedaController.entradaValorConverter();

                moedaController.converter(indiceMoeda, valorConverter);
            } catch (NumberFormatException e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: " + e.getMessage());
            } finally {

                System.out.print("Deseja fazer outra conversão? (s/n): ");
                String resposta = sc.next();

                if (!resposta.equalsIgnoreCase("s")) {
                    realizarOutraConversao = false;
                }
            }
        }
    }
}
