package org.example.models;

public class ProdutoDigital extends Produto {

    private String formato;
    private String tamanhoArquivo;

    public ProdutoDigital(int codigo, String nome, String descricao, double preco, int quantidade) {
        super(codigo, nome, descricao, preco, quantidade);
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
        return super.toString() + "\n" +
                "formato: " + formato + "\n" +
                "tamanhoArquivo: " + tamanhoArquivo;
    }
}
