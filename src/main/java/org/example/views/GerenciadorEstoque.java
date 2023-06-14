package org.example.views;

import java.util.Scanner;

public class GerenciadorEstoque {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("====================================");
        System.out.println("\tGerenciador de estoque\t");
        System.out.println("====================================");

        var opcao = 0;

        do {
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Listar produtos");
            System.out.println("4. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> this.cadastrarProduto();
                case 2 -> this.removerProduto();
                case 3 -> this.listarProdutos();
                case 4 -> System.out.println("Voltando...");
                default -> {
                    System.out.println("Opção inválida!");
                    System.out.println("Pressione ENTER para continuar...");
                    scanner.nextLine();
                }
            }
        } while (opcao != 3);

        scanner.nextLine();
    }

    private void listarProdutos() {
    }

    private void removerProduto() {
    }

    private void cadastrarProduto() {
    }
}
