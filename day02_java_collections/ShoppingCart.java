package day02_java_collections;

import java.util.*;

// Class representing the Shopping Cart
public class ShoppingCart {
    // HashMap to store product prices
    private Map<String, Double> productPrices = new HashMap<>();

    // LinkedHashMap to maintain the order of items added
    private Map<String, Integer> cart = new LinkedHashMap<>();

    // Method to add a product with its price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Method to add an item to the cart
    public void addItemToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found: " + product);
        }
    }

    // Display items in the order they were added
    public void displayCartInOrder() {
        System.out.println("--- Cart Items in Order of Addition (LinkedHashMap) ---");
        cart.forEach((product, quantity) ->
                System.out.println(product + " (Quantity: " + quantity + ", Price: $" + productPrices.get(product) + ")"));
    }

    // Display items sorted by price using TreeMap
    public void displayCartSortedByPrice() {
        System.out.println("--- Cart Items Sorted by Price (TreeMap) ---");
        TreeMap<Double, List<String>> priceMap = new TreeMap<>();
        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            priceMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }
        priceMap.forEach((price, products) ->
                products.forEach(product ->
                        System.out.println(product + " (Quantity: " + cart.get(product) + ", Price: $" + price + ")")));
    }

    // Main method to run the Shopping Cart
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // Adding products
        shoppingCart.addProduct("Apple", 1.20);
        shoppingCart.addProduct("Banana", 0.50);
        shoppingCart.addProduct("Cherry", 2.00);

        // Adding items to cart
        shoppingCart.addItemToCart("Apple", 3);
        shoppingCart.addItemToCart("Banana", 5);
        shoppingCart.addItemToCart("Cherry", 2);

        // Displaying cart items
        shoppingCart.displayCartInOrder();
        shoppingCart.displayCartSortedByPrice();
    }
}
