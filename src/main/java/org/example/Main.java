package org.example;

import org.example.exceptions.ProdutoNaoEncontradoException;
import org.example.models.Carrinho;
import org.example.models.Loja;
import org.example.models.Produto;
import org.example.models.ProdutoFisico;
import org.example.views.CarrinhoDeCompras;
import org.example.views.GerenciadorEstoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//A loja deseja aprimorar seu sistema atual e expandir suas funcionalidades. O objetivo é criar
//um sistema capaz de cadastrar produtos, exibir informações sobre os produtos, controlar o
//estoque e processar pedidos dos clientes. Serão utilizados recursos avançados de orientação
//a objetos, como herança, sobrescrita de métodos, tratamento de exceções e coleções.


public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private Loja loja;
    private Carrinho carrinho;

    public static void main(String[] args) throws ProdutoNaoEncontradoException {
        var main = new Main();
        main.run();
    }

    public void run() {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new ProdutoFisico(1, "Mouse", "Mouse sem fio", 50.0, 10, "0.5kg", "10x10x10cm"));
        produtos.add(new ProdutoFisico(2, "Teclado", "Teclado sem fio", 100.0, 10, "1kg", "20x20x20cm"));

        loja = new Loja(produtos);
        carrinho = new Carrinho();

        var opcao = "0";

        do {
            System.out.println("========================");
            System.out.println("\tLoja do Maromo\t");
            System.out.println("========================");
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
                    var carrinhoDeCompras = new CarrinhoDeCompras(carrinho);
                    carrinhoDeCompras.run();
                }
                case "3" -> this.quit();
                default -> {
                    System.out.println("Opção inválida!");
                }
            }
        } while (!opcao.equals("3"));
    }

    private void quit() {
        System.out.println("Obrigado por utilizar o sistema!");
        System.out.println("Tudo culpa do Maromo! 😊");
        System.exit(0);
    }
}