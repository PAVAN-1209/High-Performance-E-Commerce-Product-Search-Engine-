public class Main {

    public static void main(String[] args) {

        SearchEngine engine = new SearchEngine();


        engine.addProduct(new Product(
                1,
                "Samsung Galaxy A55",
                "Samsung",
                "Electronics",
                32999,
                4.4,
                "5G smartphone with AMOLED display",
                12
        ));

        engine.addProduct(new Product(
                2,
                "Samsung Galaxy S25",
                "Samsung",
                "Electronics",
                74999,
                4.7,
                "Premium Samsung smartphone",
                8
        ));

        engine.addProduct(new Product(
                3,
                "Sony Wireless Headphones",
                "Sony",
                "Electronics",
                7999,
                4.5,
                "Wireless noise cancelling headphones",
                20
        ));

        engine.addProduct(new Product(
                4,
                "Nike Running Shoes",
                "Nike",
                "Footwear",
                4999,
                4.3,
                "Comfortable running shoes",
                15
        ));

        engine.addProduct(new Product(
                5,
                "Apple AirPods Pro",
                "Apple",
                "Electronics",
                24999,
                4.6,
                "Wireless earbuds",
                10
        ));



        System.out.println("===== SEARCH RESULTS =====");

        var results = engine.search(
                "Samsung",
                "all",
                "all",
                0,
                100000,
                0
        );


        for (Product product : results) {
            product.displayProduct();
        }



        System.out.println("\n===== TOP 2 PRODUCTS =====");

        var topProducts = engine.topK(results, 2);

        for (Product product : topProducts) {
            product.displayProduct();
        }



        System.out.println("\n===== STOCK UPDATE =====");

        engine.updateStock(1, 20);

        Product updated = engine.search(
                "Samsung",
                "all",
                "all",
                0,
                100000,
                0
        ).get(0);

        System.out.println(
                "Updated stock: " + updated.getStock()
        );
    }
}
