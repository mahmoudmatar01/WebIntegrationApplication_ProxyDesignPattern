package org.design_patterns;

import java.util.HashMap;
import java.util.Map;

import static org.design_patterns.DummyThirdPartyWebService.PRODUCTS_ENDPOINT;
import static org.design_patterns.DummyThirdPartyWebService.RECIPES_ENDPOINT;


public class DummyJsonCachingProxy implements DummyJsonApi{

    private final Map<String,String> cacheLayer;
    private final DummyJsonApi dummyJsonApi;

    public DummyJsonCachingProxy() {
        cacheLayer = new HashMap<>();
        this.dummyJsonApi = new DummyThirdPartyWebService();
    }

    @Override
    public String getAllProducts() {
        if(cacheLayer.containsKey(PRODUCTS_ENDPOINT))
        {
            System.out.println("Fetching data from cache");
            return cacheLayer.get(PRODUCTS_ENDPOINT);
        }

        String productResponse = dummyJsonApi.getAllProducts();
        cacheLayer.put(PRODUCTS_ENDPOINT,productResponse);
        return productResponse;
    }

    @Override
    public String getAllRecipes() {
        if(cacheLayer.containsKey(RECIPES_ENDPOINT)){
            System.out.println("Fetching data from cache");
            return cacheLayer.get(RECIPES_ENDPOINT);
        }
        String recipesResponse = dummyJsonApi.getAllRecipes();
        cacheLayer.put(RECIPES_ENDPOINT,recipesResponse);
        return recipesResponse;
    }

}
