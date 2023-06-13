package org.example;

import org.example.views.CarrinhoDeCompras;
import org.example.views.GerenciadorEstoque;

import java.util.Scanner;

//A loja deseja aprimorar seu sistema atual e expandir suas funcionalidades. O objetivo é criar
//um sistema capaz de cadastrar produtos, exibir informações sobre os produtos, controlar o
//estoque e processar pedidos dos clientes. Serão utilizados recursos avançados de orientação
//a objetos, como herança, sobrescrita de métodos, tratamento de exceções e coleções.


public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var main = new Main();
        main.run();
    }

    public void run() {
        var opcao = 0;

        do {
            System.out.println("========================");
            System.out.println("\tLoja do Maromo\t");
            System.out.println("========================");
            System.out.println("1. Gerenciar Estoque");
            System.out.println("2. Carrinho de compras");
            System.out.println("3. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> {
                    var gerenciadorEstoque = new GerenciadorEstoque();
                    gerenciadorEstoque.run();
                }
                case 2 -> {
                    var carrinhoDeCompras = new CarrinhoDeCompras();
                    carrinhoDeCompras.run();
                }
                case 3 -> this.quit();
                default -> {
                    System.out.println("Opção inválida!");
                    System.out.println("Pressione ENTER para continuar...");
                    scanner.nextLine();
                }
            }
        } while (opcao != 3);
    }

    private void quit() {
        System.out.println("Obrigado por utilizar o sistema!");
        System.out.println("Tudo culpa do Maromo! 😊");
        System.exit(0);
    }
}