public class MonthlyReport{
    private String itemName;
    private int unitPrice;
    private int quantity;
    private boolean isExpense;
    public MonthlyReport(String itemName, boolean isExpense, int quantity, int unitPrice){
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;

    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}