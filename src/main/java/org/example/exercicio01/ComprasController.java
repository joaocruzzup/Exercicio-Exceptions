package org.example.exercicio01;

import java.util.Scanner;

public class ComprasController {

    public Alimento comprarAlimento(){
        TipoAlimento tipoAlimento = entradaAlimento();
        Number quantidade =  entradaQuantidade(tipoAlimento);

        return new Alimento(tipoAlimento, quantidade);
    }

    public TipoAlimento entradaAlimento (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tipo de Alimento: ");
        String tipoDigitado = sc.nextLine();
        TipoAlimento tipoAlimento = TipoAlimento.valueOf(tipoDigitado.toUpperCase());
        verificaTipoAlimento(tipoAlimento);
        return tipoAlimento;
    }

    public Number entradaQuantidade(TipoAlimento tipoAlimento){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade que deseja comprar: ");
        Number quantidade = null;

        if (tipoAlimento.equals(TipoAlimento.VERDURA) || tipoAlimento.equals(TipoAlimento.GRAOS)) {
            quantidade = sc.nextDouble();
        } else if (tipoAlimento.equals(TipoAlimento.LEGUME) || tipoAlimento.equals(TipoAlimento.OUTROS)) {
            quantidade = sc.nextInt();
        }
        verificaQuantidade(quantidade);
        verificaInstanciaQuantidade(tipoAlimento, quantidade);
        return quantidade;
    }



    public void verificaTipoAlimento(TipoAlimento tipoAlimento){
        if (tipoAlimento == null){
            throw new UnsupportedOperationException("Não é permitido inserir nome vazio");
        }
        if (tipoAlimento != TipoAlimento.VERDURA && tipoAlimento != TipoAlimento.GRAOS && tipoAlimento != TipoAlimento.LEGUME  && tipoAlimento != TipoAlimento.OUTROS){
            throw new IllegalArgumentException("Tipo de alimento inválido");
        }
    }

    public void verificaInstanciaQuantidade(TipoAlimento tipoAlimento, Number quantidade){
        if (tipoAlimento.equals(TipoAlimento.VERDURA) && quantidade instanceof Integer){
                throw new NumberFormatException("Para verdura, a quantidade deve ser informada com ponto");
        }
        if (tipoAlimento.equals(TipoAlimento.GRAOS) && quantidade instanceof Integer){
                throw new NumberFormatException("Para verdura, a quantidade deve ser informada com ponto");
        }
        if (tipoAlimento.equals(TipoAlimento.LEGUME) && quantidade instanceof Double){
            throw new NumberFormatException("Para Legume, a quantidade deve ser informada em unidades inteiras");
        }
        if (tipoAlimento.equals(TipoAlimento.OUTROS) && quantidade instanceof Double){
            throw new NumberFormatException("Para Outros, a quantidade deve ser informada em unidades inteiras");
        }
    }

    public void verificaQuantidade(Number quantidade){
        if (quantidade == null){
            throw new UnsupportedOperationException("Não é permitido inserir valor vazio");
        }
        if (quantidade.doubleValue() < 0){
            throw new IllegalArgumentException("Não é permitido inserir valores negativos para quantidades");
        }
    }

}
