import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    List<StoreItem> storeItems = new ArrayList<>();
    List<CartItem> cart = new ArrayList<>();


    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        //shows store items
        System.out.println("Welcome to the store!\nThese are our available items:\n");
        store.showStoredItems(store.storeItems);

        boolean storeIsOpen = true;
        while (storeIsOpen) {
            System.out.println("\nWhat would you like to do: ");
            System.out.println("1. Add to cart\n2. View cart\n3. Checkout\n");
            System.out.print("Command: ");
            String choice = scanner.next();

            switch (choice) {
                case "1" -> {
                    System.out.print("Item name: ");
                    String itemName = scanner.next().toLowerCase();
                    System.out.print("How many: ");
                    try {
                        int quantity = scanner.nextInt();
                        store.addToCart(itemName, quantity);
                    } catch (Exception e) {
                        System.out.println("\n{{Error}} something went wrong");
                    }
                }
                case "2" -> store.displayCartItems();
                case "3" -> storeIsOpen = false;
                default -> System.out.println("{{INVALID COMMAND}}");
            }
        }
    }


    public void addItems() {
        storeItems.add(new StoreItem("shoes", 89.99));
        storeItems.add(new StoreItem("bag", 29.99));
        storeItems.add(new StoreItem("jacket", 19.99));
        storeItems.add(new StoreItem("socks", 3.99));
        storeItems.add(new StoreItem("joggers", 11.99));
        storeItems.add(new StoreItem("shirt", 13.99));
    }

    public void addToCart(String itemName, int quantity) {
        StoreItem Item = null;
        for (StoreItem item : storeItems) {
            if (item.getItemName().equals(itemName))
                Item = item;
            //item is valid
        }
        if (Item == null) {
            System.out.println("Item not found");
            return;
        }

        //update cart
        boolean found = false;
        for (CartItem item : cart) {
            if (item.getStoreItem().equals(Item)) {
                item.setQuantity(quantity);
                System.out.println(quantity + "x " + Item.getItemName() + " added to cart");
            }
        }
        if (!found) {
            cart.add(new CartItem(Item, quantity));
            System.out.println(quantity + "x " + Item.getItemName() + " added to cart");
        }
    }

    public void displayCartItems() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (CartItem cartItem : cart) {
                System.out.println(cartItem.getStoreItem().getItemName().toUpperCase() + " - $" + cartItem.getStoreItem().getPrice() + " x" + cartItem.getQuantity());
            }
        }
    }

    public void showStoredItems(List<StoreItem> storeItems) {
        addItems();
        //getting items from storeItems array
        for (StoreItem item : storeItems) {
            System.out.println("[" + item.getItemName().toUpperCase() + "] --→ ($" + item.getPrice() + ")");
        }
    }
}
