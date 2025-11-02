package org.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class AuthorController {
    private AuthorView view;
    private ArticleDAO articleDAO = new ArticleDAO();
    private final String apiKey = "98b61970895ad46c19bfc175014bc2506515fd1271948cbcc353d49ab6ff8840"; // 🔑 reemplázala con tu API key de SerpApi

    public AuthorController(AuthorView view) {
        this.view = view;
    }

    public void getAuthorData(String authorId) {
        String url = "https://serpapi.com/search.json?engine=google_scholar_author&author_id="
                + authorId + "&api_key=" + apiKey;

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(jsonResponse);
                JSONObject authorObj = json.getJSONObject("author");
                String name = authorObj.getString("name");

                JSONArray articlesArray = json.optJSONArray("articles");
                if (articlesArray == null || articlesArray.length() == 0) {
                    view.displayError("No articles found for " + name);
                    return;
                }

                // Tomar solo los primeros 3 artículos
                for (int i = 0; i < Math.min(3, articlesArray.length()); i++) {
                    JSONObject articleJson = articlesArray.getJSONObject(i);

                    Article article = new Article(
                            articleJson.optString("title", "Unknown"),
                            articleJson.optString("authors", name),
                            articleJson.optString("publication", "Unknown"),
                            articleJson.optString("snippet", "No summary available"),
                            articleJson.optString("link", "No link"),
                            articleJson.optString("keywords", "N/A"),
                            articleJson.optInt("cited_by", 0)
                    );

                    // Guardar artículo en DB
                    articleDAO.insertArticle(article, name);
                }

                view.displaySuccess(name);

            } else {
                view.displayError("HTTP Error: " + response.getStatusLine().getStatusCode());
            }

        } catch (Exception e) {
            view.displayError("Exception: " + e.getMessage());
        }
    }
}
