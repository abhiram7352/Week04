package day01_java.com_java_generics;
import java.util.ArrayList;
import java.util.List;

// Abstract Class for Product
abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getProductDetails();
}

// Book Category Enum
enum BookCategory {
    FICTION, NON_FICTION, SCIENCE, HISTORY
}

// Clothing Category Enum
enum ClothingCategory {
    MENS, WOMENS, KIDS
}

// Gadget Category Enum
 enum GadgetCategory {
    SMARTPHONES, LAPTOPS, ACCESSORIES
}

// Book Class
 class Book extends Product {
    private BookCategory category;

    public Book(String name, double price, BookCategory category) {
        super(name, price);
        this.category = category;
    }

    @Override
    public String getProductDetails() {
        return "Book: " + getName() + ", Category: " + category + ", Price: $" + getPrice();
    }
}

// Clothing Class
class Clothing extends Product {
    private ClothingCategory category;

    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price);
        this.category = category;
    }

    @Override
    public String getProductDetails() {
        return "Clothing: " + getName() + ", Category: " + category + ", Price: $" + getPrice();
    }
}

// Gadget Class
 class Gadget extends Product {
    private GadgetCategory category;

    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price);
        this.category = category;
    }

    @Override
    public String getProductDetails() {
        return "Gadget: " + getName() + ", Category: " + category + ", Price: $" + getPrice();
    }
}

// Generic Product Catalog Class

class ProductCatalog<T extends Product> {
    private List<T> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }

    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }
}

// Main Class to Demonstrate Functionality
public class MarketplaceMain {
    public static void main(String[] args) {
        // Create product catalogs
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        // Add products
        bookCatalog.addProduct(new Book("The Great Gatsby", 15.00, BookCategory.FICTION));
        clothingCatalog.addProduct(new Clothing("T-Shirt", 20.00, ClothingCategory.MENS));
        gadgetCatalog.addProduct(new Gadget("Smartphone", 500.00, GadgetCategory.SMARTPHONES));

        // Apply discounts
        ProductCatalog.applyDiscount(bookCatalog.getProducts().get(0), 10);
        ProductCatalog.applyDiscount(clothingCatalog.getProducts().get(0), 15);
        ProductCatalog.applyDiscount(gadgetCatalog.getProducts().get(0), 20);

        // Display products
        System.out.println("Books:");
        for (Book book : bookCatalog.getProducts()) {
            System.out.println(book.getProductDetails());
        }

        System.out.println("\nClothing:");
        for (Clothing clothing : clothingCatalog.getProducts()) {
            System.out.println(clothing.getProductDetails());
        }

        System.out.println("\nGadgets:");
        for (Gadget gadget : gadgetCatalog.getProducts()) {
            System.out.println(gadget.getProductDetails());
        }
    }
}
