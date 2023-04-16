package my.uum;

public class Pack24 extends MineralWater{
    private double pricePerUnit = 12.00;
    private int quantity;
    private double totalPrice;

    public Pack24(){
    }

    public double calculatePrice(int q){
        this.quantity = q;
        this.totalPrice = this.quantity * this.pricePerUnit;
        return (double)this.totalPrice;
    }

    public int calculatePack(double price){
        return (int)(price / this.pricePerUnit);
    }

    public int calculateBottle(int bottle){
        return bottle / 24;
    }

}
