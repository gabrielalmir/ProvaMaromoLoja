package org.example.views;

import org.example.models.Loja;
import org.example.models.ProdutoDigital;
import org.example.models.ProdutoFisico;

import java.util.Scanner;

public class GerenciadorEstoque {
    private final Scanner scanner = new Scanner(System.in);
    private final Loja loja;

    public GerenciadorEstoque(Loja loja) {
        this.loja = loja;
    }

    public void run() {
        var opcao = "0";

        do {
            BaseView.titleScreen("Gerenciador de estoque");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Listar produtos");
            System.out.println("4. Exibir produto");
            System.out.println("5. Editar produto");
            System.out.println("6. Voltar ao menu principal");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> this.cadastrarProduto();
                case "2" -> this.removerProduto();
                case "3" -> this.listarProdutos();
                case "4" -> this.exibirProduto();
                case "5" -> this.editarProduto();
                case "6" -> {
                    System.out.println("Voltando ao menu principal...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }

            BaseView.pressEnterToContinue(scanner);
        } while (true);
    }

    private void editarProduto() {
        BaseView.titleScreen("Editar produto");

        loja.gerarRelatorio();

        System.out.print("Digite o Código do produto que deseja editar: ");
        var codigo = Integer.parseInt(scanner.nextLine());

        try {
            loja.editarProduto(scanner, codigo);
            System.out.println("Produto editado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao editar produto: " + e.getMessage());
        }
    }

    private void listarProdutos() {
        BaseView.titleScreen("Listagem de produtos");
        loja.gerarRelatorio();
    }

    private void exibirProduto() {
        BaseView.titleScreen("Exibir produto");

        System.out.print("Digite o ID do produto que deseja exibir: ");
        var id = Integer.parseInt(scanner.nextLine());

        loja.exibirProduto(id);
    }

    private void removerProduto() {
        BaseView.titleScreen("Remover produto");

        loja.gerarRelatorio();

        System.out.print("Digite o ID do produto que deseja remover: ");
        var id = Integer.parseInt(scanner.nextLine());

        loja.removerProduto(id);
    }

    private void cadastrarProduto() {
        BaseView.titleScreen("Cadastro de produto");

        var nome = "";
        var descricao = "";
        var preco = 0.0;
        var quantidade = 0;

        try {
            System.out.print("Digite o nome do produto: ");
            nome = scanner.nextLine();

            System.out.print("Descrição do produto: ");
            descricao = scanner.nextLine();

            System.out.print("Digite o preço do produto: ");
            preco = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite a quantidade do produto: ");
            quantidade = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto!");
            System.out.println("Verifique se os dados foram digitados corretamente.");
            return;
        }

        var opcao = 0;
        do {
            System.out.println("Tipo do produto: ");
            System.out.println("1. Produto Físico");
            System.out.println("2. Produto Digital");
            System.out.print("Digite a opção desejada: ");
            opcao = Integer.parseInt(scanner.nextLine());
        } while (opcao != 1 && opcao != 2);

        switch (opcao) {
            case 1 -> this.cadastrarProdutoFisico(nome, descricao, preco, quantidade);
            case 2 -> this.cadastrarProdutoDigital(nome, descricao, preco, quantidade);
            default -> System.out.println("Opção inválida!");
        }

        System.out.println("Produto cadastrado com sucesso!");
    }

    private void cadastrarProdutoDigital(String nome, String descricao, double preco, int quantidade) {
        System.out.print("Digite o formato do arquivo: ");
        var formato = scanner.nextLine();

        System.out.print("Digite o tamanho do arquivo: ");
        var tamanho = scanner.nextLine();

        var produto = new ProdutoDigital(
                loja.getProdutoList().size() + 1, nome, descricao, preco, quantidade, formato, tamanho);

        loja.adicionarProduto(produto);
    }

    private void cadastrarProdutoFisico(String nome, String descricao, double preco, int quantidade) {
        System.out.print("Digite o peso do produto: ");
        var peso = scanner.nextLine();

        System.out.print("Digite as dimensões do produto: ");
        var dimensoes = scanner.nextLine();

        var produto = new ProdutoFisico(
                loja.getProdutoList().size() + 1, nome, descricao, preco, quantidade, peso, dimensoes);

        loja.adicionarProduto(produto);
    }
}
