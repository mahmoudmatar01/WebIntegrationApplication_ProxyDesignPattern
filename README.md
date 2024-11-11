# WebIntegrationApplication_ProxyDesignPattern

This project demonstrates the **Proxy Design Pattern** by implementing a caching proxy for a web integration application. The application uses a dummy web service (`DummyThirdPartyWebService`) to fetch product and recipe data from a third-party API. The caching proxy (`DummyJsonCachingProxy`) caches API responses to minimize network requests and improve performance.

## Project Structure

The project includes the following classes and interfaces:

1. **DummyJsonApi (Interface)**: Defines the contract for fetching data from external endpoints with two methods:
   - `getAllProducts()`: Fetches a list of products.
   - `getAllRecipes()`: Fetches a list of recipes.

2. **DummyThirdPartyWebService (Real Subject)**:
   - Implements the `DummyJsonApi` interface to connect to the external API endpoints (`PRODUCTS_ENDPOINT` and `RECIPES_ENDPOINT`) and retrieve data.
   - The `requestAPI()` method simulates network latency (2 seconds) for each request to mimic a real-world API call.

3. **DummyJsonCachingProxy (Proxy)**:
   - Implements the `DummyJsonApi` interface and wraps an instance of `DummyThirdPartyWebService`.
   - Maintains a `cacheLayer` to store responses from previous API requests, reducing redundant network calls.
   - Checks if data is cached before making an API call. If data is found in the cache, it returns the cached response; otherwise, it fetches from the web service and stores the result in the cache.

4. **Main (Driver Class)**:
   - Creates an instance of `DummyJsonCachingProxy` and demonstrates its usage by fetching products and recipes multiple times.
   - Outputs show that the first request fetches data from the web service (incurring a delay), while subsequent requests retrieve data from the cache.

## How It Works

1. **Proxy Design Pattern**:
   - The `DummyJsonCachingProxy` acts as a **Proxy** for `DummyThirdPartyWebService`.
   - The proxy intercepts calls to the web service and checks the cache before making any network requests, reducing latency and conserving network resources.

2. **Caching Strategy**:
   - The proxy stores responses for each endpoint (`PRODUCTS_ENDPOINT` and `RECIPES_ENDPOINT`) in a `cacheLayer` (`HashMap`) after the first network call.
   - Subsequent calls to fetch data are served from the cache if available, enhancing performance by avoiding unnecessary network calls.

## Sample Output

When you run the `Main` class, you should see output similar to:

```plaintext
Calling No.1
Fetching Products .......
Fetching Recipes .......
<Products API Response>
<Recipes API Response>

Calling No.2
Fetching data from cache
Fetching data from cache
<Products API Response>
<Recipes API Response>

Calling No.3
Fetching data from cache
Fetching data from cache
<Products API Response>
<Recipes API Response>
```

## Key Takeaways
- Proxy Design Pattern: The proxy acts as a middle layer, adding caching functionality without modifying the original web service.
- Caching Benefits: The `DummyJsonCachingProxy `improves application performance by reducing the time and cost associated with repeated network requests.
- Flexible Design: By implementing a proxy, additional behaviors (e.g., logging or authorization) can be added without changing the original service implementation.


## Usage
1. Clone the repository and navigate to the project directory.
2. Compile the project files.
3. Run the `Main` class to observe the caching functionality provided by the proxy.
