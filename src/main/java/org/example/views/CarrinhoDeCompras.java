package org.example.views;

import org.example.exceptions.ProdutoNaoEncontradoException;
import org.example.models.Carrinho;
import org.example.models.Loja;
import org.example.models.Produto;

import java.util.Scanner;

public class CarrinhoDeCompras {
    private final Scanner scanner = new Scanner(System.in);
    private final Loja loja;
    private final Carrinho carrinho;

    public CarrinhoDeCompras(Loja loja, Carrinho carrinho) {
        this.loja = loja;
        this.carrinho = carrinho;
    }

    public void run() {
        BaseView.titleScreen("Carrinho de compras");

        var opcao = "0";

        do {
            System.out.println("1. Adicionar produto ao carrinho");
            System.out.println("2. Remover produto do carrinho");
            System.out.println("3. Exibir carrinho");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> adicionarProduto();
                case "2" -> removerProduto();
                case "3" -> exibirCarrinho();
                case "4" -> finalizarCompra();
                case "5" -> {
                    System.out.println("Voltando ao menu principal...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }

            BaseView.pressEnterToContinue(scanner);
        } while (true);
    }

    private void adicionarProduto() {
        BaseView.titleScreen("Adicionar produto ao carrinho");

        loja.gerarRelatorio();

        System.out.print("Buscar produto (ou 'cancelar' para voltar): ");
        var nome = scanner.nextLine();

        if (nome.equalsIgnoreCase("cancelar")) {
            System.out.println("Operação cancelada.");
            return;
        }

        var produtosEncontrados = loja.buscarProdutos(nome);

        if (produtosEncontrados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com esse nome.");
            return;
        }

        System.out.println("\nProdutos encontrados:");
        for (int i = 0; i < produtosEncontrados.size(); i++) {
            System.out.println("(" + (i + 1) + "). " + produtosEncontrados.get(i));
        }

        System.out.print("Digite o número correspondente ao produto desejado (ou 'cancelar' para voltar): ");
        var opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("cancelar")) {
            System.out.println("Operação cancelada.");
            return;
        }

        try {
            int selecionado = Integer.parseInt(opcao);

            if (selecionado >= 1 && selecionado <= produtosEncontrados.size()) {
                Produto produto = produtosEncontrados.get(selecionado - 1);
                carrinho.adicionarProduto(produto);
                System.out.println("Produto adicionado ao carrinho!");
            } else {
                System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida!");
        }
    }

    private void removerProduto() {
        BaseView.titleScreen("Remover produto do carrinho");

        exibirCarrinho();

        System.out.print("Digite o código do produto que deseja remover (ou 'cancelar' para voltar): ");
        var opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("cancelar")) {
            System.out.println("Operação cancelada.");
            return;
        }

        try {
            int codigo = Integer.parseInt(opcao);

            carrinho.removerProduto(new Produto(codigo));

            throw new ProdutoNaoEncontradoException();
        } catch (NumberFormatException e) {
            System.out.println("Código inválido!");
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println("Produto não encontrado no carrinho!");
        }
    }

    private void finalizarCompra() {
        BaseView.titleScreen("Finalizar compra");

        if (carrinho.getProdutoList().isEmpty()) {
            System.out.println("O carrinho está vazio! Nenhuma compra foi realizada.");
        } else {
            double valorTotal = carrinho.calcularValorTotalCompra();
            System.out.printf("Valor total da compra: R$ %.2f%n", valorTotal);
            System.out.println("Compra finalizada com sucesso! 🥳");

            carrinho.getProdutoList().clear();
        }
    }

    public void exibirCarrinho() {
        BaseView.titleScreen("Carrinho de compras");
        loja.exibirProdutos(carrinho.getProdutoList());
    }
}
