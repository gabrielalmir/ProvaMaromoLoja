package org.example.views;

import org.example.models.Carrinho;

import java.util.Scanner;

public class CarrinhoDeCompras {
    private final Scanner scanner = new Scanner(System.in);
    private Carrinho carrinho;

    public CarrinhoDeCompras(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void run() {
        System.out.println("====================================");
        System.out.println("Carrinho de compras");
        System.out.println("====================================");
        scanner.nextLine();
    }
}
