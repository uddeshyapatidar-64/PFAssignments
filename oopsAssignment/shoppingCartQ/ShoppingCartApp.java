// package PFAssignments.oopsAssignment.shoppingCartQ;
// import java.util.*;

// class CartException extends Exception {
//     public CartException(String message) {
//         super(message);
//     }
// }

// class Product {
//     private String id;
//     private String name;
//     private double price;
//     public Product(String id, String name, double price) {
//         if (price < 0) {
//             throw new IllegalArgumentException("Price can't be negative.");
//         }
//         this.id = id;
//         this.name = name;
//         this.price = price;
//     }
//     public String getId() { return id; }
//     public String getName() { return name; }
//     public double getPrice() { return price; }
// }

// class CartItem {
//     private Product product;
//     private int quantity;
//     public CartItem(Product product, int quantity) {
//         setQuantity(quantity);
//         this.product = product;
//     }
//     public Product getProduct() { return product; }
//     public int getQuantity() { return quantity; }
//     public void setQuantity(int quantity) {
//         if (quantity <= 0) {
//             throw new IllegalArgumentException("Quantity must be greater than 0.");
//         }
//         this.quantity = quantity;
//     }
//     public double getTotalPrice() {
//         return product.getPrice() * quantity;
//     }
// }

// // cart map
// class ShoppingCart {
//     private Map<String, CartItem> cart = new HashMap<>();
//     public Map<String, CartItem> getItems() {
//         return cart;
//     }
//     public void addItem(Product product, int quantity) throws CartException {
//         if (product == null) {
//             throw new CartException("Invalid product.");
//         }
//         if (quantity <= 0) {
//             throw new CartException("Quantity must be at least 1.");
//         }
//         String id = product.getId();
//         if (cart.containsKey(id)) {
//             CartItem existing = cart.get(id);
//             existing.setQuantity(existing.getQuantity() + quantity);
//         } else {
//             cart.put(id, new CartItem(product, quantity));
//         }
//     }

//     public void removeItem(String productId) throws CartException {
//         if (!cart.containsKey(productId)) {
//             throw new CartException("Item not in cart.");
//         }
//         cart.remove(productId);
//     }

//     public void updateQuantity(String productId, int newQuantity) throws CartException {
//         if (!cart.containsKey(productId)) {
//             throw new CartException("Item not in cart.");
//         }
//         if (newQuantity <= 0) {
//             throw new CartException("Quantity must be greater than 0.");
//         }
//         cart.get(productId).setQuantity(newQuantity);
//     }

//     public double calculateTotal() {
//         double total = 0;
//         for (CartItem item : cart.values()) {
//             total += item.getTotalPrice();
//         }
//         return total;
//     }

//     public void displayCart() {
//         if (cart.isEmpty()) {
//             System.out.println("Your cart is empty.");
//             return;
//         }
//         System.out.println("\nYour Cart:");
//         for (CartItem item : cart.values()) {
//             Product p = item.getProduct();
//             System.out.println(p.getName() + " (ID: " + p.getId() + ") - Price: " + p.getPrice() + " x " + item.getQuantity() + " = " + item.getTotalPrice());
//             }
//         System.out.println("Total Amount: " + calculateTotal());
//     }
// }

// public class ShoppingCartApp {

//     // Fixed product list
//     private static List<Product> catalog = List.of(
//         new Product("1", "Laptop", 50000),
//         new Product("2", "Wireless Mouse", 1000),
//         new Product("3", "Mechanical Keyboard", 3500),
//         new Product("4", "Headphones", 1200),
//         new Product("5", "Monitor", 21000)
//     );

//     public static void main(String[] args) {
//         ShoppingCart cart = new ShoppingCart();
//         Scanner scanner = new Scanner(System.in);
//         boolean running = true;

//         while (running) {
//             System.out.println("\nMenu :");
//             System.out.println("1. Add item to cart");
//             System.out.println("2. Remove item from cart");
//             System.out.println("3. Update item quantity");
//             System.out.println("4. View cart and total");
//             System.out.println("5. Exit");
//             System.out.print("Enter choice: ");

//             try {
//                 int choice = scanner.nextInt();
//                 scanner.nextLine(); 
//                 switch (choice) {
//                     case 1:
//                         showCatalog();
//                         System.out.print("Select product number (1-" + catalog.size() + "): ");
//                         int prodNum = scanner.nextInt();
//                         if (prodNum < 1 || prodNum > catalog.size()) {
//                             System.out.println("Invalid selection!");
//                             break;
//                         }
//                         Product selectedProduct = catalog.get(prodNum - 1);
//                         System.out.print("Enter quantity: ");
//                         int qty = scanner.nextInt();
//                         cart.addItem(selectedProduct, qty);
//                         System.out.println("Added " + qty + " " + selectedProduct.getName() + "to your cart.");
//                         break;

//                     case 2:
//                         if (cart.getItems().isEmpty()) {
//                             System.out.println("Cart is already empty.");
//                             break;
//                         }

//                         List<CartItem> cartList = new ArrayList<>(cart.getItems().values());
//                         System.out.println("\nSelect item to remove:");
//                         for (int i = 0; i < cartList.size(); i++) {
//                             CartItem item = cartList.get(i);
//                             System.out.println((i + 1) + ". " + item.getProduct().getName() + " (Qty: " + item.getQuantity() + ")");
//                         }
//                         System.out.print("Enter item number (1-" + cartList.size() + "): ");
//                         int removeNum = scanner.nextInt();
//                         if (removeNum < 1 || removeNum > cartList.size()) {
//                             System.out.println("Invalid choice!");
//                             break;
//                         }
//                         CartItem itemToRemove = cartList.get(removeNum - 1);
//                         cart.removeItem(itemToRemove.getProduct().getId());
//                         System.out.println("Removed " + itemToRemove.getProduct().getName() + " from cart");
//                         break;

//                     case 3:
//                         if (cart.getItems().isEmpty()) {
//                             System.out.println("Cart is empty.");
//                             break;
//                         }

//                         cart.displayCart();
//                         System.out.print("Enter Product ID to update: ");
//                         String updateId = scanner.nextLine().trim();

//                         System.out.print("Enter new quantity: ");
//                         int newQty = scanner.nextInt();

//                         cart.updateQuantity(updateId, newQty);
//                         System.out.println("Quantity updated.");
//                         break;

//                     case 4:
//                         cart.displayCart();
//                         break;

//                     case 5:
//                         running = false;
//                         break;

//                     default:
//                         System.out.println("Invalid option. Try again.");
//                 }

//             } catch (InputMismatchException e) {
//                 System.out.println("Error: Please enter numbers only.");
//                 scanner.nextLine(); 
//             } catch (CartException | IllegalArgumentException e) {
//                 System.out.println("Error: " + e.getMessage());
//             }
//         }
//         scanner.close();
//     }
//     private static void showCatalog() {
//         System.out.println("\nAvailable Products:" );
//         for (int i = 0; i < catalog.size(); i++) {
//             Product p = catalog.get(i);
//             System.out.println((i + 1) + ". " + p.getName() + " - " + p.getPrice());
//         }
//     }
// }