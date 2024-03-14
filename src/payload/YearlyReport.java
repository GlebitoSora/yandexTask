package payload;

public class YearlyReport {
    private final String month;
    private final int amount;
    private final boolean isExpense;
    public static int averageProfitSumCounter;
    public static int averageSpendingSumCounter;

    public YearlyReport(String month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public String getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public void checkAverageProfitSum() {
        if (this.isExpense) {
            averageProfitSumCounter += this.amount;
        }
    }

    public void checkAverageSpendingSum() {
        if (!this.isExpense) {
            averageSpendingSumCounter += this.amount;
        }
    }

    @Override
    public String toString() {
        return "month='" + month + '\'' +
                ", amount=" + amount +
                ", isExpense=" + isExpense +
                '}';
    }
}
