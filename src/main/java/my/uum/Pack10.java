package my.uum;

public class Pack10 extends MineralWater{
    private double pricePerUnit = 8.00;
    private int quantity;
    private double totalPrice;

    public Pack10(){
    }

    public double calculatePrice(int q){
        this.quantity = q;
        this.totalPrice = this.quantity * this.pricePerUnit;
        return this.totalPrice;
    }

    public int calculatePack(double price){
        return (int)(price / this.pricePerUnit);
    }

    public int calculateBottle(int bottle){
        return bottle / 10;
    }
}
