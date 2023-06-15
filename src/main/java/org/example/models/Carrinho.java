package org.example.models;

import org.example.exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Carrinho {
    private final List<Map<Produto, Integer>> carrinho;

    public Carrinho() {
        carrinho = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        carrinho.add(Map.of(produto, quantidade));
    }

    public void removerProduto(Produto produto) throws ProdutoNaoEncontradoException {
        if (carrinho.stream().map(Map::keySet).anyMatch(map -> map.contains(produto)))
            carrinho.removeIf(map -> map.containsKey(produto));
        else throw new ProdutoNaoEncontradoException();
    }

    public double calcularValorTotalCompra() {
        // Map(Produto -> Quantidade)
        var valorTotal = 0.0;

        for (var map : carrinho) {
            for (var p : map.keySet()) {
                valorTotal += p.getPreco() * map.get(p);
            }
        }

        return valorTotal;
    }

    public List<Map<Produto, Integer>> getCarrinho() {
        return carrinho;
    }

    public int getQuantidadeProduto(Produto produto) {
        var quantidade = 0;

        for (var map : carrinho) {
            for (var p : map.keySet()) {
                if (p.equals(produto)) quantidade += map.get(p);
            }
        }

        return quantidade;
    }
}
