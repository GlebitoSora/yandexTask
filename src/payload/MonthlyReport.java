package payload;

public class MonthlyReport {
    private final String itemName;
    private final int unitPrice;
    private final int quantity;
    private final boolean isExpense;

    public MonthlyReport(String itemName, boolean isExpense, int quantity, int unitPrice) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;

    }

    public boolean isExpense() {
        return isExpense;
    }

    public String getItemName() {
        return itemName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "itemName='" + itemName + '\'' +
                ", isExpense=" + isExpense +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

}