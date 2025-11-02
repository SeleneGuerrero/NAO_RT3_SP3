package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleDAO {

    public void insertArticle(Article article, String researcherName) {
        String sql = "INSERT INTO articles (title, authors, publication_date, abstract, link, keywords, cited_by, researcher_name) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, article.getTitle());
            pstmt.setString(2, article.getAuthors());
            pstmt.setString(3, article.getPublicationDate());
            pstmt.setString(4, article.getSummary());
            pstmt.setString(5, article.getLink());
            pstmt.setString(6, article.getKeywords());
            pstmt.setInt(7, article.getCitedBy());
            pstmt.setString(8, researcherName);

            pstmt.executeUpdate();
            System.out.println("✅ Article saved: " + article.getTitle());

        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
    }
}
