package LowLevelDesign.DesignVendingMachine;

public class Item {
    ItemType itemType;
    int price;

    public ItemType getType() {
        return itemType;
    }

    public void setType(ItemType type) {
        this.itemType = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
