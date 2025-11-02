package org.example;

public class Main {
    public static void main(String[] args) {
        AuthorView view = new AuthorView();
        AuthorController controller = new AuthorController(view);

        // Ejemplo: dos investigadores
        controller.getAuthorData("LSsXyncAAAAJ"); // Autor 1
        controller.getAuthorData("7dR99s0AAAAJ"); // Autor 2
    }
}
