package day01_java.com_java_generics;
import java.util.ArrayList;
import java.util.List;
// Abstract Class WarehouseItem
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getItemDetails();
}

// Electronics Class
 class Electronics extends WarehouseItem {
    private String brand;
    private int warrantyInMonths;

    public Electronics(String name, double price, String brand, int warrantyInMonths) {
        super(name, price);
        this.brand = brand;
        this.warrantyInMonths = warrantyInMonths;
    }

    @Override
    public String getItemDetails() {
        return "Electronics: " + getName() + ", Brand: " + brand + ", Price: $" + getPrice() + ", Warranty: " + warrantyInMonths + " months";
    }
}

// Groceries Class
class Groceries extends WarehouseItem {
    private String expirationDate;

    public Groceries(String name, double price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public String getItemDetails() {
        return "Groceries: " + getName() + ", Price: $" + getPrice() + ", Expiration Date: " + expirationDate;
    }
}

// Furniture Class
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    public String getItemDetails() {
        return "Furniture: " + getName() + ", Material: " + material + ", Price: $" + getPrice();
    }
}

// Generic Storage Class


class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility Class for Displaying Items
class WarehouseUtility {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getItemDetails());
        }
    }
}

// Main Class to Demonstrate Functionality
public class Main {
    public static void main(String[] args) {
        // Create storage for each item type
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to electronics storage
        electronicsStorage.addItem(new Electronics("Laptop", 1200.00, "Dell", 24));
        electronicsStorage.addItem(new Electronics("Smartphone", 800.00, "Samsung", 12));

        // Add items to groceries storage
        groceriesStorage.addItem(new Groceries("Milk", 3.50, "2025-01-01"));
        groceriesStorage.addItem(new Groceries("Bread", 2.00, "2024-12-15"));

        // Add items to furniture storage
        furnitureStorage.addItem(new Furniture("Chair", 150.00, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 300.00, "Metal"));

        // Display all items using the wildcard method
        System.out.println("Electronics:");
        WarehouseUtility.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtility.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        WarehouseUtility.displayItems(furnitureStorage.getItems());
    }
}
