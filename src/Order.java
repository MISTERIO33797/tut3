import java.util.Date;

public class Order {
    private int id;
    private Customer customer;
    private Product[] products;
    private int[] quantities;
    private String orderDate;
    private String status;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Product[] getProducts() { return products; }
    public void setProducts(Product[] products) { this.products = products; }

    public int[] getQuantities() { return quantities; }
    public void setQuantities(int[] quantities) { this.quantities = quantities; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < products.length; i++) {
            total += products[i].getPrice() * quantities[i];
        }
        return total;
    }

    public void applyDiscount() {
        if (customer.isLoyalCustomer()) {
            for (int i = 0; i < products.length; i++) {
                double discountedPrice = products[i].getPrice() * 0.9;
                products[i].setPrice(discountedPrice);
            }
        }
    }

    public void displayDetails() {
        System.out.println("Order ID: " + id + ", Date: " + orderDate + ", Status: " + status);
        customer.displayInfo();
        for (int i = 0; i < products.length; i++) {
            products[i].displayInfo();
            System.out.println("Quantity: " + quantities[i]);
        }
        System.out.println("Total: $" + calculateTotalValue());
    }
}
