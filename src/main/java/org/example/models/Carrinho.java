package org.example.models;

import org.example.exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private final List<Produto> produtoList;

    public Carrinho() {
        produtoList = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtoList.add(produto);
    }

    public void removerProduto(Produto produto) throws ProdutoNaoEncontradoException {
        if (produtoList.contains(produto)) produtoList.remove(produto);
        else throw new ProdutoNaoEncontradoException();
    }

    public double calcularValorTotalCompra() {
        return produtoList.stream().mapToDouble(Produto::getPreco).sum();
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }
}
