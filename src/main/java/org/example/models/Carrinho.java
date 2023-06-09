package org.example.models;

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

    public void removerProduto(Produto produto) {
        produtoList.remove(produto);
    }

    public double getValorTotal() {
        double valorTotal = 0;
        for (Produto produto : produtoList) valorTotal += produto.getPreco();
        return valorTotal;
    }
}
