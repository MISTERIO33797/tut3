public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isLoyalCustomer;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isLoyalCustomer() { return isLoyalCustomer; }
    public void setIsLoyalCustomer(boolean isLoyalCustomer) { this.isLoyalCustomer = isLoyalCustomer; }

    public void displayInfo() {
        System.out.println("Customer ID: " + id + ", Name: " + firstName + " " + lastName +
                ", Email: " + email + ", Loyal: " + isLoyalCustomer);
    }
}
