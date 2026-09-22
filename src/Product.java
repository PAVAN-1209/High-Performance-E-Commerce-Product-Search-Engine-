public class Product {

    private int id;
    private String name;
    private String brand;
    private String category;
    private double price;
    private double rating;
    private String description;
    private int stock;

    // Constructor name must match the class name exactly and have no return type
    public Product(int id, String name, String brand, String category,
                   double price, double rating, String description, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public void displayProduct() {
        System.out.println("----------------------------");
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Category: " + category);
        System.out.println("Price: ₹" + price);
        System.out.println("Rating: " + rating);
        System.out.println("Stock: " + stock);
        System.out.println("Description: " + description);
    }
}