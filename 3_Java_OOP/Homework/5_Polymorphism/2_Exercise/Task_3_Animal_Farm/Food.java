package Task_3_Wild_Farm;

public abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.setQuantity(quantity);
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected int getQuantity() {
        return quantity;
    }
}