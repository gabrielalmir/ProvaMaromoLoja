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

    private Produto buscarProduto(int codigo) {
        var produto = new Produto(codigo);

        if (produtoList.contains(produto)) {
            var index = produtoList.indexOf(produto);
            return produtoList.get(index);
        }

        System.out.println("Produto não encontrado!");
        return null;
    }

    public void removerProduto(int codigo)  {
        var produto = buscarProduto(codigo);
        if (produto != null) produtoList.remove(produto);
    }

    public void exibirProduto(int codigo) {
        var produto = buscarProduto(codigo);
        if (produto != null) System.out.println(produto);
    }

    public void gerarRelatorio() {
        if (produtoList.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        produtoList.forEach(System.out::println);
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }
}
