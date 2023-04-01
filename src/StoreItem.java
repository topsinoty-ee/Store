public class StoreItem {

    private String itemName;
    private double price;

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public StoreItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }
}
