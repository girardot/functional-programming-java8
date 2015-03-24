package fr.xebia.java8.refactoring.step5;

import fr.xebia.java8.refactoring.step5.repository.ProductRepository;
import fr.xebia.java8.refactoring.step5.repository.StockRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class MerchantService {

    private ExecutorService executor = Executors.newFixedThreadPool(4);

    private ProductRepository productRepository = ProductRepository.CURRENT;

    private StockRepository stockRepository = StockRepository.CURRENT;

    public Merchant retrieveMerchant() throws ExecutionException, InterruptedException {

        CompletableFuture<List<Product>> products = CompletableFuture.supplyAsync(productRepository::initProducts, executor);
        CompletableFuture<List<Stock>> stocks = CompletableFuture.supplyAsync(stockRepository::initStocks, executor);

        return products.thenCombine(stocks, Merchant::new).get();
    }

    public void buyProduct(Integer productId) throws ExecutionException, InterruptedException {
        CompletableFuture<Product> product = CompletableFuture.supplyAsync(() -> productRepository.findById(productId), executor);
        product.thenAcceptAsync(p -> stockRepository.decrementStock(p.getStockId()), executor);
    }

    public Map<Product.Category, List<Product>> retrieveProductByCategories() throws ExecutionException, InterruptedException {

        Map<Product.Category, List<Product>> productsByCategories = new ConcurrentHashMap<>();

        CompletableFuture.allOf(Stream
                .of(Product.Category.values())
                .map(c -> CompletableFuture.supplyAsync(() -> productRepository.productsByCategory(c), executor)
                        .thenAccept(p -> productsByCategories.put(c, p)))
                .toArray(CompletableFuture[]::new)).get();

        return productsByCategories;
    }

}
