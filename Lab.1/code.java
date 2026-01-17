import java.util.*;

class Customer {
    private int id;
    private String name;
    private String email;
    private List<Order> orders = new ArrayList<>();

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}

class Employee {
    private int id;
    private String name;
    private String position;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}

class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    private Category category;

    public Product(int id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}

class Order {
    private int id;
    private Date date;
    private Customer customer;
    private Employee cashier;
    private List<OrderItem> items = new ArrayList<>();

    public Order(int id, Date date, Customer customer, Employee cashier) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.cashier = cashier;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }
}
}
