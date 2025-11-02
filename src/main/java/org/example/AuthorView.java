package org.example;

public class AuthorView {
    public void displayAuthor(Author author) {
        System.out.println("=== Google Scholar Author Information ===");
        System.out.println("Name: " + author.getName());
        System.out.println("Articles: " + author.getArticles());
        System.out.println("Co-Authors: " + author.getCoAuthors());
        System.out.println("Total Citations: " + author.getTotalCitations());
        System.out.println("=========================================");
    }

    public void displayError(String message) {
        System.out.println("❌ Error: " + message);
    }

    public void displaySuccess(String authorName) {
        System.out.println("✅ Articles successfully saved for: " + authorName);
    }
}
