package org.example.models;

import org.example.exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtoList;

    public Carrinho() {
        produtoList = new ArrayList<Produto>();
    }

    public void adicionarProduto(Produto produto) {
        produtoList.add(produto);
    }

    public boolean removerProduto(Produto produto) throws ProdutoNaoEncontradoException {
        if (produtoList.remove(produto)) return true;
        else throw new ProdutoNaoEncontradoException();
    }

    public double calcularValorTotalCompra() {
        return produtoList.stream().mapToDouble(Produto::getPreco).sum();
    }
}
