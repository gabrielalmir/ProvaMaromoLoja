package org.example.models;

import org.example.exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private final List<Produto> produtoList;

    public Loja() {
        produtoList = new ArrayList<>();
    }

    public Loja(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public void adicionarProduto(Produto produto) {
        produtoList.add(produto);
    }

    public Produto buscarProduto(int codigo) throws ProdutoNaoEncontradoException {
        var produto = new Produto(codigo);

        if (produtoList.contains(produto)) {
            var index = produtoList.indexOf(produto);
            return produtoList.get(index);
        }

        throw new ProdutoNaoEncontradoException();
    }

    public void removerProduto(int codigo)  {
        try {
            var produto = buscarProduto(codigo);
            if (produto != null) produtoList.remove(produto);
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void exibirProduto(int codigo) {
        try {
            var produto = buscarProduto(codigo);
            if (produto != null) System.out.println(produto);
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void gerarRelatorio() {
        this.exibirProdutos(produtoList);
    }

    public void exibirProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        var produtosDigitais = produtos.stream().filter(p -> p instanceof ProdutoDigital);
        var produtosFisicos = produtos.stream().filter(p -> p instanceof ProdutoFisico);

        System.out.printf("%-6s | %-20s | %-40s | %-5s | %-10s | %-7s | %-7s\n", "Código", "Nome", "Descrição", "Preço", "Quantidade", "Formato", "Tamanho");
        produtosDigitais.forEach(System.out::println);

        System.out.println("=".repeat(120));
        System.out.printf("%-6s | %-20s | %-40s | %-5s | %-10s | %-4s | %-9s\n", "Código", "Nome", "Descrição", "Preço", "Quantidade", "Peso", "Dimensões");
        produtosFisicos.forEach(System.out::println);
    }

    public List<Produto> buscarProdutos(String nome) {
        return produtoList.stream().filter(produto -> produto.getNome().contains(nome)).toList();
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }
}
