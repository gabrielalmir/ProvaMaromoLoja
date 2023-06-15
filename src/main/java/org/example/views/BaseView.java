package org.example.views;

import java.util.Scanner;

public class BaseView {
    public static void titleScreen(String title) {
        var totalCaracteres = 120;

        System.out.println("=".repeat(totalCaracteres));

        var espacosAntes = (totalCaracteres - title.length() - 1) / 2;
        var espacosDepois = totalCaracteres - title.length() - 1 - espacosAntes;

        String espacosAntesStr = " ".repeat(espacosAntes);
        String espacosDepoisStr = " ".repeat(espacosDepois);
        System.out.println('|' + espacosAntesStr + title + espacosDepoisStr + '|');

        System.out.println("=".repeat(totalCaracteres));
    }

    public static void pressEnterToContinue(Scanner scanner) {
        System.out.println("Pressione ENTER para continuar...");
        try {
            scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
