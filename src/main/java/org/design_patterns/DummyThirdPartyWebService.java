package org.design_patterns;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DummyThirdPartyWebService implements DummyJsonApi{

    public static final String PRODUCTS_ENDPOINT="https://dummyjson.com/products";
    public static final String RECIPES_ENDPOINT="https://dummyjson.com/recipes";

    @Override
    public String getAllProducts() {
        return requestAPI(PRODUCTS_ENDPOINT);
    }

    @Override
    public String getAllRecipes() {
        return requestAPI(RECIPES_ENDPOINT);
    }

    private String requestAPI(String apiUrl){
        try{
            System.out.println("Fetching Products .......");
            Thread.sleep(2000);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(apiUrl))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newBuilder().build();
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
        } catch (InterruptedException | IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
