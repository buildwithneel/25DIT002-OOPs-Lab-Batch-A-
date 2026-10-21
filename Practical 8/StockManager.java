import java.util.HashMap;
import java.util.Map;

class OutOfStockException extends Exception {
    private final int shortfall;

    public OutOfStockException(String item, int shortfall) {
        super("Shortfall: " + shortfall);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    private final Map<String, Integer> inventory = new HashMap<>();

    public Warehouse() {
        inventory.put("Laptop", 10);
        inventory.put("Phone", 5);
        inventory.put("Headphones", 2);
    }

    public void issue(String item, int qty) throws OutOfStockException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Qty cannot be <= 0");
        }

        if (!inventory.containsKey(item)) {
            throw new OutOfStockException(item, qty);
        }

        int availableStock = inventory.get(item);

        if (qty > availableStock) {
            throw new OutOfStockException(item, qty - availableStock);
        }

        inventory.put(item, availableStock - qty);
        System.out.println("SUCCESS: Issued " + qty + " " + item);
    }
}

public class StockManager {
    static class OrderRequest {
        String item;
        int qty;

        OrderRequest(String item, int qty) {
            this.item = item;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        OrderRequest[] requests = {
            new OrderRequest("Laptop", 3),
            new OrderRequest("Phone", -2),
            new OrderRequest("Headphones", 5),
            new OrderRequest("Laptop", 4),
            new OrderRequest("Tablet", 1)
        };

        System.out.println("--- START BATCH ---");

        for (OrderRequest req : requests) {
            try {
                warehouse.issue(req.item, req.qty);
            } catch (OutOfStockException e) {
                System.out.println("ERROR: " + req.item + " -> " + e.getMessage());
            } catch (InvalidQuantityException e) {
                System.out.println("ERROR: " + req.item + " -> " + e.getMessage());
            }
        }

        System.out.println("--- END BATCH ---");
    }
}
