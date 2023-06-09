package org.example.models;

public class ProdutoDigital extends Produto{

    private String formato;
    private int tamImagem;

    public ProdutoDigital(int codigo, String nome, String descricao, double preco, int quantidade) {
        super(codigo, nome, descricao, preco, quantidade);
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getTamImagem() {
        return tamImagem;
    }

    public void setTamImagem(int tamImagem) {
        this.tamImagem = tamImagem;
    }
    public void lisProdutoDigital(){
        System.out.println("codigo "+ this.getCodigo());
        System.out.println("Nome " + this.getNome());
        System.out.println("descição" + this.getDescricao());
        System.out.println("Preco "+ this.getPreco());
        System.out.println("Quantidade " + this.getQuantidade());
        System.out.println("Formato" + this.getFormato());
        System.out.println("Tamanho "+ this.getTamImagem());

    }
}
