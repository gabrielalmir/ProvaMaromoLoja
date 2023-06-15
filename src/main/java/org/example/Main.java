package org.example;

import org.example.models.*;
import org.example.views.BaseView;
import org.example.views.CarrinhoDeCompras;
import org.example.views.GerenciadorEstoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var main = new Main();
        main.run();
    }

    public void run() {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new ProdutoFisico(1, "Mouse", "Mouse sem fio", 50.0, 10, "0.5kg", "10x10x10cm"));
        produtos.add(new ProdutoFisico(2, "Teclado", "Teclado sem fio", 100.0, 10, "1kg", "20x20x20cm"));
        produtos.add(new ProdutoDigital(3, "Curso Java", "Curso de Java", 100.0, 10, "mp4", "10GB"));

        Loja loja = new Loja(produtos);
        Carrinho carrinho = new Carrinho();

        var opcao = "0";

        do {
            BaseView.titleScreen("Loja do Maromo");
            System.out.println("1. Gerenciar Estoque");
            System.out.println("2. Carrinho de compras");
            System.out.println("3. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> {
                    var gerenciadorEstoque = new GerenciadorEstoque(loja);
                    gerenciadorEstoque.run();
                }
                case "2" -> {
                    var carrinhoDeCompras = new CarrinhoDeCompras(loja, carrinho);
                    carrinhoDeCompras.run();
                }
                case "3" -> this.quit();
                default -> System.out.println("Opção inválida!");
            }

            BaseView.pressEnterToContinue(scanner);
        } while (!opcao.equals("3"));
    }

    private void quit() {
        BaseView.titleScreen("Obrigado por utilizar o sistema! Tudo culpa do Maromo! 😊");
        System.exit(0);
    }
}