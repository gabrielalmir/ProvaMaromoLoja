package org.example.models;

public class ProdutoFisico extends Produto {
    private String peso;
    private String dimensoes;
    public ProdutoFisico(int codigo, String nome, String descricao, double preco, int quantidade) {
        super(codigo, nome, descricao, preco, quantidade);
    }
}


