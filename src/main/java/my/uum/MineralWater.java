package my.uum;

public abstract class MineralWater {
    protected double pricePerUnit;
    protected int quantity;

    public abstract double calculatePrice(int q);
}
