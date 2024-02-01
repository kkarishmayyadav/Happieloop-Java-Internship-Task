import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: " + name + " | Price: $" + price + " | Quantity: " + quantity;
    }
}

 class ShoppingCart {
    private List<Product> cart = new ArrayList<>();

    public void addProduct(String name, double price, int quantity) {
        if (quantity > 0 && price > 0) {
            Product product = new Product(name, price, quantity);
            cart.add(product);
            System.out.println("Product added to the cart.");
        } else {
            System.out.println("Invalid input. Product not added to the cart.");
        }
    }

    public void removeProduct(String name) {
        for (Product product : cart) {
            if (product.getName().equals(name)) {
                cart.remove(product);
                System.out.println("Product removed from the cart.");
                return;
            }
        }
        System.out.println("Product not found in the cart.");
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Product product : cart) {
            totalCost += product.getPrice() * product.getQuantity();
        }
        return totalCost;
    }

    public void displayCartContents() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Shopping Cart Contents:");
            for (Product product : cart) {
                System.out.println(product);
            }
            System.out.println("Total Cost: $" + calculateTotalCost());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();

        while (true) {
            System.out.println("\nShopping Cart Menu:");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Cart Contents");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product price: $");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();
                    shoppingCart.addProduct(productName, productPrice, productQuantity);
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String productToRemove = scanner.nextLine();
                    shoppingCart.removeProduct(productToRemove);
                    break;
                case 3:
                    shoppingCart.displayCartContents();
                    break;
                case 4:
                    System.out.println("Exiting Shopping Cart. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

