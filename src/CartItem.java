public class CartItem {
    private StoreItem storeItem;

    public StoreItem getStoreItem() {
        return storeItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public CartItem(StoreItem storeItem, int quantity) {
        this.storeItem = storeItem;
        this.quantity = quantity;
    }

}
