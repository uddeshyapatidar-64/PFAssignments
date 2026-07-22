package PFAssignments.oopsAssignment.shoppingCartQ;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<String, CartItem> cart = new HashMap<>();

    /**
     * Returns an unmodifiable view of cart items to protect internal state encapsulation.
     */
    public Map<String, CartItem> getItems() {
        return Collections.unmodifiableMap(cart);
    }

    public void addItem(Product product, int quantity) throws CartException {
        if (product == null) {
            throw new CartException("Invalid product details provided.");
        }
        if (quantity <= 0) {
            throw new CartException("Quantity must be at least 1.");
        }

        String id = product.getId();
        if (cart.containsKey(id)) {
            CartItem existing = cart.get(id);
            existing.setQuantity(existing.getQuantity() + quantity);
        } else {
            cart.put(id, new CartItem(product, quantity));
        }
    }

    public void removeItem(String productId) throws CartException {
        if (productId == null || !cart.containsKey(productId)) {
            throw new CartException("Item with ID '" + productId + "' not found in cart.");
        }
        cart.remove(productId);
    }

    public void updateQuantity(String productId, int newQuantity) throws CartException {
        if (productId == null || !cart.containsKey(productId)) {
            throw new CartException("Item with ID '" + productId + "' not found in cart.");
        }
        if (newQuantity <= 0) {
            throw new CartException("Quantity must be greater than 0.");
        }
        cart.get(productId).setQuantity(newQuantity);
    }

    public double calculateTotal() {
        return cart.values().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is currently empty.");
            return;
        }
        System.out.println("\n--- Your Shopping Cart ---");
        for (CartItem item : cart.values()) {
            Product p = item.getProduct();
            System.out.printf("%s (ID: %s) - Price: $%.2f x %d = $%.2f%n",
                    p.getName(), p.getId(), p.getPrice(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.printf("Total Amount: $%.2f%n", calculateTotal());
        System.out.println("--------------------------");
    }
}
