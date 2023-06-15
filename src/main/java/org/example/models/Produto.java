package org.example.models;

import java.util.Scanner;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(int codigo, String nome, String descricao, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;

        return codigo == produto.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public String toString() {
        return String.format("%-6s | %-20s | %-40s | %-5s | %-10s",
                codigo, nome, descricao, preco, quantidade);
    }

    public void editar(Scanner scanner) {
        System.out.println("Editar produto");

        System.out.println("Digite o novo nome do produto: ");
        this.setNome(scanner.nextLine());

        System.out.println("Digite a nova descrição do produto: ");
        this.setDescricao(scanner.nextLine());

        System.out.println("Digite o novo preço do produto: ");
        this.setPreco(Double.parseDouble(scanner.nextLine()));

        System.out.println("Digite a nova quantidade do produto: ");
        this.setQuantidade(Integer.parseInt(scanner.nextLine()));
    }
}
