import java.text.SimpleDateFormat;
import java.util.Date;

public class ComputerStore {
    private Product[] products = new Product[100];
    private Customer[] customers = new Customer[100];
    private Order[] orders = new Order[100];
    private int productCount = 0, customerCount = 0, orderCount = 0;

    public void addProduct(Product product) {
        products[productCount++] = product;
    }

    public void addCustomer(Customer customer) {
        customers[customerCount++] = customer;
    }

    public Order createOrder(Customer customer, Product[] products, int[] quantities) {
        Order order = new Order();
        order.setId(orderCount + 1);
        order.setCustomer(customer);
        order.setProducts(products);
        order.setQuantities(quantities);
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        order.setStatus("New");

        orders[orderCount++] = order;
        return order;
    }

    public void updateStockAfterOrder(Order order) {
        Product[] orderedProducts = order.getProducts();
        int[] quantities = order.getQuantities();

        for (int i = 0; i < orderedProducts.length; i++) {
            int remaining = orderedProducts[i].getStockQuantity() - quantities[i];
            orderedProducts[i].setStockQuantity(remaining);
        }
    }

    public void changeOrderStatus(int orderId, String newStatus) {
        for (Order order : orders) {
            if (order != null && order.getId() == orderId) {
                order.setStatus(newStatus);
                break;
            }
        }
    }

    public void displayProductsInCategory(String category) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                products[i].displayInfo();
            }
        }
    }

    public void displayCustomerOrders(int customerId) {
        for (Order order : orders) {
            if (order != null && order.getCustomer().getId() == customerId) {
                order.displayDetails();
            }
        }
    }
}