import java.util.*;

public class SearchEngine {

    private final List<Product> products = new ArrayList<>();
    private final Map<Integer, Product> productMap = new HashMap<>();

    private final CompressedTrie trie = new CompressedTrie();
    private final FusionTreeIndex priceIndex = new FusionTreeIndex();


    public void addProduct(Product product) {
        if (product == null) return;

        products.add(product);
        productMap.put(product.getId(), product);
        trie.insert(product.getName(), product.getId());
        priceIndex.insert(product.getPrice(), product.getId());
    }


    public List<Product> search(
            String keyword,
            String brand,
            String category,
            double minPrice,
            double maxPrice,
            double minRating) {

        List<Product> result = new ArrayList<>();
        Iterable<Product> candidates;


        if (keyword != null && !keyword.trim().isEmpty()) {
            List<Integer> productIds = trie.searchPrefix(keyword.toLowerCase());
            List<Product> matchedProducts = new ArrayList<>();
            for (Integer id : productIds) {
                Product p = productMap.get(id);
                if (p != null) matchedProducts.add(p);
            }
            candidates = matchedProducts;
        } else {

            candidates = products;
        }


        for (Product product : candidates) {


            if (brand != null && !brand.equalsIgnoreCase("all")
                    && !brand.equalsIgnoreCase(product.getBrand())) {
                continue;
            }


            if (category != null && !category.equalsIgnoreCase("all")
                    && !category.equalsIgnoreCase(product.getCategory())) {
                continue;
            }


            if (product.getPrice() < minPrice || product.getPrice() > maxPrice) {
                continue;
            }


            if (product.getRating() < minRating) {
                continue;
            }

            result.add(product);
        }

        return result;
    }


    public List<Product> topK(List<Product> list, int k) {
        if (list == null || list.isEmpty() || k <= 0) {
            return new ArrayList<>();
        }

        PriorityQueue<Product> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(Product::getRating)
        );

        for (Product product : list) {
            minHeap.offer(product);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }


        List<Product> topProducts = new ArrayList<>(minHeap);
        topProducts.sort((a, b) -> Double.compare(b.getRating(), a.getRating()));

        return topProducts;
    }


    public void updateStock(int productId, int newStock) {
        Product product = productMap.get(productId);

        if (product != null) {
            product.setStock(newStock);
            System.out.println("Stock updated successfully for Product ID: " + productId);
        } else {
            System.out.println("Product not found.");
        }
    }
}