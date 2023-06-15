package org.example.models;

import java.util.Scanner;

public class ProdutoFisico extends Produto {
    private String peso;
    private String dimensoes;

    public ProdutoFisico(int codigo, String nome, String descricao, double preco, int quantidade, String peso, String dimensoes) {
        super(codigo, nome, descricao, preco, quantidade);
        this.peso = peso;
        this.dimensoes = dimensoes;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    @Override
    public String toString() {
        return String.format("%s | %-4s | %-9s",
                super.toString(), this.getPeso(), this.getDimensoes());
    }

    @Override
    public void editar(Scanner scanner) {
        super.editar(scanner);
        System.out.println("Digite o peso do produto: ");
        this.setPeso(scanner.nextLine());
        System.out.println("Digite as dimensões do produto: ");
        this.setDimensoes(scanner.nextLine());
    }
}


