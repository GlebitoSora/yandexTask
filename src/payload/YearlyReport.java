public class YearlyReport {
    private String month;
    private int amount;
    private boolean isExpense;
    public YearlyReport(String month, int amount, boolean isExpense){
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public int getAmount() {
        return amount;
    }

    public String getMonth() {
        return month;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
