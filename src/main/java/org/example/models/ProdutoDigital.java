package org.example.models;

import java.util.Scanner;

public class ProdutoDigital extends Produto {

    private String formato;
    private String tamanhoArquivo;

    public ProdutoDigital(int codigo, String nome, String descricao, double preco, int quantidade, String formato, String tamanhoArquivo) {
        super(codigo, nome, descricao, preco, quantidade);
        this.formato = formato;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(String tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public String toString() {
        return String.format("%s | %-7s | %-7s",
                super.toString(), this.getFormato(), this.getTamanhoArquivo());
    }

    @Override
    public void editar(Scanner scanner) {
        super.editar(scanner);
        System.out.println("Digite o formato do arquivo: ");
        this.setFormato(scanner.nextLine());
        System.out.println("Digite o tamanho do arquivo: ");
        this.setTamanhoArquivo(scanner.nextLine());
    }
}
