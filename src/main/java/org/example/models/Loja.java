package org.example.models;

import org.example.exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> produtoList;

    public Loja() {
        produtoList = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtoList.add(produto);
    }

    public void exibirProduto(int codigo) throws ProdutoNaoEncontradoException {
        var index = produtoList.indexOf(new Produto(codigo));
        if (index != -1) System.out.println(produtoList.get(index));
        throw new ProdutoNaoEncontradoException();
    }

    public void gerarRelatorio() {
        produtoList.forEach(System.out::println);
    }
}
