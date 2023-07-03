package org.example.exercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComprasController comprasController = new ComprasController();
        Scanner scanner = new Scanner(System.in);
        List<Alimento> listaCompras = new ArrayList<>();
        boolean adicionarOutroAlimento = true;
        comprasController.imprimirMenu();
        while (adicionarOutroAlimento) {
            try {
                Alimento alimento = comprasController.comprarAlimento();
                listaCompras.add(alimento);
                System.out.println("Alimento adicionado à lista de compras.");

            } catch (NumberFormatException e){
                System.out.println("Erro: " + e.getMessage());
            } catch (UnsupportedOperationException e){
                System.out.println("Erro: " + e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println("Erro: " + e.getMessage());
            } finally {
                System.out.print("Deseja adicionar outro alimento à lista? (s/n): ");
                String resposta = scanner.next();

                if (!resposta.equalsIgnoreCase("s")) {
                    adicionarOutroAlimento = false;
                }
            }
        }

        System.out.println("Lista de compras:");
        for (Alimento alimento : listaCompras) {
            System.out.println(alimento);
        }

    }
}
