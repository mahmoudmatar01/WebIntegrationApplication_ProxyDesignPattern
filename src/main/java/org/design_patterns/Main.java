package org.design_patterns;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        DummyJsonApi cacheProxy = new DummyJsonCachingProxy();

        System.out.println("Calling No.1");
        String productsResponse = cacheProxy.getAllProducts();
        String recipesResponse = cacheProxy.getAllRecipes();
        System.out.println(productsResponse);
        System.out.println(recipesResponse);

        Thread.sleep(5000);

        System.out.println("Calling No.2");
        String expectedCachedProductsResponse = cacheProxy.getAllProducts();
        String expectedCachedRecipesResponse = cacheProxy.getAllRecipes();
        System.out.println(expectedCachedProductsResponse);
        System.out.println(expectedCachedRecipesResponse);

        System.out.println("Calling No.3");
        String expectedCachedProductsResponse2 = cacheProxy.getAllProducts();
        String expectedCachedRecipesResponse2 = cacheProxy.getAllRecipes();
        System.out.println(expectedCachedProductsResponse2);
        System.out.println(expectedCachedRecipesResponse2);
    }
}
