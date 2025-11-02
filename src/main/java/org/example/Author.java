package org.example;


public class Author {
    private String name;
    private String articles;
    private String coAuthors;
    private int totalCitations;

    public Author(String name, String articles, String coAuthors, int totalCitations) {
        this.name = name;
        this.articles = articles;
        this.coAuthors = coAuthors;
        this.totalCitations = totalCitations;
    }

    public String getName() { return name; }
    public String getArticles() { return articles; }
    public String getCoAuthors() { return coAuthors; }
    public int getTotalCitations() { return totalCitations; }
}
