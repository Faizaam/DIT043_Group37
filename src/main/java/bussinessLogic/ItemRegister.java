package bussinessLogic;

import java.util.Objects;

public class ItemRegister {
    private String itemID;
    private int soldUnits;
    private double totalProfit;
    private String itemInfo;

    public ItemRegister(String itemID, int amount, double totalProfit, String itemInfo){
        this.itemID = itemID;
        this.soldUnits = amount;
        this.totalProfit = totalProfit;
        this.itemInfo = itemInfo;
    }

    public String getItemID(){
        return this.itemID;
    }

    public String getItemInfo(){
        return this.itemInfo;
    }

    public double getTotalProfit(){
        return this.totalProfit;
    }

    public double addProfit(double totalPrice){
        this.totalProfit = this.totalProfit + totalPrice;
        return totalProfit;
    }

    public void addSoldUnit(int soldUnits){
        this.soldUnits = this.soldUnits + soldUnits;
    }

    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || !(anotherObject instanceof ItemRegister)) {
            return false;
        } else {
            ItemRegister itemProfit = (ItemRegister) anotherObject;
            return itemID == itemProfit.itemID;
        }
    }

    public int hashCode() {
        return Objects.hash(itemID);
    }

}
